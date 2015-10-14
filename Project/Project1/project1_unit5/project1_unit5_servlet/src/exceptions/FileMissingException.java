package exceptions;

/**
 * This class file gives specific exception on file missing.
 * @author qiuyi
 *
 */
public class FileMissingException extends AutoException{

    static final long serialVersionUID = 1;
	
	private static final int ERRNO = 2;
	private static final String MSG = "You do not input a file name and input your file name again !";
	
	public FileMissingException() {
		super(ERRNO, MSG);
	}
	
	public void print() {
		System.out.println("The error code is: " + ERRNO);
		System.out.println("Error is: " + MSG);
	}
	
	public void log(int errno) {
		super.log(ERRNO);
	}
}
