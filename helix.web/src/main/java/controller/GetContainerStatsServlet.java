package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcraft.jsch.Session;

import daoImpl.ContainerDaoImpl;
import daoImpl.DatabaseConnection;
import model.Container;
import model.Customer;
import model.Stats;
import model.User;
import shellLogic.ShellManager;
import shellLogic.SshManager;

@WebServlet("/GetContainerStats")
public class GetContainerStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String pathOfDockerFiles="/helix/servers/";
    public GetContainerStatsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idContainer = (String)request.getParameter("idContainer");
		String command = "docker stats --no-stream=true "+idContainer+" | sed -n 2p";
		Customer customer = (Customer)request.getSession(true).getAttribute("user");
		String dockerServerConf=pathOfDockerFiles+customer.getAccount()+".conf";
				
		String out = SshManager.execOnDocker(dockerServerConf,command);
		String[] stats = out.split("\\s+");
		stats[0] = stats[0].substring(0, Math.min(stats[0].length(), 12));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Stats stat = new Stats(dateFormat.format(date),stats[0],stats[1],stats[2]+stats[3],stats[5]+stats[6],stats[7]);		
		String json = new Gson().toJson(stat);
		String output = "{\"data\":["+json+"]}";
		
		response.setContentType("application/json");   
		PrintWriter o = response.getWriter();
		o.print(output);
		o.flush();
		response.addHeader("Refresh", "1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
