package analyticModel;

import analyticModel.Student;

/*
 * @Author--Yi
 * @Version--1.0
 * @Date--Sep/10/2015
 */

//This class is an abstract class that process the students' grades.
//Any class that extends this class should give the implementation of these three methods. 

public abstract class Statistics {
	//Find the lowest score among students
	public abstract void findLowest(Student[] stu);
	
	//Find the highest score among students
	public abstract void findHighest(Student[] stu);
	
	//Find the average score among students
	public abstract void findAvg(Student[] stu);
}
