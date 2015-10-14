package client;

import java.net.*;
import java.util.ArrayList;
import java.util.Properties;

import model.Automobile;

import java.io.*;

/**
 * This class file is a client and extends thread.
 * 
 * @author qiuyi
 *
 */
public class DefaultSocketClient extends Thread {

	private static final String fileSets = "./fileSets.txt";
	private static final int PORT = 8888;
	private Socket socket;
	private CarModelOptionsIO carModelOptionsIO = null;
	PrintWriter printWriter = null;
	BufferedReader bufferedReader = null;
	ObjectInputStream objectInputStream = null;
	ObjectOutputStream objectOutputStream = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;

	@Override
	public void run() {
		while (true) {
			try {
				sleep((long) 200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (openSession()) {
				handleSession();
				closeSession();
				System.out.println("Do you want to upload car model or configure a car? y/n?");
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
				try {
					String choice = read.readLine();
					if (choice.equals("n"))
						break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method is to open a session.
	 * 
	 * @return
	 */
	public boolean openSession() {
		try {
			System.out.println("Client: Creating a client!");
			socket = new Socket("localhost", PORT);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(), true);
		} catch (UnknownHostException unknownHostException) {
			unknownHostException.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Client: Can not open session!");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method is to hand a user input.
	 */
	public void handleSession() {
		try {
			// Test client and server is connected or not.
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(bufferedReader.readLine());
			printWriter.println("Client: OK! Connected!");
			printWriter.flush();

			// Client and server connected. Then do next.
			String userInput;
			System.out.println("1): Upload car model:");
			System.out.println("2): Configure a car:");
			System.out.println("Enter your choice: 1 or 2:");
			// User input a choice
			userInput = stdIn.readLine();

			// Tell server the user choice
			printWriter.println(userInput);
			printWriter.flush();

			carModelOptionsIO = new CarModelOptionsIO();
			ArrayList<String> fileName = carModelOptionsIO.getFileName(fileSets);
			// If user input is 1, then upload a car model and add it to the
			// model sets.
			if (userInput.equals("1")) {
				System.out.println("There are " + fileName.size() + " car models in model library. "
						+ "Select one you want to upload: ");
				int choice = Integer.parseInt(stdIn.readLine());
				// If the user input is illegal, input again.
				while (choice <= 0 || choice > fileName.size()) {
					System.out.println("Your choice is illegal, input again!");
					choice = Integer.parseInt(stdIn.readLine());
				}

				String filename = fileName.get(choice - 1);
				String fileType = checkFileType(filename);
				// Tell server the file type
				printWriter.println(fileType);
				printWriter.flush();

				if (fileType == "properties") {
					Properties prop = new Properties();
					FileInputStream in = new FileInputStream(filename);
					prop.load(in);
					printWriter.println("Client: Sending properties file....");
					printWriter.flush();
					objectOutputStream.writeObject(prop);
					objectOutputStream.flush();
					System.out.println(bufferedReader.readLine());
					System.out.println(bufferedReader.readLine());
					System.out.println(bufferedReader.readLine());
				}
				if (fileType == "txt") {
					File file = new File(filename);
					dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
					printWriter.println("Client: Sending txt file....");
					printWriter.flush();

					int buffersize = 10240;
					byte[] buffArray = new byte[buffersize];
					dos.writeUTF(filename);
					dos.flush();
					System.out.println("Client: here");

					int read = 0;
					read = dis.read(buffArray);
					dos.write(buffArray, 0, read);
					dos.flush();

					System.out.println(bufferedReader.readLine());
					System.out.println(bufferedReader.readLine());
					System.out.println(bufferedReader.readLine());
				}

			} else if (userInput.equals("2")) {
				SelectCarOption selectCarOption = new SelectCarOption();
				System.out.println("Available car model: ");
				String info = bufferedReader.readLine();
				while (!info.equals("")) {
					System.out.println(info);
					info = bufferedReader.readLine();
				}

				System.out.println("Input your wanted car model: ");
				String userModel = stdIn.readLine();
				printWriter.println(userModel);
				printWriter.flush();

				try {
					Automobile automobile = (Automobile) objectInputStream.readObject();
					System.out.println("Model received!");
					System.out.println("Here is the model information:");
					automobile.printBasicInfo();
					automobile.printAdditionalInfo();
					System.out.println("Press any key to set up your own car!");
					stdIn.readLine();
					selectCarOption.setChoice(automobile);
				} catch (ClassNotFoundException exception) {
					exception.printStackTrace();
				}

			}

		} catch (IOException e) {
			System.out.println("Can not get client output stream!");
			e.printStackTrace();

		}
	}

	public void closeSession() {
		try {
			objectOutputStream.close();
			dos.close();
			printWriter.close();
			objectInputStream.close();
			bufferedReader.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String checkFileType(String fileName) {
		if (fileName.substring(fileName.length() - 3).equals("txt")) {
			return "txt";
		} else
			return "properties";

	}
}
