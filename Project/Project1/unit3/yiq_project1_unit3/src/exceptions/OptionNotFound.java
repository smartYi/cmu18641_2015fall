package exceptions;

import adapter.BuildAuto;

/**
 * This class file gives specific exception on not found option.
 * @author qiuyi
 *
 */
public class OptionNotFound extends AutoException{
    static final long serialVersionUID = 1;
	
	private static final int ERRNO = 4;
	private static final String MSG = "The option name is missing !";
	
	public OptionNotFound() {
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