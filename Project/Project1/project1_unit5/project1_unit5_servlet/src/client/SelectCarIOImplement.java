package client;

import java.io.BufferedReader;
import java.io.IOException;import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


import model.Automobile;

public class SelectCarIOImplement implements SelectCarIO {
	
	private String hostName;
	private int port;
	private Socket listSocket = null;
	private Socket autoSocket = null;
	
	public SelectCarIOImplement(String hostName, int port) {
		this.hostName = hostName;
		this.port = port;
	}
	
	
	@Override
	public ArrayList<String> getModelList() {
		ObjectInputStream objectInputStream = null;
		ObjectOutputStream objectOutputStream = null;
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try{
			listSocket = new Socket("localhost", port);
			bufferedReader = new BufferedReader(new InputStreamReader(listSocket.getInputStream()));
			printWriter = new PrintWriter(listSocket.getOutputStream(),true);
			objectInputStream = new ObjectInputStream(listSocket.getInputStream());
			objectOutputStream = new ObjectOutputStream(listSocket.getOutputStream());
			printWriter.println("getList");
			printWriter.flush();
			
			String modelName = bufferedReader.readLine();
			while(!modelName.equals(" ")) {
				list.add(modelName);
				modelName = bufferedReader.readLine();
			}
			
			bufferedReader.close();
			printWriter.close();
			listSocket.close();
		}catch(IOException e) {
			System.err.println("ListClient: can not get model list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Automobile getAutomobile(String modelName) {
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		Automobile automobile = null;
		
		try{
			autoSocket = new Socket(hostName, port);
			bufferedReader = new BufferedReader(new InputStreamReader(autoSocket.getInputStream()));
			printWriter = new PrintWriter(autoSocket.getOutputStream(),true);
			ObjectInputStream ois = new ObjectInputStream(autoSocket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(autoSocket.getOutputStream());
			printWriter.println("config");
			printWriter.flush();
			printWriter.println(modelName);
			printWriter.flush();
			automobile = (Automobile)ois.readObject();
			bufferedReader.close();
			printWriter.close();
			autoSocket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return automobile;
	}

}
