package main;

import com.google.gson.Gson;
import implementations.DAOFactory;
import implementations.UserDaoImpl;
import model.Customer;
import model.User;

public class mainCLass {
	
	public static void main (String[] args) {
	
	/*
	
	// Test JSON
	
	Customer a = new Customer("a", "lalala", "lala");
	Gson gson = new Gson();
	String container_json = gson.toJson(a);
	System.out.println(container_json);
	}
	
	*/
		


		UserDaoImpl u = new UserDaoImpl(DAOFactory.getInstance());
		User a = u.getUserByLogin("customer");
		System.out.println(a.getRole());

}
}