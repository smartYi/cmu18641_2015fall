package adapter;
import java.io.IOException;
import java.util.LinkedHashMap;
import model.*;
import scale.EditOptions;
import scale.EditOptions.EditOptionsEnum;
import util.*;
import exceptions.*;

/**
 * This class file is the proxy of class file AutoMobile.
 * @author qiuyi
 *
 */
public abstract class ProxyAutomobile {
	
	private Automobile myobj;
	
	private static LinkedHashMap<String, Automobile> mobileSets = new LinkedHashMap<>();
	
	private int threadID = 0;
	
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
    	mobileSets.put(myobj.getModel(), myobj);
    }
	
    
    public Automobile getAuto(String fileName) {
    	return mobileSets.get(fileName);
    }
    
    
	public void printAuto(String modelName) {
		Automobile br = mobileSets.get(modelName);
		br.printBasicInfo();
		br.printAdditionalInfo();
	}
	
	public void updateOptionSetName(String modelName, 
                                    String optionSetName,
                                    String newName) {
		Automobile br = mobileSets.get(modelName);
		br.updateOptionSetName(optionSetName, newName);
		
	}

    public void updateOptionPrice(String modelName,
                                  String optionSetName,
                                  String optionName,
                                  float newPrice) {
    	Automobile br = mobileSets.get(modelName);
    	br.updateOptionPrice(optionSetName, optionName, newPrice);
    	
    }
    
    public void prinOption(String modelName) {
    	Automobile br = mobileSets.get(modelName);
    	br.printOption();
    }
    
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
	
    public void serial() {
    	Util util = new Util();
    	util.serializeAuto(myobj);
    }
    
    public void deserial() {
    	Util util = new Util();
    	util.deserializeAuto();
    }
    
    /**
     * This method is to edit an automobile instance.
     */
    public void edit(String modelName, String oldSetName, String newSetName) {
    	EditOptionsEnum editOptionsEnum = EditOptionsEnum.EditOptionSetName;
    	Automobile automobile = mobileSets.get(modelName);
    	String[] args = {oldSetName, newSetName};
    	EditOptions editOptions = new EditOptions(++threadID, automobile, editOptionsEnum, args);
    	editOptions.start();
    }
    
   public void edit(String modelName, String optionSetName, String optionName, float price) {
	   EditOptionsEnum editOptionsEnum = EditOptionsEnum.EditOptionPrice;
	   Automobile automobile = mobileSets.get(modelName);
	   String[] args = {optionSetName, optionName};
	   EditOptions editOptions = new EditOptions(++threadID, automobile, editOptionsEnum, 
			                                     args, price);
	   editOptions.start();
   } 
}
