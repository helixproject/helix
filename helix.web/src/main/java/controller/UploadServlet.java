package controller ;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import model.Customer;
import shellLogic.ServerUtils;
import shellLogic.ShellManager;

@WebServlet("/Upload")
public class UploadServlet extends HttpServlet {
	
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 10 * 1024 * 1024;
   private File file ;
   
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
	  Customer customer = (Customer)request.getSession(true).getAttribute("user");
	  String nameContainer = (String)request.getParameter("name");
	  filePath = "/helix/tmp/";
	  
	  String serverIp = ServerUtils.getServerInfoByAccout(customer.getAccount()).get(0);
	  
      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
      if(!isMultipart){
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }
      
      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setSizeMax(maxFileSize);

      try{ 
	      List fileItems = upload.parseRequest(request);
	      Iterator i = fileItems.iterator();
	
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Servlet upload</title>");  
	      out.println("</head>");
	      out.println("<body>");
	      String fileName = null ;
	      while (i.hasNext()) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if (!fi.isFormField())	
	         {
	            fileName = fi.getName();
	            file = new File(filePath+fileName);
	            fi.write(file) ;
	         }
	      }
	      
	      String[] mapping = {"/bin/bash","/helix/scripts/uploadWebApp.sh",fileName,serverIp,
	    		  "/helix/data-volume/"+customer.getLogin()+
	          		"/"+ nameContainer + "/"+fileName};
	      ShellManager.execOnShell(mapping);
  		
          out.println("<h2>The webapp "+fileName+" has been successfully uploaded.</h2>"+"</br>"
          		+ " you will be redirected to user home.");
          out.println("</br>");
	      out.println("</body>");
	      out.println("</html>");
	      response.setHeader("Refresh","3; URL=./userhome.jsp");
   }catch(Exception ex) {
       System.out.println(ex);
   }
   }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
       throw new ServletException("GET method used with " + getClass( ).getName( )+": POST method required.");
   } 
}