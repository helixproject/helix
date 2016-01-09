package shellLogic;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileSharing {
	public static void sendFile(String source,String sourcePath,String destination,String destinationPath){
		try{
			JSch jSch = new JSch();
			Session session = jSch.getSession(user,host);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(passwd);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftp = (ChannelSftp) channel;
			sftp.
			sftp.put(filePath,destinationPath);
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
