package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager{

	public void createContainer(Container container) {
		if(container.getImage().equals("tomcat")){
			String id=new TomcatManager().createTomcat(container);
			id=id.substring(0,id.length()-1);
			container.setIdDocker(id);
			container.setStatus("created");
		}
		else if(container.getImage().equals("mysql")){
			container.setIdDocker(new MysqlManager().createMysql());
			container.setStatus("created");
		}
	}
	
	public int startContainer(Container container) {
		String[] commands = {"docker","start",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		container.setStatus("up");
		return 0;
	}

	public int stopContainer(Container container) {
		String[] commands = {"docker","stop",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		container.setStatus("down");
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
		container.setStatus("paused");
		return 0;
	}

	public int unpauseContainer(Container container) {
		String[] commands = {"docker","unpause",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		container.setStatus("up");
		return 0;
	}
}