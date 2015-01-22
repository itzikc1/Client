package networking;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import properties.*;
import model.*;

public class Client {
	private String serverAddress;
	private int port;
	public Client() {
		//define the server with XML Properties
		MyProperties properties = GetProperties.readProperties();
		this.port = properties.getPort();
		this.serverAddress=properties.getServerAddress();
	}
	public Solution getSolution(Problem problem) {
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			socket = new Socket(serverAddress, port);//try connect to server
			System.out.println("connected to server");	
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject(problem);
			Solution solution = (Solution) in.readObject();
			return solution;}			
		 catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
