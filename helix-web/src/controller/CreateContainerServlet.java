package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 * Servlet implementation class CreateContainerServlet
 */
@WebServlet("/create_container_servlet")
public class CreateContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateContainerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hhh");
		String name = (String)request.getAttribute("container_name");
		String cpu = (String)request.getAttribute("cpu");
		String memory = (String)request.getAttribute("memory");
		String storage = (String)request.getAttribute("storage");
		String webserver = (String)request.getAttribute("webserver");
		String database = (String)request.getAttribute("database");
		//Container c = new Container(name, cpu, memory, storage, webserver, database);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
