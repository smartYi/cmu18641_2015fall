package adapter;

/**
 * This interface includes two methods that update model information. 
 * @author qiuyi
 *
 */
public interface UpdateAuto {
	
	/**
	 * This method is to update option set name.
	 * Abstract method to be defined in the outer class.
	 * @param modelName
	 * @param optionSetName
	 * @param newName
	 */
	public void updateOptionSetName(String modelName, 
			                        String optionSetName,
			                        String newName);
	
	/**
	 * This method is to update option price.
	 * Abstract method to be defined in the outer class.
	 * @param modelName
	 * @param optionName
	 * @param option
	 * @param newPrice
	 */
	public void updateOptionPrice(String modelName,
			                      String optionName,
			                      String option,
			                      float newPrice);
}
