package model;

public abstract class User {
	private String login;
	private String hashedPassword;
	
	public User(String login, String hashedPassword) {
		super();
		this.login = login;
		this.hashedPassword = hashedPassword;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
}
