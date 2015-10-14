package server;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import exceptions.BlankFile;
import exceptions.FileMissingException;
import exceptions.InvalidFileType;
import exceptions.OptionNotFound;
import exceptions.PriceNotFound;
import model.Automobile;

/**
 * This interface supports three methods.
 * This interface is implemented by BuildCarModelOptions class and BuildAuto class as is required in handout.
 * @author qiuyi
 *
 */
public interface AutoServer {
	public void buildAutoFromProperty(Properties properties);
	public void buildAutoFromTxt(String fileName) throws IOException,BlankFile,FileMissingException,
    														InvalidFileType,
    														OptionNotFound,
    														PriceNotFound;
	public LinkedHashMap<String, Automobile> provideModelsToClient();
}
