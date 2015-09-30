package adapter;

/**
 * This class file supports update car information during car configuration.
 * @author qiuyi
 *
 */
public interface UpdateAuto {
	
	public void updateOptionSetName(String modelName, 
			                        String optionSetName,
			                        String newName);
	
	public void updateOptionPrice(String modelName,
			                      String optionName,
			                      String option,
			                      float newPrice);
}
