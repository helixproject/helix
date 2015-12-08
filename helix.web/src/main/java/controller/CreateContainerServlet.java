package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Container;
import model.Customer;
import model.User;
import dockerLogic.ContainerManager;
import implementations.ContainerDaoImpl;
import implementations.DAOFactory;

@WebServlet("/CreateContainerServlet")
public class CreateContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateContainerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ContainerManager().createContainer(new Container());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		int cpu=Integer.parseInt(request.getParameter("cpu"));
		int ram=Integer.parseInt(request.getParameter("ram"));
		
		//User user=(User) request.getSession(true).getAttribute("user");
		
		User user = new Customer("customer","7c2ab87a34395892f10413db233c6420","gold");
		Container container = new Container(name, cpu, ram, "down", user);
		
		new ContainerManager().createContainer(container);
		ContainerDaoImpl a = new ContainerDaoImpl(DAOFactory.getInstance());
		a.persistContainer(container);
		
		Gson gson = new Gson();
		String container_json = gson.toJson(container);
		
    	request.setAttribute("json_output", container_json);
    	request.getRequestDispatcher("Success.jsp").forward(request, response);
	}
}