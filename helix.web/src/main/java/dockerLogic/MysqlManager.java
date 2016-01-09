package dockerLogic;

import java.util.ArrayList;

import shellLogic.ShellManager;
import model.Container;
import model.PortMapper;

public class MysqlManager{

	
	public static String createMysql(Container container) {		
		ArrayList<PortMapper> portmappers=new ArrayList<PortMapper>();
		portmappers.add(new PortMapper(3306));
		portmappers.add(new PortMapper(22));
		PortMapper.assignExternalPorts(portmappers);
		container.setPortmappers(portmappers);
		
		String mapping="docker create -e MYSQL_ROOT_PASSWORD=password";
		for(PortMapper portmapper:portmappers){
			mapping+=" -p "+portmapper.getExternalPort()+":"+portmapper.getLocalPort();
		}	
		mapping+=" rshipp/insecure-mysql-ssh";
		String[] commands = mapping.split(" ");
		String[] result=ShellManager.execOnShell(commands);
		return result[0];
	}

}
