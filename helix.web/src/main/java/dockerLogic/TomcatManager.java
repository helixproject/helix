package dockerLogic;

import shellLogic.ShellManager;

public class TomcatManager implements TomcatManagement{
	public String createTomcat() {
		String[] commands = {"docker","create","tomcat"};
		String[] result=ShellManager.execOnShell(commands);
		System.out.println("o="+result[0]);
		System.out.println("e="+result[1]);
		return result[0];
	}	
}
