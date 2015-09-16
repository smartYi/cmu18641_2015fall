package analyticModel;
import analyticModel.PrintInfo;

/*
 * @Author--Yi
 * @Version--1.0
 * @Date--Sep/10/2015
 */

//This class is student class that contains students information
//This class implements the interface printInfo

public class Student implements PrintInfo{ 
	private int SID;                       //Students ID
	private int[] scores = new int[5];     //Five grades of five quizzes respectively
	
	//Instance variables setters and getters
	
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	//Display students' information
	public void displayInfo() {
		System.out.print(SID+"\t");
		for(int i=0;i<scores.length;i++){
		System.out.print(scores[i]+"\t");
		}
		System.out.println();
	}
	//An empty method since nothing should be done here.
	public void displayGrades(){}
	
}
