package util;
import model.*;
import java.io.*;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

//This class is to read configurations from txt file and to build auto objects

public class Util implements Serializable{
	
	//Declare a serial version UID
	static final long serialVersionUID = 1;
	
	//This method is an instance method and is to build auto objects
	public Automotive readFile(String filename) throws IOException{
		
		//Create a read file stream and a processing flow
		FileReader read = null;
		BufferedReader bufferRead = null;
		
		//Create a new automotive model
		Automotive al = null;
		
		try{
			//Initialize a input file flow of file
			read = new FileReader(filename);
			
			//Initialize a process flow based on file flow
			bufferRead = new BufferedReader(read);
	
			//Read each line of txt file and configure each optionset and option
			//Configure model name, optionset size and base price
			String buffer;
			
			//Read the first line of txt file
			buffer = bufferRead.readLine();
			
			//Split the first line string
			String[] str = buffer.split(",");
			
			//Use constructor with arguments to configure a car model
			al = new Automotive(str[0],Integer.parseInt(str[1]),Float.parseFloat(str[2]));
	
			//Continue to read file to set up other configurations
			for(int i=0;i<Integer.parseInt(str[1]);i++){
				buffer = bufferRead.readLine();
				String[] opsetStr = buffer.split(",");
				al.setOptionsetValue(i,opsetStr[0],Integer.parseInt(opsetStr[1]));
				for(int j=0;j<Integer.parseInt(opsetStr[1]);j++){
					String[] optStr = (bufferRead.readLine()).split(",");
					al.setOptionValue(i,optStr[0],Float.parseFloat(optStr[1]),j);
				}
			}
			
			
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try{
				bufferRead.close();
			}catch(IOException closeError){
				closeError.printStackTrace();
			}
		}
		
		return al;
	}
	
	
	//Serialize the input data
	public void serializeAuto(Automotive auto){
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(
					                 new FileOutputStream("ZTW.ser"));
			out.writeObject(auto);
			System.out.println("Serialization ZTW.ser");
			System.out.println("Serializarion is done!");
			System.out.println("--------------------------------------------");
			
		}catch(Exception e){
			System.out.println("Error--->" + e);
			System.exit(1);
		}finally {
			try{
				out.close();
			}catch(Exception closeError){
				System.out.print("Error--->" + closeError);
				System.exit(1);
			}
		}
	}
	
	//Deserialize the input data
	public void deserializeAuto(){
		ObjectInputStream in = null; 
		
		try{
			in = new ObjectInputStream(new FileInputStream("ZTW.ser"));
			Automotive newAuto = (Automotive) in.readObject();
			System.out.println("Deserialization ZTW.ser");
			System.out.println("Deserializarion is done!");
			System.out.println("After serialization, the data is kept intact.");
			newAuto.printBasicInfo();
			newAuto.printAdditionalInfo();
		}catch(Exception e){
			System.out.println("Error--->" + e);
		}finally {
			try{
				in.close();
			}catch(Exception closeError){
				System.out.println("Error--->" + closeError);
			}
		}
	}
}
