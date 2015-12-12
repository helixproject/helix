package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.Authentificator;
import model.Customer;
import model.User;
import daoImpl.DatabaseConnection;
import daoImpl.UserDaoImpl;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		String email=request.getParameter("email");
		String account=request.getParameter("account");
		if(password.equals(cpassword)){
			if(!(new UserDaoImpl(new DatabaseConnection()).isUser(login))){
				Customer customer=new Customer();
				customer.setAccount(account);
				customer.setEmail(email);
				customer.setLogin(login);
				String hashedPassword=Authentificator.hashPassword(password) ;
				customer.setHashedPassword(hashedPassword);
				new UserDaoImpl(new DatabaseConnection()).persistUser(customer);
				request.getRequestDispatcher("success.jsp").forward(request,response);
			}
			else{
				request.setAttribute("par","login already used");
				request.getRequestDispatcher("error.jsp").forward(request,response);
			}
		}
		else{
			request.setAttribute("par","password diff de confirmed password");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	}

}
