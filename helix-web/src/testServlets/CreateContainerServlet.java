package testServlets;

import implementations.ContainerDaoImpl;
import implementations.DAOFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Container;
import model.Customer;
import model.User;
import dockerLogic.ShellManager;

/**
 * Servlet implementation class CreateContainerServlet
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
		// TODO Auto-generated method stub
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
		new ShellManager().createContainer(container);
		new ContainerDaoImpl(DAOFactory.getInstance()).persistContainer(container);
	}

}
