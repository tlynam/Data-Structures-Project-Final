/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Meat class extends Ingredient
//Meat is an intermediate class that passes values from types of meat to the ingredient super class
public class Meat extends Ingredient {
	
	//Constructor that passes values from child class to super class
	public Meat(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

}
