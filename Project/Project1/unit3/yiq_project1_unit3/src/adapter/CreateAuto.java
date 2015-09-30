package adapter;

import java.io.IOException;

import exceptions.BlankFile;
import exceptions.FileMissingException;
import exceptions.InvalidFileType;
import exceptions.OptionNotFound;
import exceptions.PriceNotFound;

/**
 * This class file is to create an instance automobile from file and print automobile information. 
 * @author qiuyi
 *
 */
public interface CreateAuto {
	
	public void buildAuto(String filename)throws IOException,BlankFile,InvalidFileType,FileMissingException,OptionNotFound,PriceNotFound;
	
	public void printAuto(String modelName);
}
