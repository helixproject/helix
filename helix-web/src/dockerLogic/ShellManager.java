package dockerLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Container;

public class ShellManager implements ContainerManagement {

	public void createContainer(Container container) {
		String ip="192.168.1.1";
		String idContainerSurDocker = null;//="aze845azd5za4daz";		
		//ArrayList<String> result=execOnShell("/bin/bash","docker","");
		String[] commands = {"docker","run","--name=testYuanbo","-e","MYSQL_ROOT_PASSWORD=yuanbo","-d","mysql"};
		ArrayList<String>[] result=ryanLogic(commands);
		container.setIp(ip);
		container.setIdContainerSurDocker(idContainerSurDocker);
	}
	
	public int startContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int stopContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}
	public ArrayList<String>[] execOnShell(String shellPath,String cmd,String param){
		ArrayList<String>[] result = (ArrayList<String>[])new ArrayList[2];
		ArrayList<String> cmd_output = new ArrayList<String>();
		ArrayList<String> error_output = new ArrayList<String>();
		try {
			Runtime rt = Runtime.getRuntime();
			String[] commands = {shellPath, cmd, param};
			Process proc;
			proc = rt.exec(commands);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				cmd_output.add(s);
			}
			while ((s = stdError.readLine()) != null) {
				error_output.add(s);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		result[0] = cmd_output;
		result[1] =  error_output;
		return result;
	}
	public ArrayList<String>[] ryanLogic(String[] commands){
		ArrayList<String>[] result = (ArrayList<String>[])new ArrayList[2];
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc;
			proc = rt.exec(commands);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				result[0].add(s);
			}
			while ((s = stdError.readLine()) != null) {
				result[1].add(s);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
