package model;

public class Container {
	
	private String name ;
	private int cpu ;
	private int ram ;
	private String status ;
	private String ip ;
	private User user;
	
	public Container(String name, int cpu, int ram, String status, String ip,
			User user) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.status = status;
		this.ip = ip;
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
		
}