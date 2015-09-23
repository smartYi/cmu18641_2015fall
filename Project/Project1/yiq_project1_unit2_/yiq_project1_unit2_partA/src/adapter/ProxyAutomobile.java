package adapter;
import java.io.IOException;

import model.*;
import util.*;
import exceptions.*;


/**
 * This class file is responsible for building automobiles and throw any likely exceptions.
 * @author qiuyi
 *
 */
public abstract class ProxyAutomobile {
	
	private static Automotbile myobj;
	
	/**
	 * This method is to handle the exception that no input file is included.
	 * @throws IOException
	 * @throws BlankFile
	 * @throws InvalidFileType
	 * @throws OptionNotFound
	 */
	public void buildAuto() throws IOException,BlankFile,
	                               FileMissingException,
                                   InvalidFileType,
                                   OptionNotFound,
	                               PriceNotFound{
		FileMissingException error = new FileMissingException();
		error.print();
		error.log(error.getErrno());
		String fileName = fix(error.getErrno());
		try{
			buildAuto(fileName);
		}catch(AutoException er) {
			er.print();
			error.log(error.getErrno());
    		String newFileName = fix(er.getErrno());
    		buildAuto(newFileName);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is to build a automobile from filename.
	 * Since in util package, a readFile method is created and can build an automobile,
	 * so in this method we can just call the function readFile() in the util package.
	 * @param filename
	 * @throws IOException
	 * @throws BlankFile
	 * @throws InvalidFileType
	 * @throws OptionNotFound
	 */
    public void buildAuto(String filename) throws IOException,BlankFile,
                                                  FileMissingException,
                                                  InvalidFileType,
                                                  OptionNotFound,
                                                  PriceNotFound{
    	
    	Util util = new Util();
    	
    	try{
    		myobj = util.readFile(filename);
    	}catch(AutoException error) {
    		error.print();
    		error.log(error.getErrno());
    		String newFileName = fix(error.getErrno());
    		buildAuto(newFileName);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }
	
    /**
     * This method is to print out automobile information.
     * @param modelName
     */
	public void printAuto(String modelName) {
		
		myobj.printBasicInfo();
		myobj.printAdditionalInfo();
		
	}
	
	/**
	 * This method is to update option set name.
	 * @param modelName
	 * @param optionSetName
	 * @param optionName
	 * @param newPrice
	 */

	public void updateOptionSetName(String modelName, 
                                    String optionSetName,
                                    String newName) {
		myobj.updateOptionSetName(optionSetName, newName);
		
	}



	/**
	 * This method is to update option price.
	 * @param modelName
	 * @param optionSetName
	 * @param optionName
	 * @param newPrice
	 */

    public void updateOptionPrice(String modelName,
                                  String optionSetName,
                                  String optionName,
                                  float newPrice) {
    	myobj.updateOptionPrice(optionSetName, optionName, newPrice);
    	
    }
    

    /**
     * This method is to distribute exceptions to the relative fix functions.
     * @param errno
     * @return
     */
    public String fix(int errno) {
    	
        Fix1to100 f1 = new Fix1to100();
		
		switch (errno) {
		case 1:
			String fileName = f1.fix1();
			return fileName;
			
		case 2:
			return f1.fix2();
		
		case 3:
			return f1.fix3();
		case 4:
			return f1.fix4();
		case 5:
			return f1.fix5();
			
		default:
			return "";
		}
    }
	
    /**
     * This method is to serialiation data.
     */
    public void serial() {
    	Util util = new Util();
    	util.serializeAuto(myobj);
    }
    
    /**
     * This method is to deserialiation data.
     */
    public void deserial() {
    	Util util = new Util();
    	util.deserializeAuto();
    }
}
