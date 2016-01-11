package controller;

import model.Container;
import model.Customer;
import shellLogic.SshManager;

public class DataVolumeManager {
	
	private static String pathOfDockerFiles="/helix/servers/";
	
	public static void createUserDataVolume(Customer customer){
		String mapping="mkdir";
		mapping+=" /helix/data-volume/"+customer.getLogin();
		
		String dockerServerConf=pathOfDockerFiles+customer.getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,mapping);
	}
	
	public static void createContainerDataVolume(Container container){
		String mapping="mkdir";
		mapping+=" /helix/data-volume/"+container.getOwner().getLogin()+"/"+container.getName();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,mapping);
	}
}