package security;

import java.security.MessageDigest;

public class Authentificator {
	
	public String hashPassword(String password){
		//this method just has a password in order to do authentification
		String hashedString="";
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] hashedBytes=md.digest(password.getBytes("UTF-8"));
			for (byte b : hashedBytes) {
				hashedString+=String.format("%02x", b);
			}
		}
		catch(Exception e){
			
		}
		return hashedString;
	}
	public String isUser(String login,String password){
		//it will return "customer" , "admin" or "no"
		String hashedPassword = hashPassword(password);
		//verify from database if he exists
		return null;
	}
}