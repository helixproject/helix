package model;

import javax.persistence.Entity;

@Entity
public class Customer extends User{
	
	private String account;
	private String email;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
