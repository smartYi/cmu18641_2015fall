package coin;

/*
@Author--Yi Qiu
@Date--Sep/04/2015
@version--1.0
*/

public class Test {
	public static void main(String[] args){
		Coin coin = new Coin();                       //Construct a new coin
		Simulation simulation =  new Simulation(coin);//Construct a new coin toss simulator
		simulation.TossConstructor(coin);             //Call the function and do 20 times toss.
		}
}