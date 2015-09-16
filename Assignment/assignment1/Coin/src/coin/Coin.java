package coin;

/*
@Author--Yi Qiu
@Date--Sep/04/2015
@version--1.0
*/
public class Coin {
	public String sideUp;           //The coin facing up.
	
	//Constructor
	public Coin(){
		double probability = Math.random();
		if(probability>=0.5) sideUp = "head";
		else sideUp = "tails";
	}
	public void toss(){            //Toss the coin and change the facing up accordingly.
 		double probability = Math.random();
		if(probability>=0.5) sideUp = "head";
		else sideUp = "tails";
	}
	public void display(int count){//Display the result of each toss.
		System.out.println("Result "+(count+1)+" = "+sideUp);
	}
	public String getSideUp(){    //Return the current facing up of the coin.
		return sideUp;
	}
}
