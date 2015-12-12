package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager implements ContainerManagement {

	public void createContainer(Container container) {
		if(container.getImage().equals("tomcat")){
			TomcatManagement t=new TomcatManager();
			container.setIdDocker(t.createTomcat());
		}
		else if(container.getImage().equals("mysql")){
			MysqlManagement t=new MysqlManager();
			container.setIdDocker(t.createMysql());
		}

	}
	
	public int startContainer(Container container) {
		String[] commands = {"docker","start",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		return 0;
	}

	public int stopContainer(Container container) {
		String[] commands = {"docker","stop",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		return 0;
	}

	public int deleteContainer(Container container) {
		String[] commands = {"docker","rm",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		return 0;
	}

	public int pauseContainer(Container container) {
		String[] commands = {"docker","pause",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		return 0;
	}

	public int unpauseContainer(Container container) {
		String[] commands = {"docker","unpause",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		return 0;
	}
}