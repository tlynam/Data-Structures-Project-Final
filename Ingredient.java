import java.awt.Color;

/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Ingredient class contains the Pizza ingredients
//It implements the comparable interface 
public class Ingredient implements Comparable{
	//Ingredients have these attributes
	private String description;
	private Money cost;
	private int calories;
	private Color myColor;
	private String colorName;
	
	//Default constructor
	public Ingredient() {}
	
	//Constructor that is passed description, cost and calories
	public Ingredient(String description, Money cost, int calories) {
		setDescription(description);
		setCost(cost);
		setCalories(calories);
	}

	//Constructor that is passed description, cost, calories, and color
	//Veggies have a color and use this constructor
	public Ingredient(String description, Money cost, int calories, Color color) {
		setColor(color);
		setDescription(description + " which are " + colorName);
		setCost(cost);
		setCalories(calories);
	}
	
	//Getter for returning color of ingredient
	public Color getColor() {
		return myColor;
	}
	
	//Setter for color
	//This converts the passed Color object to a Color name string
	public void setColor(Color that){
		myColor = that;
		
		//Converts RGB to color strings
		if(myColor.getRed() == 255 && myColor.getGreen() == 0 && myColor.getBlue() == 0) {
			colorName = "red";
		}
		else if(myColor.getRed() == 0 && myColor.getGreen() == 255 && myColor.getBlue() == 0) {
			colorName = "green";
		} else{
			colorName = "black";
		}
		//System.out.println("R: " + myColor.getRed() + " G: " + myColor.getGreen() + " B " + myColor.getBlue());
	}
	
	//Setter for description
	public void setDescription(String d){
		description = d;
	}
	
	//Getter for cost Money object
	public Money getCost() { //immutable
		return cost;
	}
	
	//Getter for Description
	public String getDescription(){
		return description;
	}
	
	//Setter for cost
	public void setCost(Object o){
		//Validate Money input object
		if(o == null || !(o instanceof Money)){
			throw new PizzaException("Invalid Cost");
		}
		Money m = (Money) o;
		cost = m;
	}
	
	//Getter for calories
	public int getCalories() { //immutable
		return calories;
	}
	
	//Setter for calories
	public void setCalories(int c) {
		if(c <= 0){
			throw new PizzaException("Invalid calories");
		}
		else{
			calories = c;
		}
	}

	//Compare based on cost
	//Note that this method can simply redirect to the Money’s compareTo function, and so is a façade or adapter.
	@Override
	public int compareTo(Object o) {
		return cost.compareTo(o);
	}

}
