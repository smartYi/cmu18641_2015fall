package exceptions;

import adapter.BuildAuto;

/**
 * This class file gives specific exception on not found option price.
 * @author qiuyi
 *
 */
public class PriceNotFound extends AutoException{

    static final long serialVersionUID = 1;
	
	private static final int ERRNO = 5;
	private static final String MSG = "The option price is missing !";
	
	public PriceNotFound() {
		super(ERRNO, MSG);
	}
	
	public void print() {
		System.out.println("The error code is: " + ERRNO);
		System.out.println("Error is: " + MSG);
	}
	
	public String fix(int errno) {
		BuildAuto temp = new BuildAuto();
		return temp.fix(errno);
	}
	
	public void log(int errno) {
		super.log(ERRNO);
	}
}
