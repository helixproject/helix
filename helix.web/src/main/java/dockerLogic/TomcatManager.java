package dockerLogic;

import shellLogic.ShellManager;

public class TomcatManager implements TomcatManagement{
	
	public String createTomcat(String initPassword) {
		String[] commands = {"docker","run","-ti","-d","tomcat","/bin/bash"};
		String[] result=ShellManager.execOnShell(commands);
		
		String file=returnFile(initPassword);
		String[] commands2 = {"echo",file,">","/usr/local/tomcat/conf/tomcat-users.xml"};
		ShellManager.execOnShell(commands2);
		
		String[] commands3 = {"exit"};
		ShellManager.execOnShell(commands3);
		
		String[] commands4 = {"docker","stop",result[0]};
		ShellManager.execOnShell(commands4);
		
		return result[0];
	}
	
	public String returnFile(String initPassword){
		return "<?xml version='1.0' encoding='utf-8'?><tomcat-users xmlns=\"http://tomcat.apache.org/xml\"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"xsi:schemaLocation=\"http://tomcat.apache.org/xml tomcat-users.xsd\"version=\"1.0\"><role rolename=\"manager-gui\"/><user username=\"root\" password="+initPassword+" roles=\"tomcat\"/></tomcat-users>";
	}

}
/*<?xml version='1.0' encoding='utf-8'?>

<tomcat-users xmlns="http://tomcat.apache.org/xml"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://tomcat.apache.org/xml tomcat-users.xsd"
            version="1.0">
<role rolename="manager-gui"/>
<user username="root" password="tomcat" roles="tomcat"/>
</tomcat-users>*/