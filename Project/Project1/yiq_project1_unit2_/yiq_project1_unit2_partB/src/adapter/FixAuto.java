package adapter;

/**
 * This interface is to fix exceptions that will occur in this program. 
 * @author qiuyi
 *
 */
public interface FixAuto {
	/**
	 * This method is to fix any exceptions that will occur in this program.
	 * This is an abstract method that needs to be exact defined in outer class.
	 * @param errno
	 * @return
	 */
	public String fix(int errno);
}
