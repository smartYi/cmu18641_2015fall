package adapter;

import java.io.IOException;

import exceptions.BlankFile;
import exceptions.FileMissingException;
import exceptions.InvalidFileType;
import exceptions.OptionNotFound;
import exceptions.PriceNotFound;

/**
 * This class file is to build an automobile and print out its information.
 * @author qiuyi
 *
 */
public interface CreateAuto {
	
	/**
	 * This method is to build an instance of automobile.
	 * This is an abstract method that needs to be exact defined in outer class.
	 * @param filename
	 * @throws IOException
	 * @throws BlankFile
	 * @throws InvalidFileType
	 * @throws FileMissingException
	 * @throws OptionNotFound
	 * @throws PriceNotFound
	 */
	public void buildAuto(String filename)throws IOException,BlankFile,InvalidFileType,FileMissingException,OptionNotFound,PriceNotFound;
	

	/**
	 * This method is to print out the automobile information.
	 * This is an abstract method that needs to be exact defined in outer class.
	 * @param modelName
	 */
	public void printAuto(String modelName);
}
