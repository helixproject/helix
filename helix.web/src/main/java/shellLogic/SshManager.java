package shellLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import shellLogic.DockerServer;

public class SshManager{
	private static Map<String,DockerServer> connectedServers = new HashMap<String,DockerServer>();
	
	public static String execOnDocker(String dockerServerName,String command){
		if(connectedServers.get(dockerServerName)==null){
			String host=null,passwd=null,user=null;
			try{
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
				
				System.out.println("host ="+host+"  user:"+user+"  pass:"+passwd);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			DockerServer dockerserver=new DockerServer(host, user, passwd, dockerServerName);
			connectedServers.put(dockerServerName,dockerserver);
		}
		DockerServer dockerserver=connectedServers.get(dockerServerName);
		return dockerserver.sendCommand(command);
	}
	
	public static void disconnectServer(String dockerServerName){
		if(connectedServers.get(dockerServerName)!=null){
			connectedServers.get(dockerServerName).closeConnection();
			connectedServers.remove(dockerServerName);
		}
	}
}