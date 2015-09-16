package driver;
import java.io.IOException;

import model.*;
import util.*;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

public class Test {
	public static void main(String[] args){
		
		//Build AutoMobile Object from a file
		Util readfile = new Util();
		
		//Exception handler
		try{
		Automotive FordZTW = readfile.readFile("./FordZTW.txt");
		FordZTW.printBasicInfo();
		FordZTW.printAdditionalInfo();
		readfile.serializeAuto(FordZTW);
		readfile.deserializeAuto();
		System.out.println("--------------------------------------------");
		System.out.println("Following some tests are done!");
		System.out.println("--------------------------------------------");
		System.out.println("Test1: Test getters and setters: ");
		System.out.println("Model name: "+ FordZTW.getName());
		System.out.println("Reset color size to 0: ");
		FordZTW.setOptionsetValue("Color",0);
		System.out.println("--------------------------------------------");
		System.out.println("Test1 is done, print out information.");
		FordZTW.printBasicInfo();
		FordZTW.printAdditionalInfo();
		System.out.println("Test2: Test delete: ");
		System.out.println("Delete opset with index 1: ");
		FordZTW.deleteOptionset(1);
		System.out.println("Delete opset with index 2 and with its option name: ");
		FordZTW.deleteOption(2, "ABS");
		System.out.println("--------------------------------------------");
		System.out.println("Test2 is done, print out information.");
		FordZTW.printBasicInfo();
		FordZTW.printAdditionalInfo();
		System.out.println("Test3: Test update: ");
		System.out.println("1): Update opset with index 2 and update its name and size: ");
		FordZTW.updateOptionset(2,"Traction Control", 3);
		System.out.println("2): Update opset size while keep its name: ");
		FordZTW.updateOptionset("Traction Control", 2);
		System.out.println("3): Update option name with its opset index");
		FordZTW.updateOptionName(4, "present", "selected");
		System.out.println("4): Update option price with its opset index");
		FordZTW.updateOptionPrice(3, 1, -150);
		System.out.println("--------------------------------------------");
		System.out.println("Test3 is done, print out information.");
		FordZTW.printBasicInfo();
		FordZTW.printAdditionalInfo();
		System.out.println("--------------------------------------------");
		System.out.println("Tests are done successfully!");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//Print attributes before serialization
		//FordZTW.print();
	}
}
