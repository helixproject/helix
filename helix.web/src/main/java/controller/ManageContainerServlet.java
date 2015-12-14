package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageContainer")
public class ManageContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManageContainerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String idContainer = request.getParameter("id");
		if(action.equals("play")){
			
		}
		else if(action.equals("stop")){
			
		}
		else if(action.equals("pause")){
			
		}
		else{
			
		}
		request.getRequestDispatcher("userhome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}