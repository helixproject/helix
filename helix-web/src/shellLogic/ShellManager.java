package shellLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellManager {
	
	public static String[] execOnShell(String[] command){
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
