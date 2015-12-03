package dockerLogic;

import model.Container;

public class ShellManager implements ContainerManagement {

	public void createContainer(Container container){
		//unavailable code
		String ip="192.168.1.1";
		String idContainerSurDocker="aze845azd5za4daz";
		
				
		container.setIp(ip);
		container.setIdContainerSurDocker(idContainerSurDocker);
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
}
