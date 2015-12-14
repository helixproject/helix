package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import security.Authentificator;
import model.Customer;
import daoImpl.DatabaseConnection;
import daoImpl.UserDaoImpl;

@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public SignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

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
				request.getRequestDispatcher("login.jsp").forward(request,response);
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
