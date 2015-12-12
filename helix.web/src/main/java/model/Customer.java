package model;

public class Customer extends User{
	
	// type of membership
	private String type;

	public Customer(String login, String hashedPassword, String type) {
		super(login, hashedPassword);
		this.setRole("Customer");
		this.type = type ;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
