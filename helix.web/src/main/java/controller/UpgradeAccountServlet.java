package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import daoImpl.DatabaseConnection;
import daoImpl.UserDaoImpl;

public class UpgradeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpgradeAccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer=(Customer)request.getSession(true).getAttribute("user");
		customer.setAccount("premium");
		new UserDaoImpl(new DatabaseConnection()).modifyUser(customer);
	}
}
