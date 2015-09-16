package test;
import analyticModel.*;
import exceptionHandler.*;
import util.*;
import java.io.*;

/*
 * @Author--Yi
 * @Version--1.0
 * @Date--Sep/10/2015
 */

//This is the test class that drive all the rest of classes in this project

public class Test {
	public static void main(String[] args){
		//Here modifier is not permitted and only final is allowed
		Student[] lab2 = new Student[40];                                                      //Create an array of 40 students
		int count = 0;                                                                         //To store the number of students
		try{                                                                                   //Read file from current project directory 
		//Students' number more than 40. If you want to test this case, uncomment next.
		lab2 = Util.readFile("src/More_than_40.txt",lab2); 
		
		//Students' number less than 40. If you want to test this case, uncomment next.
		//lab2 = Util.readFile("src/Less_than_40.txt",lab2);       
		
		//Students' number equals to 40. If you want to test this case, uncomment next.
		//lab2 = Util.readFile("src/Equals_to_40.txt",lab2);                                   
		}catch(FixedException e){                                                              //To handle number exceed exception
			e.printStackTrace();
		}catch(IOException e){                                                                 //To handle IO exception
			e.printStackTrace();
		}
		AnalyticModel analysis = new AnalyticModel();
		analysis.findLowest(lab2);                                                             //Find the lowest of 5 quizzes among 40 students
		analysis.findHighest(lab2);                                                            //Find the highest of 5 quizzes among 40 students
		analysis.findAvg(lab2);                                                                //Find the average of 5 quizzes among 40 students
		System.out.println("Stud\tQu1\tQu2\tQu3\tQu4\tQu5");                                   //Display grades information
		while(lab2[count]!=null){
			lab2[count].displayInfo();                                                         //Display students information
			count++;
			if(count == 40) break;
		}
		analysis.displayGrades();                                                              //Display analytic statistics
	}
}
