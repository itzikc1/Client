package properties;

import java.io.Serializable;

public class MyProperties implements Serializable {
	private int port;//number port
	private String serverAddress;//number of ip
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public MyProperties(int port, String serverAddress) {
		super();
		this.port = port;
		this.serverAddress = serverAddress;
	}	
	public MyProperties() { }
}
//this.serverAddress = "127.0.0.1";