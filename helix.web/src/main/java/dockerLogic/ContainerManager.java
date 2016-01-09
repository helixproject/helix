package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager{
	private String pathOfDockerFiles="/root/helix/";
	public String createContainer(Container container) {
		String id = null ;
		if(container.getImage().equals("tomcat")){
			id=TomcatManager.createTomcat(container);
			//OLD VERSION
			//id=id.substring(0,id.length()-1);
			container.setIdDocker(id);
			container.setStatus("created");
		}
		else if(container.getImage().equals("mysql")){
			id=MysqlManager.createMysql(container);
			//OLD VERSION
			//id=id.substring(0,id.length()-1);
			container.setIdDocker(id);
			container.setStatus("created");
		}
		return id;
	}
	
	public int startContainer(Container container) {
		String command ="docker start "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("up");
		return 0;
	}

	public int stopContainer(Container container) {
		String command ="docker stop "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("down");
		return 0;
	}

	public int deleteContainer(Container container) {
		String command ="docker rm "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		return 0;
	}

	public int pauseContainer(Container container) {
		String command ="docker pause "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("paused");
		return 0;
	}

	public int unpauseContainer(Container container) {
		String command ="docker unpause "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("up");
		return 0;
	}
	
	//NOT IMPLEMENTED YET
	//g modifie ça yuanbo tu avais mi /bin/bash alors que tu doi mettre docker et les status aussi
	public int doCheckpoint(Container container) {
		String command ="docker checkpoint "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		return 0;
	}
	
	public int restoreCheckpoint(Container container) {
		String command ="docker restore "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
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