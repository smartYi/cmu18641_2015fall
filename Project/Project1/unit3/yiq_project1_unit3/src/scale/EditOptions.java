package scale;

import model.Automobile;

/**
 * This class file is to edit some information on an instance of automobile.
 * @author qiuyi
 *
 */
public class EditOptions extends Thread{
	
	private Automobile automobile;
	private int threadID;
	private EditOptionsEnum editOptionsEnum;
	
	/**
	 * For different input, args array can represent different arguments.
	 */
	private String[] args;
	private float price;
	
	/**
	 * An enumerator on edit options selection. 
	 * @author qiuyi
	 *
	 */
	public enum EditOptionsEnum {
		EditOptionSetName,
		EditOptionPrice;
	}
	
	
	/**
	 * Constructor for update option set name thread.
	 * @param threadID
	 * @param automobile
	 * @param editOptionsEnum
	 * @param args
	 */
	public EditOptions(int threadID, Automobile automobile, EditOptionsEnum editOptionsEnum,
			           String[] args) {
		this.automobile = automobile;
		this.threadID = threadID;
		this.editOptionsEnum = editOptionsEnum;
		this.args = args;
	}
	
	/**
	 * Constructor for update option price thread.
	 * @param threadID
	 * @param automobile
	 * @param editOptionsEnum
	 * @param args
	 * @param price
	 */
	public EditOptions(int threadID, Automobile automobile,
			           EditOptionsEnum editOptionsEnum, String[]args, 
			           float price) {
		this.automobile = automobile;
		this.threadID = threadID;
		this.editOptionsEnum = editOptionsEnum;
		this.args = args;
		this.price = price;
	}
	
	
	
	@Override
	public void run() {
		switch (editOptionsEnum) {
		case EditOptionSetName:
			updateOptionSetName();
			break;
		case EditOptionPrice:
			updateOptionPrice();
			break;
		}
	}
	
	/**
	 * This method is to update option set name.
	 * Arguments come from the private property args.
	 * This method is synchronized in case of data corruption.
	 */
	public void updateOptionSetName() {
		synchronized (automobile) {
			waiting();
			automobile.updateOptionSetName(args[0], args[1]);
			printUpdateSetName();
		}
	}
	
	/**
	 * This method is to update option price.
	 * Arguments come from the private property args.
	 * This method is synchronized in case of data corruption.
	 */
	public void updateOptionPrice() {
		synchronized (automobile) {
			if(automobile.getOptionPrice(args[0], args[1]) > 300){
				waiting();
				automobile.updateOptionPrice(args[0], args[1], price);
				printUpdateOptionPrice();
			}else {
				System.out.println("The current price is below 300 and can not update.");
			}
		}
	}
	
	/**
	 * This method is to let current thread wait for several seconds.
	 */
	public void waiting() {
		try{
			Thread.sleep((long)(3000 * Math.random()));
		}catch(InterruptedException e) {
			System.out.println("Interrupted !" + e.toString());
		}
	}
	
	/**
	 * This method is to print out the update set name information.
	 */
	public void printUpdateSetName() {
		System.out.println("Thread" + threadID + " update option set name from "
				+ args[0] + " to " + args[1]);
	}
	
	/**
	 * This method is to print out the update option price information.
	 */
	public void printUpdateOptionPrice() {
		System.out.println("Thread" + threadID + " update option: " + args[1] + 
				           " price in option set " + args[0] + " to $" + price);
	}
}
