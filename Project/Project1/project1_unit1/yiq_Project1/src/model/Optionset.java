package model;

import java.io.Serializable;

/*
@Author--Yi
@Version--1.0
@Date--Sep/14/2015
*/

//This class is to define option set for each model

public class Optionset implements Serializable{
	//Declare a serial version UID
		static final long serialVersionUID = 1;
		
	//Each optionset has a set of values
	private Option opt[];
	
	//Each model should have a name
	private String name;
	
	//Constructor: Default 
	protected Optionset(){}
	
	//Constructor with arguments
	protected Optionset(String name,int size){
		opt = new Option[size];
		this.name = name;
		
		//Create an object for each element in opt to avoid null pointer
		for(int i=0;i<size;i++){
			opt[i] = new Option();
			}
	}
	
	//Setters and getters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	
	protected Option[] getOpt() {
		return opt;
	}

	protected void setOpt(Option[] opt) {
		this.opt = opt;
	}

	//1:Set option
	protected void setOption(int optionIndex,String name,float price) {
		opt[optionIndex].name = name;
		opt[optionIndex].price = price;
	}
	
	//2: Get option 
	//2.1: Get option with its option index
	protected Option getOption(int optionIndex){
		if(opt[optionIndex]!=null){
			return opt[optionIndex];
		}
		return null;
	}
	
	//2.1: Get option with its option name
	protected Option getOption(String name){
		for(int i=0;i<opt.length;i++){
			if(opt[i]!=null && opt[i].getName().equals(name)){
				return opt[i];
			}
		}
		return null;
	}
	
	//3. Delete option
	//3.1: Delete option with its name
	protected void deleteOption(String name){
		for(int i=0;i<opt.length;i++){
			if(opt[i]!=null && opt[i].getName().equals(name)){
				opt[i] = null;
			}
		}
	}
	
	//3.2: Delete option with its option index
	protected void deleteOption(int optionIndex){
		if(optionIndex<opt.length && optionIndex>=0){
			if(opt[optionIndex]!=null){
				opt[optionIndex] = null;
			}
		}
	}
	
	//4. Update option name
	//4.1: Update option name with its old name
	protected void updateOptionName(String oldName, String newName){
		if(getOption(oldName) == null) return;
		else{
			getOption(oldName).setName(newName);
		}
	}
	
	//4.1: Update option name with its old index
	protected void updateOptionName(int optionIndex, String newName){
		if(getOption(optionIndex) == null) return;
		else{
			getOption(optionIndex).setName(newName);
		}
	}
	
	//5. Update option price
	//5.1: Update option price with its name
		protected void updateOptionPrice(String name, float price){
			if(getOption(name) == null) return;
			else{
				getOption(name).setPrice(price);
			}
		}
		
	//5.2: Update option price with its index
		protected void updateOptionPrice(int optionIndex, float price){
			if(getOption(optionIndex) == null) return;
			else{
				getOption(optionIndex).setPrice(price);
			}
		}
	
		
	//Print out all information in one option set
		protected void print(){
			for(int i=0;i<opt.length;i++){
				if(opt[i]!=null){
					System.out.println(opt[i].getName() + ": $"
				                      + String.format("%.2f", opt[i].getPrice()));
				}else{
					System.out.println("This option does not exist or has been deleted!");
				}
			}
		}
		
	protected class Option implements Serializable{
		//Declare a serial version UID
		static final long serialVersionUID = 1;
		
		//Each option set should have an exact option name
		private String name;
		
		//Each option should have a according price
		private float price;
		
		//Constructor
		//Default constructor
		protected  Option(){}
		
		//Constructor with arguments
		protected  Option(String name, float price) {
			this.name = name;
			this.price = price;
		}
		
		//Setters and getters
		protected void setName(String name) {
			this.name = name;
		}
		
		protected void setPrice(float price) {
			this.price = price;
		}
		
		protected String getName() {
			return this.name;
		}
		
		protected float getPrice() {
			return this.price;
		}
	}
}
