package dockerLogic;

import model.Container;

public class Migrator {

	public static void migrateContainer(Container container){
		if(container.getImage().equals("tomcat")){
			migrateTomcat(container);
		}
		else if(container.getImage().equals("mysql")){
			migrateMysql(container);
		}
		else{
			//not implemented yet
		}
	}
	public static void migrateTomcat(Container container){
		
	}
	public static void migrateMysql(Container container){
		
	}
}
