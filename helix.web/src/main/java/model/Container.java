package model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Container {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String idDocker;
	private String name ;
	private int cpu ;
	private int ram ;
	private String status ;
	private String ip ;
	private String image;
	private Map<Integer,Integer> portsBindingMap;
	private String initPassword;
	@ManyToOne
	private Customer owner;

	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
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
	
	
	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public String getInitPassword() {
		return initPassword;
	}

	public void setInitPassword(String initPassword) {
		this.initPassword = initPassword;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdDocker() {
		return idDocker;
	}

	public void setIdDocker(String idDocker) {
		this.idDocker = idDocker;
	}

	public Map<Integer, Integer> getPortsBindingMap() {
		return portsBindingMap;
	}

	public void setPortsBinding(Map<Integer, Integer> portsBindingMap) {
		this.portsBindingMap = portsBindingMap;
	}
	
		
}
