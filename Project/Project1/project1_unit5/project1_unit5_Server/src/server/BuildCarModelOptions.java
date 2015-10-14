package server;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import adapter.BuildAuto;
import exceptions.BlankFile;
import exceptions.FileMissingException;
import exceptions.InvalidFileType;
import exceptions.OptionNotFound;
import exceptions.PriceNotFound;
import model.Automobile;

/**
 * This class file implements AutoServer interface and call three methods also
 * are defined in ProxyAutoMobile class as is required in handout.
 * @author qiuyi
 *
 */
public class BuildCarModelOptions implements AutoServer {

	private static BuildAuto buildAuto = null;

	public BuildCarModelOptions() {
		buildAuto = new BuildAuto();
	}

	/**
	 * This method is to build an automobile from property file. But this method
	 * will call another method in ProxyAutomobile.
	 */
	public void buildAutoFromProperty(Properties properties) {
		buildAuto.buildAutoFromProperty(properties);
	}

	/**
	 * This method is to provide a list of models to the client.
	 */
	public LinkedHashMap<String, Automobile> provideModelsToClient() {
		return buildAuto.provideModelsToClient();
	}

	public void buildAutoFromTxt(String fileName) throws IOException,BlankFile,FileMissingException,
	                                                       InvalidFileType,
	                                                       OptionNotFound,
	                                                       PriceNotFound{
			buildAuto.buildAutoFromTxt(fileName);
	}
}