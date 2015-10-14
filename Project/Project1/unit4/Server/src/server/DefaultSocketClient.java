package server;

import java.net.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import model.Automobile;

import java.io.*;

/**
 * This class file runs a server.
 * 
 * @author qiuyi
 *
 */
public class DefaultSocketClient extends Thread {

	private static BuildCarModelOptions buildCarModelOptions = null;
	private Socket socket = null;

	public DefaultSocketClient(Socket socket) {
		this.socket = socket;
	}

	// Thread run.
	public void run() {
		// Create a server.
		try {
			handleSession(socket);
			socket.close();
			// System.out.println("here");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// run

	/**
	 * This method is to handle a session accepted from client.
	 * 
	 * @param socket
	 */
	public void handleSession(Socket socket) {
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//			printWriter.println("Server: I am server, ready to connect!");
//			printWriter.flush();
//			System.out.println(bufferedReader.readLine());
			System.out.println("Server: Successfully get output and input stream!");

			// Get user input to decide to upload a car model or configure a
			// car.
			String userInput;
			userInput = bufferedReader.readLine();
			System.out.println("User input is: " + userInput);

			// If user input is 1, the upload a car model.
			if (userInput.equals("1")) {

				String fileType = bufferedReader.readLine();
				if (fileType.equals("properties")) {
					// Get a properties file from client and use this
					// file to build a car model.
					System.out.println(bufferedReader.readLine());
					try {
						Thread.sleep(300);
					} catch (InterruptedException exception) {
						exception.printStackTrace();
					}
					Properties properties = (Properties) ois.readObject();
					// System.out.println("Server: here1");
					printWriter.println("Server: Properties file accepted!");
					printWriter.flush();
					printWriter.println("Server: Build automobile model....");
					printWriter.flush();
					buildCarModelOptions = new BuildCarModelOptions();
					buildCarModelOptions.buildAutoFromProperty(properties);
					printWriter.println("Server: Car model build completed!");
					printWriter.flush();
				}
				// Handle different types of input file.
				if (fileType.equals("txt")) {
					System.out.println(bufferedReader.readLine());
					int bufferSize = 10240;
					byte[] buf = new byte[bufferSize];
					String fileName = dis.readUTF();
					DataOutputStream fileOut = new DataOutputStream(
							new BufferedOutputStream(new FileOutputStream(fileName)));

					System.out.println("Accepting data....");
					System.out.println("Data Accepted!");

					int read = 0;
					try {
						Thread.sleep(300);
					} catch (InterruptedException exception) {
						exception.printStackTrace();
					}
					read = dis.read(buf);
					fileOut.write(buf, 0, read);
					fileOut.close();

					printWriter.println("Server: Txt file accepted!");
					printWriter.flush();
					printWriter.println("Server: Build automobile model....");
					printWriter.flush();
					buildCarModelOptions = new BuildCarModelOptions();
					buildCarModelOptions.buildAutoFromTxt(fileName);
					printWriter.println("Server: Car model build completed!");
					printWriter.flush();
					// Delete fileName since no data should be stored in
					// server.
					File newFile = new File(fileName);
					newFile.delete();
				}
			}

			// If user input 2, start configure a customize car.
			if (userInput.equals("2")) {
				buildCarModelOptions = new BuildCarModelOptions();
				LinkedHashMap<String, Automobile> mobileSets = buildCarModelOptions.provideModelsToClient();
				Iterator<String> iterator = mobileSets.keySet().iterator();
				while (iterator.hasNext()) {
					String modelName = (String) iterator.next();
					Automobile automobile = mobileSets.get(modelName);
					printWriter.println(automobile.getMake() + " " + automobile.getModel() + " Base price is: "
							+ automobile.getBasePrice());
					printWriter.flush();
					if (!iterator.hasNext()) {
						printWriter.println("");
						printWriter.flush();
					}
				}
				String userModel = bufferedReader.readLine();
				while (userModel != null) {
					System.out.println("User choose car model " + userModel);
					oos.writeObject(mobileSets.get(userModel));
					oos.flush();
					break;
				}
			}

			if (userInput.equals("getList")) {
				buildCarModelOptions = new BuildCarModelOptions();
				LinkedHashMap<String, Automobile> mobileSets = buildCarModelOptions.provideModelsToClient();
				Iterator<String> iterator = mobileSets.keySet().iterator();
				while(iterator.hasNext()) {
					String modelName = (String) iterator.next();
					printWriter.println(modelName);
					printWriter.flush();
				}
				printWriter.write(" ");
				printWriter.flush();
			}
			
			if(userInput.equals("config")) {
				String modelName = bufferedReader.readLine();
				buildCarModelOptions = new BuildCarModelOptions();
				LinkedHashMap<String, Automobile> mobileSets = buildCarModelOptions.provideModelsToClient();
				Automobile automobile = mobileSets.get(modelName);
				oos.writeObject(automobile);
				oos.flush();
			}
		} catch (Exception e) {
			System.out.println("Server: Fail to upload car model, press y to upload again!");
		}
	}
}