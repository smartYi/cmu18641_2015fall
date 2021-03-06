package exceptions;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.Date;

/**
 * This class extends Exception and contains all the following five exact exceptions.
 * @author qiuyi
 *
 */
public abstract class AutoException extends Exception {
	
	static final long serialVersionUID = 1;
	
	private int errno;
	private String msg;
	
	//Constructor with arguments
	public AutoException(int errno, String msg) {
		this.errno = errno;
		this.msg = msg;
	}
	
	//Abstract method to be defined.
	public abstract void print();
	
	//Setters and getters
	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Record exceptions
	 */
	public void log(int errno) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		String logline = timestamp.toString() + ": Error code: " + errno + ", error message: " + msg;
		try{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					                new FileOutputStream("ExceptionLog.txt",true)));
			writer.write(logline);
			writer.flush();
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
