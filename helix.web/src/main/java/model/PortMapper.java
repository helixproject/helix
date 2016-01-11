package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import daoImpl.DatabaseConnection;
import daoImpl.PortMapperDaoImpl;

@Entity
public class PortMapper {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int localPort;
	private int externalPort;
	
	public PortMapper(){}
	public PortMapper(int localPort){
		this.localPort=localPort;
	}
	public int getLocalPort() {
		return localPort;
	}
	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}
	public int getExternalPort() {
		return externalPort;
	}
	public void setExternalPort(int externalPort) {
		this.externalPort = externalPort;
	}
	private static int findFreePort(){
		return new PortMapperDaoImpl(new DatabaseConnection()).getMaxPort()+1;
	}
	public static void assignExternalPorts(List<PortMapper> portmappers){
		int n=findFreePort();
		for(int i=0;i<portmappers.size();i++){
			portmappers.get(i).setExternalPort(n+i);
		}
	}
}
