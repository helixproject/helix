package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ContainerDaoImpl;
import daoImpl.DatabaseConnection;
import dockerLogic.ContainerManager;
import model.Container;

@WebServlet("/ManageContainer")
public class ManageContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManageContainerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String idContainer = request.getParameter("id");
		DatabaseConnection dbc = new DatabaseConnection();
		ContainerDaoImpl dao = new ContainerDaoImpl(dbc);
		Container container = dao.uploadContainer(idContainer);
		ContainerManager m = new ContainerManager();
		
		if(action.equals("play")){
			m.startContainer(container);	
		}
		else if(action.equals("stop")){
			m.stopContainer(container);
		}
		else if(action.equals("pause")){
			m.pauseContainer(container);
		}
		else if(action.equals("unpause")){
			m.unpauseContainer(container);
		}
		dao.modifyContainer(container);
		request.getRequestDispatcher("userhome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}