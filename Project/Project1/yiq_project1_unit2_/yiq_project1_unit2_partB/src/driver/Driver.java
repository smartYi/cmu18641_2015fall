package driver;

import java.io.IOException;

import adapter.*;
import exceptions.*;
import model.Automotbile;

/**
 * This is a test class that drive the model package and util package.
 * <p>
 * Several tests are done to test the source code correctness.
 * First setters and getters function are tested to show good encapsulation of this code;
 * Then delete functions are tested to show data contents can be deleted arbitrarily 
 * without changing output format;
 * Last update functions are tested to show the flexibility of this car configuration model.
 *
 * @author--Yi
 * @version--1.0
 * @since--Sep/14/2015
 */
public class Driver {
	
	
	/**
	 * This is the main function and do several tests.
	 * @param args true
	 */
	public static void main(String[] args) throws IOException,BlankFile,
	                                              FileMissingException,InvalidFileType,
	                                              OptionNotFound,
	                                              PriceNotFound{
		
		//Build AutoMobile Object from a file
		BuildAuto auto2 = new BuildAuto();
		auto2.buildAuto("./FordZTW.txt");
		auto2.printAuto("Focus Wagon ZTW");
		System.out.println("Test update option set name!");;
		auto2.updateOptionSetName("Focus Wagon ZTW", "Brakers", "Control Device");
		auto2.printAuto("Focus Wagon ZTW");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Test update option price!");;
		auto2.updateOptionPrice("Focus Wagon ZTW", "Power Moonroof", "present", 790);
		auto2.printAuto("Focus Wagon ZTW");
		Automotbile myobj = auto2.getAuto("Focus Wagon ZTW");
		myobj.setOptionChoice("Color", "Infra-Red Clearcoat");
		myobj.setOptionChoice("Transmission", "manual");
		myobj.setOptionChoice("Control Device", "ABS");
		myobj.setOptionChoice("Side Impact Air Bags", "present");
		myobj.setOptionChoice("Power Moonroof", "present");
		auto2.prinOption("Focus Wagon ZTW");

		
	}
}