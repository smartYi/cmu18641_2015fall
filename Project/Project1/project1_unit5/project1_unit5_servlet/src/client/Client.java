package client;


/**
 * This class file supports a method that create a client.
 * @author qiuyi
 *
 */
public class Client {
	
	public static void main(String[] args) {
		DefaultSocketClient defaultSocketClient = new DefaultSocketClient();
		defaultSocketClient.start();
	}
}
