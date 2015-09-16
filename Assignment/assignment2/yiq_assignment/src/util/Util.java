package util;
import analyticModel.Student;
import java.io.FileReader;
import java.io.BufferedReader;
import exceptionHandler.*;
import java.io.*;
/*
 * @Author--Yi 
 * @Version--1.0
 * @Date--Sep/10/2015
 */

//This the read file class and only has a static method to read file from current project

public class Util {
	static public Student[] readFile(String filename, Student[] student) throws FixedException, IOException{
		FileReader read = null;                          //Create a null character stream
		BufferedReader bufRead = null;                   //Create a null processing flow
		int number = 0;                                  //To index the number of students that have been stored
		try{
	    //Read a file from the filename
		read = new FileReader(filename);
		//Create a processing flow
		bufRead = new BufferedReader(read);
		//To store each line as string
		String buffer;
		while((buffer = bufRead.readLine())!=null){
			Student stu = new Student();
			number++;
			if(number == 1) continue;
			//If number exceed 40, throw an exception
			if(number>41){
				bufRead.close();
				throw new FixedException();
			}
			if(number>41) break;
			String[] str = buffer.split(" ");
			stu.setSID(Integer.parseInt(str[0].trim()));
			int[] tempScore = new int[5];
			for(int i=1;i<str.length;i++){
				tempScore[i-1] = Integer.parseInt(str[i].trim());
			}
			stu.setScores(tempScore);
			student[number-2] = stu;
			}
		}catch(FixedException e){
			e.FixedExceptionBreak();
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			bufRead.close();
		}
		return student;
	} 
}
