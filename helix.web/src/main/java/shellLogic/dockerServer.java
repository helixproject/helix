package shellLogic;

import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class dockerServer {
	private String dockerServerName;
	private Session session;
	public dockerServer(String host,String user,String passwd,String dockerServerName){
		try{
			JSch jSch = new JSch();
			session = jSch.getSession(user, host);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(passwd);
			session.connect();
			this.dockerServerName=dockerServerName;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void closeConnection(){
		session.disconnect();
	}
	public String sendCommand(String command){
		try{
			Channel channel = session.openChannel("exec");
			System.out.println("here");
			((ChannelExec) channel).setCommand(command);
			InputStream commandOutput = channel.getInputStream();
			channel.connect();
			int readByte = commandOutput.read();
			StringBuilder outputBuffer = new StringBuilder();
			while(readByte != 0xffffffff)
			{
				outputBuffer.append((char)readByte);
				readByte = commandOutput.read();
			}
			channel.disconnect();
			return outputBuffer.toString();
		}
		catch(Exception e){
			e.printStackTrace();
			return "error on execution of command="+command+"\t on server="+dockerServerName;
		}
	}
}
