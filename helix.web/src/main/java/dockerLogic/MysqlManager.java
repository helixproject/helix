package dockerLogic;

import shellLogic.ShellManager;

public class MysqlManager{

	
	public String createMysql() {
		String[] commands = {"docker","create","mysql"};
		String[] result=ShellManager.execOnShell(commands);
		return result[0];
	}

}
