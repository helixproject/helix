package dockerLogic;

import model.Container;
import shellLogic.*;

public class ContainerManager implements ContainerManagement {

	public void createContainer(Container container) {
		if(container.getImage().equals("tomcat")){
			TomcatManagement t=new TomcatManager();
			container.setId(t.createTomcat(container.getInitPassword()));
		}
		else if(container.getImage().equals("mysql")){
			MysqlManagement t=new MysqlManager();
			container.setId(t.createMysql(container.getInitPassword()));
		}

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

	public int pauseContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int unpauseContainer(Container container) {
		// TODO Auto-generated method stub
		return 0;
	}
}