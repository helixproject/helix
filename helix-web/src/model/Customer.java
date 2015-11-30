package model;

public class Customer extends User{
	
	
	public Customer(String login, String hashedPassword, String kindOfMembership) {
		super(login, hashedPassword);
		this.kindOfMembership = kindOfMembership;
	}

	private String kindOfMembership;

	public String getKindOfMembership() {
		return kindOfMembership;
	}

	public void setKindOfMembership(String kindOfMembership) {
		this.kindOfMembership = kindOfMembership;
	}
	
}
