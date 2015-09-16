package analyticModel;

/*
 * @Author--Yi
 * @Version--1.0
 * @Date--Sep/10/2015
 */

//This interface gives two methods that display students information and grades
//Any class that implements this interface must give the real implementation of these two methods

public interface PrintInfo {
	//Display students' information, e.g: ID and score
	public abstract void displayInfo();
	//Display statistics of these students, e.g: Lowest score, highest score and average score.
	public abstract void displayGrades();
}
