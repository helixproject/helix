package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager{

	public String createContainer(Container container) {
		String id = null ;
		if(container.getImage().equals("tomcat")){
			id=TomcatManager.createTomcat(container);
			id=id.substring(0,id.length()-1);
			container.setIdDocker(id);
			container.setStatus("created");
		}
		else if(container.getImage().equals("mysql")){
			id=MysqlManager.createMysql(container);
			id=id.substring(0,id.length()-1);
			container.setIdDocker(id);
			container.setStatus("created");
		}
		return id;
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
	//g modifie ça yuanbo tu avais mi /bin/bash alors que tu doi mettre docker et les status aussi
	public int doCheckpoint(Container container) {
		String[] commands = {"docker","checkpoint",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		container.setStatus("checkpointed");
		return 0;
	}
	
	public int restoreCheckpoint(Container container) {
		String[] commands = {"docker","checkpoint",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		container.setStatus("up");
		return 0;
	}
	
	//ça sert a quoi ça ?
	public int exportCheckpoint(Container container) {
		String[] commands = {"docker","checkpoint",container.getIdDocker()};
		String[] result=ShellManager.execOnShell(commands);
		container.setStatus("up");
		return 0;
	}
}