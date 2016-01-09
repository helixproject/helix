/* 
 * SSHManager
 * 
 * @author cabbott
 * @version 1.0
 */
package shellLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.StringTokenizer;

public class SshManager{
	private static Map<String,dockerServer> connectedServers;
	
	public String execOnDocker(String dockerServerName,String command){
		if(connectedServers.get(dockerServerName)==null){
			String host=null,passwd=null,user=null;
			try{
				//TO BE CHECKED
				BufferedReader bfr=new BufferedReader(new FileReader(dockerServerName));

				String line=bfr.readLine();
				StringTokenizer st=new StringTokenizer(line,"=");
				st.nextToken();
				host=st.nextToken();

				line=bfr.readLine();
				st=new StringTokenizer(line,"=");
				st.nextToken();
				user=st.nextToken();

				line=bfr.readLine();
				st=new StringTokenizer(line,"=");
				st.nextToken();
				passwd=st.nextToken();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			dockerServer dockerserver=new dockerServer(host, user, passwd,dockerServerName);
			connectedServers.put(dockerServerName,dockerserver);
		}
		dockerServer dockerserver=connectedServers.get(dockerServerName);
		return dockerserver.sendCommand(command);
	}
	
	public static void disconnectServer(String dockerServerName){
		if(connectedServers.get(dockerServerName)!=null){
			connectedServers.get(dockerServerName).closeConnection();
			connectedServers.remove(dockerServerName);
		}
	}
}