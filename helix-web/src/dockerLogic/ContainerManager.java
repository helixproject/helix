package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager implements ContainerManagement {

	public void createContainer(Container container) {
		String[] commands = {"docker","create","-e","MYSQL_ROOT_PASSWORD=default","mysql"};
		String[] result=ShellManager.execOnShell(commands);
		container.setId(result[0]);
		//debug
		System.out.println("oContainerManager >> "+result[0]);
		System.out.println("errors >> "+result[1]);
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

	@Override
	public int pauseContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int unpauseContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}
}