package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This class file contains all these fix functions that handle likely exceptions in this program.
 * @author qiuyi
 *
 */
public class Fix1to100 {
	
	/**
	 * This method is to fix error code 1
	 * @return
	 */
	public String fix1() {
		System.out.println("Please input your new file name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			return br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method is to fix error code 2
	 * @return
	 */
    public String fix2() {
    	System.out.println("Please input your new file name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			return br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
	 * This method is to fix error code 3
	 * @return
	 */
    public String fix3() {
    	System.out.println("Please input your new file name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			return br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
	 * This method is to fix error code 4
	 * @return
	 */
    public String fix4() {
    	System.out.println("Please input your option name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			return br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
	 * This method is to fix error code 5
	 * @return
	 */
   public String fix5() {
	   System.out.println("Please input your option price: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			return br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
   }
}
