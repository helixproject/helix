package model;

import java.util.List;

public class Container {
	private String id;
	private String name ;
	private int cpu ;
	private int ram ;
	private String status ;
	private String ip ;
	private String image;
	private int port;
	private User user;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Container(String name, int cpu, int ram, String status,User user) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.status = status;
		this.user = user;
	}
	public Container(){}

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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Container(String id, String name, int cpu, int ram, String status,
			String ip, String image, int port, User user) {
		super();
		this.id = id;
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.status = status;
		this.ip = ip;
		this.image = image;
		this.port = port;
		this.user = user;
	}
	
		
}