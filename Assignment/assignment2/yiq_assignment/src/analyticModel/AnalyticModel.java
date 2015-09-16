package analyticModel;
import analyticModel.PrintInfo;
import analyticModel.Statistics;
import analyticModel.Student;

/*
 * @Author--Yi
 * @Version--1.0
 * @Date--Sep/10/2015
 */

//This class is to analyze the students' information to get their lowest, highest and average scores.

public class AnalyticModel extends Statistics implements PrintInfo{
	private int[] lowScores = new int[5];                    //Create an array that store the lowest score of each quiz
	private int[] highScores = new int[5];                   //Create an array that store the highest score of each quiz
	private double[] avgScores = new double[5];              //Create an array that store the average score of each quiz
	
	//To find out the lowest grade of each quiz among students
	public void findLowest(Student[] student){
		for(int i=0;i<5;i++){
			int minimum = 101;                               //To store the minimum score of each quiz temporarily
			int j = 0;
			while(student[j]!=null){
				if((student[j].getScores())[i]<=minimum){
					minimum = (student[j].getScores())[i];
				}
				if(j==39) break; 
				j++;
			}
			lowScores[i] = minimum;
			}
		}
	
	//To find out the highest grade of each quiz among students
	public void findHighest(Student[] student){
		for(int i=0;i<5;i++){
			int maximum = 0;                                 //To store the maximum score of each quiz temporarily
			int j = 0;
			while(student[j]!=null){
				if((student[j].getScores())[i]>=maximum){
					maximum = (student[j].getScores())[i]; 
				}
				if(j==39) break; 
				j++;
			}
			highScores[i] = maximum;
			}
	}
	
	//To find out the average grade of each quiz among students
	public void findAvg(Student[] student){
		for(int i=0;i<5;i++){
			int j = 0;
			double summation = 0.0;
			while(student[j]!=null){
				summation+=(student[j].getScores())[i];
				j++;
				if(j==40) break; 
			}
			double manyBits = summation/j;
			avgScores[i] = ((int)(manyBits*10))/10.0;
			}
		}
	
	//Display the statistics grades of each quiz among students
	public void displayGrades(){
		System.out.print("Lowest\t");
		for(int i=0;i<5;i++){
			System.out.print(lowScores[i]+"\t");
		}
		System.out.println();
		System.out.print("Highest\t");
		for(int i=0;i<5;i++){
			System.out.print(highScores[i]+"\t");
		}
		System.out.println();
		System.out.print("Average\t");
		for(int i=0;i<5;i++){
			System.out.print(avgScores[i]+"\t");
		}
	}
	
	//This is an empty method since nothing should be done here.
	public void displayInfo(){}
}
