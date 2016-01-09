package dockerLogic;

import java.util.ArrayList;

import model.Container;
import model.PortMapper;
import shellLogic.ShellManager;
import shellLogic.SshManager;

public class TomcatManager{
	private static String pathOfDockerFiles="/root/helix/";
	
	//with port redirection
	public static String createTomcat(Container container) {
		ArrayList<PortMapper> portmappers=new ArrayList<PortMapper>();
		portmappers.add(new PortMapper(8080));
		PortMapper.assignExternalPorts(portmappers);
		container.setPortmappers(portmappers);
		String mapping="docker create";
		for(PortMapper portmapper:portmappers){
			mapping+=" -p "+portmapper.getExternalPort()+":"+portmapper.getLocalPort();
		}
		mapping+=" -v /helix/container-data-volume/"+container.getOwner().getLogin()+":/usr/local/tomcat/webapps/";
		mapping+=" tomcat";
		
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		String result=SshManager.execOnDocker(dockerServerConf,mapping);
		return result;
	}
}
