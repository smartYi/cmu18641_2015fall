package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Automobile;
import model.Optionset;

/**
 * This class file is to set specific choice for user's car.
 * @author qiuyi
 *
 */
public class SelectCarOption {
	
	/**
	 * This method is to customize the user's car.
	 * @param automobile
	 */
	public void setChoice(Automobile automobile) {
		try{
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Optionset> set = automobile.getOptionSets();
		for(int i=0;i<set.size();i++) {
			System.out.println("Please choose the " + set.get(i).getName());
			for(int j=0;j<set.get(i).getOpt().size();j++) {
				System.out.println((j+1) + ". " + set.get(i).getOpt().get(j).getName() + ". Price: $"
						+ set.get(i).getOpt().get(j).getPrice());
			}
				int choice = Integer.parseInt(stdIn.readLine());
				automobile.setOptionChoice(set.get(i).getName(), set.get(i).getOpt().get(choice-1).getName());
			}
		System.out.println("Your car model has been set, Here is your car information:");
		automobile.printOption();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
}
