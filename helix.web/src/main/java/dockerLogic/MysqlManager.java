package dockerLogic;

import shellLogic.ShellManager;

public class MysqlManager implements MysqlManagement{

	
	public String createMysql(String initPassword) {
		String[] commands = {"docker","create","-e","MYSQL_ROOT_PASSWORD="+initPassword,"mysql"};
		String[] result=ShellManager.execOnShell(commands);
		return result[0];
	}

}
