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

import daoImpl.ContainerDaoImpl;
import daoImpl.DatabaseConnection;
import model.Container;
import model.Customer;
import model.Stats;
import shellLogic.ShellManager;

@WebServlet("/GetContainerStats")
public class GetContainerStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetContainerStatsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idContainer = (String)request.getSession(true).getAttribute("idContainer");
		String[] commands = {"/bin/sh","-c","docker stats --no-stream=true "+idContainer+" | sed -n 2p"};
		String[] result = ShellManager.execOnShell(commands);
		String out = result[0] ;
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
