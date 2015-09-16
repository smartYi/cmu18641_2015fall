package exceptionHandler;

/*
 * @Author--Yi
 * @Version--1.0
 * Date--Sep/10/2015
 */

//This is the fixed exception class that tells how number exceed exception is processed.

public class FixedException extends Exception{
	
	//Set SerialVersionUid
	private static final long serialVersionUID = 1L;

	//Constructor
	public FixedException(){
		super();
		printErrorMessage();
	}
	
	//When constructor is called, print out exception message.  
	public void printErrorMessage(){
		System.out.println("Sorry, you student number exceed 40 !");
	}
	
	//Tell how this exception is handled.
	public void FixedExceptionBreak(){
		System.out.println("We only store the first 40 students' grades and calculate their data !");
	}
}
