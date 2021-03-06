package driver;

import java.io.IOException;


import adapter.*;
import exceptions.*;

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
		System.out.println("---------------Original information-------------------");
		auto2.printAuto("Focus Wagon ZTW");
		System.out.println("---------------Test starts!!--------------------------");
		auto2.edit("Focus Wagon ZTW", "Transmission", "Thread Transmission");
		auto2.edit("Focus Wagon ZTW", "Color", "Shai");
		auto2.edit("Focus Wagon ZTW", "Power Moonroof", "Thread Power Moonroof");
		auto2.edit("Focus Wagon ZTW", "Brakers", "ABS", 100);
		auto2.edit("Focus Wagon ZTW", "Side Impact Air Bags", "present", 30);
		auto2.edit("Focus Wagon ZTW", "Side Impact Air Bags", "present", 100);
		
		//The main thread sleep for 13s and wait for the 6 threads finish their jobs.
		try{
			Thread.sleep((long)13000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//Print out the updated information.
		auto2.printAuto("Focus Wagon ZTW");

		
	}
}
