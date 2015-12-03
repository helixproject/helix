package dockerLogic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.Container;

public class ShellManager implements ContainerManagement {

	public void createContainer(Container container) {
		String[] commands = {"docker","create","-e","MYSQL_ROOT_PASSWORD=default","mysql"};
		String[] result=execOnShell(commands);
		container.setId(result[0]);
		
		//debug
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
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
	
	public String[] execOnShell(String[] command){
		Runtime rt = Runtime.getRuntime();
		Process proc;
		String[] result=new String[2];
		try {
			proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String temp="";
			result[0]="";
			result[1]="";
			while ((temp = stdInput.readLine()) != null) {
				result[0]+=temp+"\n";
			}
			while ((temp = stdError.readLine()) != null) {
				result[1]+=temp+"\n";
			}
		} 
		catch (IOException e) {	
			e.printStackTrace();
		}
		finally{
			return result;
		}
	}
	
}
