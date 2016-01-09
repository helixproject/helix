package model;

public class Stats {
	private String time;
	private String id ;
	private String cpu_per;
	private String mem_usage;
	private String mem_limit ;
	private String mem_per;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpu_per() {
		return cpu_per;
	}
	public void setCpu_per(String cpu_per) {
		this.cpu_per = cpu_per;
	}
	public String getMem_usage() {
		return mem_usage;
	}
	public void setMem_usage(String mem_usage) {
		this.mem_usage = mem_usage;
	}
	public String getMem_limit() {
		return mem_limit;
	}
	public void setMem_limit(String mem_limit) {
		this.mem_limit = mem_limit;
	}
	public String getMem_per() {
		return mem_per;
	}
	public void setMem_per(String mem_per) {
		this.mem_per = mem_per;
	}
	
	public Stats(String time, String id, String cpu_per, String mem_usage, String mem_limit,
			String mem_per) {
		super();
		this.time = time ;
		this.id = id;
		this.cpu_per = cpu_per;
		this.mem_usage = mem_usage;
		this.mem_limit = mem_limit;
		this.mem_per = mem_per;
	}
	

}
