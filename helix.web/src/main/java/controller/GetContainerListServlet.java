package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import daoImpl.ContainerDaoImpl;
import daoImpl.DatabaseConnection;
import model.Container;
import model.Customer;

@WebServlet("/GetContainerList")
public class GetContainerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetContainerListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = (Customer)request.getSession(true).getAttribute("user");
		DatabaseConnection dbc = new DatabaseConnection();
		ContainerDaoImpl dao = new ContainerDaoImpl(dbc);
		List<Container> l = new ArrayList<Container>();
		l = dao.uploadAllContainerOfUser(customer);

		String json = new Gson().toJson(l);
		String output = "{\"data\":"+json+"}";
		
		response.setContentType("application/json");   
		PrintWriter out = response.getWriter();
		out.print(output);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
