package adapter;


/**
 * This class file in an interface bridge AutoMobile class and EditOptions class.
 * It supports two methods for different threads to update car information.
 * @author qiuyi
 *
 */
public interface EditAuto {
	public void edit(String modelName, String oldSetName, String newSetName);
	public void edit(String modelName, String optionSetName, String optionName, float price);
}
