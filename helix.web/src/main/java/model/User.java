package model;

public abstract class User {
	
	private int idUser ;
	private String login;
	private String hashedPassword;
	// whether the user is customer or admin
	private String role ;
	
	public User(String login, String hashedPassword) {
		this.login = login;
		this.hashedPassword = hashedPassword;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
