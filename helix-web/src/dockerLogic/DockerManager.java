package dockerLogic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.Container;

public class DockerManager implements ContainerManagement {

	public void createContainer(Container container) {
		String[] commands = {"docker","create","-e","MYSQL_ROOT_PASSWORD=default","mysql"};
		String[] result=DockerManager.execOnShell(commands);
		container.setId(result[0]);
		
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
	}
	
	public int startContainer(Container container) {
		String[] commands = {"docker","start",container.getId()};
		String[] result=execOnShell(commands);
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
		return 0;
	}
	public int pauseContainer(Container container) {
		String[] commands = {"docker","pause",container.getId()};
		String[] result=execOnShell(commands);
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
		return 0;
	}
	public int unpauseContainer(Container container) {
		String[] commands = {"docker","unpause",container.getId()};
		String[] result=execOnShell(commands);
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
		return 0;
	}

	public int stopContainer(Container container) {
		String[] commands = {"docker","stop",container.getId()};
		String[] result=execOnShell(commands);
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
		return 0;
	}

	public int deleteContainer(Container container) {
		String[] commands = {"docker","rm",container.getId()};
		String[] result=execOnShell(commands);
		System.out.println("output >> "+result[0]);
		System.out.println("errors >> "+result[1]);
		return 0;
	}
	

	
}
