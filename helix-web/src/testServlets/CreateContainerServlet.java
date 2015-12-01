package testServlets;

import implementations.ContainerDaoImpl;
import implementations.DAOFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.security.MD5Encoder;

import dockerLogic.ContainerManager;
import sun.security.provider.MD5;
import model.Container;
import model.Customer;
import model.User;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/CreateContainerServlet")
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
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/Servlet2");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int cpu=Integer.parseInt(request.getParameter("cpu"));
		int ram=Integer.parseInt(request.getParameter("ram"));
		
		request.getSession().setAttribute("user",new Customer("test","xAZWALS554aZza","gold"));
		User user=(User) request.getSession().getAttribute("user");
		
		Container container=new Container(name, cpu, ram,"down", user);
		new ContainerManager().createContainer(container);
		new ContainerDaoImpl(DAOFactory.getInstance()).persistContainer(container);
	}

}
