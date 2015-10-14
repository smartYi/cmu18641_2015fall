package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * This class file supports a server entrance and run in DefaultSocketClient().
 * @author qiuyi
 *
 */
public class Server {	
	//Main function for server.
	private static final int PORT = 8888;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException exception) {
			System.out.println("Could not listen to port: #" + PORT);
			exception.printStackTrace();
			System.exit(1);
		}
		System.out.println("Listen to server port #" + PORT);
		System.out.println("Server waiting to connect!");

		try {
			while (true) {
				Socket socket = serverSocket.accept();
				DefaultSocketClient defaultSocketClient = new DefaultSocketClient(socket);
				defaultSocketClient.start();
				// System.out.println("Server: close socket!");
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
