package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * This class file is to read a directory that contains all the car model information.
 * @author qiuyi
 *
 */
public class CarModelOptionsIO {	
	/**
	 * This method is to get different model names from a directory..
	 * @param fileSets
	 * @return
	 */
	 public ArrayList<String> getFileName(String fileSets) {
		    ArrayList<String> fileName = new ArrayList<String>();
			String propertyName;
			BufferedReader bufferedReader = null;
			try{
				bufferedReader = new BufferedReader(new FileReader(fileSets));
				
				//Read different model files
				
				while((propertyName = bufferedReader.readLine())!= null) {
					fileName.add(propertyName);
				}
			}catch(IOException e) {
				System.out.println("Can not open file!");
				e.printStackTrace();
			}
			return fileName;
	    }
}
