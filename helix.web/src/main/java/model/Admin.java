package model;

public class Admin extends User{

	public Admin(String login, String hashedPassword) {
		super(login, hashedPassword);
		this.setRole("Admin");
	}
}