package shellLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ServerUtils {
	
	private static String pathOfDockerFiles = "/helix/servers";
	
	public static ArrayList<String> getServerInfoByAccout(String account){
		ArrayList<String> info = null ;
		try {
			String pathConf="/helix/servers/"+account+".conf";
			BufferedReader bfr=new BufferedReader(new FileReader(pathConf));
			info = new ArrayList<String>();
			
			String line;
			line = bfr.readLine();
	
			StringTokenizer st=new StringTokenizer(line,"=");
			st.nextToken();
			info.add(st.nextToken());
	
			line=bfr.readLine();
			st=new StringTokenizer(line,"=");
			st.nextToken();
			info.add(st.nextToken());
	
			line=bfr.readLine();
			st=new StringTokenizer(line,"=");
			st.nextToken();
			info.add(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return info ;
	}
	
	public static String getPathOfDockerFiles() {
		return pathOfDockerFiles;
	}

	public void setPathOfDockerFiles(String pathOfDockerFiles) {
		this.pathOfDockerFiles = pathOfDockerFiles;
	}
}
