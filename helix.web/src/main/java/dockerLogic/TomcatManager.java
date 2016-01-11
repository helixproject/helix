package dockerLogic;

import java.util.ArrayList;
import controller.DataVolumeManager;
import model.Container;
import model.PortMapper;
import shellLogic.ServerUtils;
import shellLogic.SshManager;

public class TomcatManager{
	
	private static String pathOfDockerFiles="/helix/servers/";
	
	public static String createTomcat(String login, Container container) {
		ArrayList<PortMapper> portmappers=new ArrayList<PortMapper>();
		portmappers.add(new PortMapper(8080));
		portmappers.add(new PortMapper(6789));
		PortMapper.assignExternalPorts(portmappers);
		container.setPortmappers(portmappers);
		DataVolumeManager.createContainerDataVolume(container);
		String mapping="docker create";
		for(PortMapper portmapper:portmappers){
			mapping+=" -p "+portmapper.getExternalPort()+":"+portmapper.getLocalPort();
		}
		mapping+=" -v /helix/data-volume/"+login+"/"+container.getName()+":/usr/local/tomcat/webapps/";
		mapping+=" -m "+container.getRam()+"M";
		mapping+=" -c "+container.getCpu();
		mapping+=" rshipp/insecure-tomcat-ssh";

		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		String result=SshManager.execOnDocker(dockerServerConf,mapping);
		String hostIp = ServerUtils.getServerInfoByAccout("host").get(0);
		  
        String cmd = "scp root@"+hostIp+":/helix/demo-webapps/DemoWebapp.war"+
        " /helix/data-volume/"+container.getOwner().getLogin()+
        		"/"+ container.getName() + "/ROOT.war";
		SshManager.execOnDocker(dockerServerConf,cmd);
		return result;
	}
}
