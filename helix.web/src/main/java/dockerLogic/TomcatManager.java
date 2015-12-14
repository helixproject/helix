package dockerLogic;
import java.util.ArrayList;

import model.Container;
import model.PortMapper;
import shellLogic.ShellManager;

public class TomcatManager{

	//with port redirection
	public String createTomcat(Container container) {
		ArrayList<PortMapper> portmappers=new ArrayList<PortMapper>();
		portmappers.add(new PortMapper(8080));
		portmappers.add(new PortMapper(22));
		PortMapper.assignExternalPorts(portmappers);
		container.setPortmappers(portmappers);
		
		String mapping="docker create";
		for(PortMapper portmapper:portmappers){
			mapping+=" -p "+portmapper.getExternalPort()+":"+portmapper.getLocalPort();
		}	
		mapping+=" rshipp/insecure-tomcat-ssh";
		String[] commands = mapping.split(" ");
		String[] result=ShellManager.execOnShell(commands);
		return result[0];
	}
}
