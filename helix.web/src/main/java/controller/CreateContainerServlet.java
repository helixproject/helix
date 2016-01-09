package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Container;
import model.Customer;
import model.User;
import daoImpl.ContainerDaoImpl;
import daoImpl.DatabaseConnection;
import dockerLogic.ContainerManager;

@WebServlet("/CreateContainer")
public class CreateContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateContainerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int cpu=Integer.parseInt(request.getParameter("cpu"));
		int ram=Integer.parseInt(request.getParameter("ram"));
		String image=request.getParameter("image");
		User user = (User) request.getSession(true).getAttribute("user");
		Container container=new Container();
		container.setCpu(cpu);
		container.setRam(ram);
		container.setName(name);
		container.setImage(image);
		container.setOwner((Customer)user);
		new ContainerManager().createContainer(container);
		new ContainerDaoImpl(new DatabaseConnection()).persistContainer(container);
    	response.sendRedirect("userhome.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}