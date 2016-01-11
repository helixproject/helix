package dockerLogic;

import java.util.ArrayList;
import shellLogic.SshManager;
import model.Container;
import model.PortMapper;

public class MysqlManager{
	private static String pathOfDockerFiles="/helix/servers/";
	
	public static String createMysql(Container container) {	

		ArrayList<PortMapper> portmappers=new ArrayList<PortMapper>();
		portmappers.add(new PortMapper(3306));
		PortMapper.assignExternalPorts(portmappers);
		container.setPortmappers(portmappers);
		
		String mapping="docker create -e MYSQL_ROOT_PASSWORD=password";
		mapping+=" -m "+container.getRam()+"M";
		mapping+=" -c "+container.getCpu();
		for(PortMapper portmapper:portmappers){
			mapping+=" -p "+portmapper.getExternalPort()+":"+portmapper.getLocalPort();
		}	
		mapping+=" mysql";
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		String result=SshManager.execOnDocker(dockerServerConf,mapping);
		return result;
	}
}