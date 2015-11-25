package model;

public class Container {
	
	private String name ;
	private String cpu ;
	private String memory ;
	private String storage ;
	private String webserver ;
	private String database ;
	
	public Container(String name, String cpu, String memory, String storage,
			String webserver, String database) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.storage = storage;
		this.webserver = webserver;
		this.database = database;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getWebserver() {
		return webserver;
	}

	public void setWebserver(String webserver) {
		this.webserver = webserver;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
	
	
	

}
