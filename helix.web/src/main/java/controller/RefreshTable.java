package controller;

import java.util.List;

import com.google.gson.Gson;

import daoImpl.DatabaseConnection;
import implementations.ContainerDaoImpl;
import implementations.DAOFactory;
import implementations.UserDaoImpl;
import model.Container;

/*
 * 
 * This is just a temporary test class, do not take it serious
 */

public class RefreshTable {
	
	public static String getContainerList(){
		
		//List<Container> listContainers=new daoImpl.ContainerDaoImpl(new DatabaseConnection()).uploadAllContainerOfUser((Customer)request.getAttribute("user")));
		//String json = new Gson().toJson(listContainers);
		return "";
	}
}
