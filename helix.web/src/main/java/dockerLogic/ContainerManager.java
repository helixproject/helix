package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager{

	private String pathOfDockerFiles="/helix/servers/";
	
	public String createContainer(String login, Container container) {
		String id = null ;
		if(container.getImage().equals("tomcat")){
			id=TomcatManager.createTomcat(login,container);
			container.setIdDocker(id);
			container.setStatus("created");
		}
		else if(container.getImage().equals("mysql")){
			id=MysqlManager.createMysql(container);
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
	
	public int doCheckpoint(Container container) {
		String command ="docker checkpoint "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("checkpointed");
		return 0;
	}
	
	public int doCheckpointLeaveRunning(Container container) {
		String command ="docker checkpoint --leave-running "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("up(checkpointed)");
		return 0;
	}
	
	public int restoreCheckpoint(Container container) {
		String command ="docker restore "+container.getIdDocker();
		String dockerServerConf=pathOfDockerFiles+container.getOwner().getAccount()+".conf";
		SshManager.execOnDocker(dockerServerConf,command);
		container.setStatus("up");
		return 0;
	}
}