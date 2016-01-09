package controller;

import shellLogic.ShellManager;

public class DataVolumeManager {
	
	public static void createUserDataVolume(String login){
		String mapping="mkdir";
		mapping+=" /helix/container-data-volume/"+login;
		String[] commands = mapping.split(" ");
		ShellManager.execOnShell(commands);
	}
	
	public static void createContainerDataVolume(String login){
		String mapping="mkdir";
		mapping+=" /helix/container-data-volume/"+login;
		String[] commands = mapping.split(" ");
		ShellManager.execOnShell(commands);
	}
}