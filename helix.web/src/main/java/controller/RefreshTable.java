package controller;

import java.util.List;

import com.google.gson.Gson;

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
		
		ContainerDaoImpl c = new ContainerDaoImpl(DAOFactory.getInstance());
		UserDaoImpl u = new UserDaoImpl(DAOFactory.getInstance());
		List<Container> l = c.uploadAllContainer(u.getUserByLogin("customer"));

		String json = new Gson().toJson(l);
		return json;
	}
}
