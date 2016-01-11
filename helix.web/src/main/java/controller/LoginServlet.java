package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import security.Authentificator;
import daoImpl.DatabaseConnection;
import daoImpl.UserDaoImpl;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String hashedPassword=Authentificator.hashPassword(password);
		User user=new UserDaoImpl(new DatabaseConnection()).uploadUser(login,hashedPassword);
		if(user!=null){
			request.getSession(true).setAttribute("user",user);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		else{
			request.setAttribute("par","bad login/password");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	}

}
