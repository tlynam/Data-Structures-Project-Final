import java.awt.Color;

/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//This is the Pizza class that holds the attributes and methods of a Pizza
//Pizza Implements PizzaComparable so Pizzas can be compared with one another
//Pizza overrides toString to print out each of the attributes it has
//Pizza has an int that keeps count of calories but dynamically calculates
//the area and cost with get functions
public class Pizza implements PizzaComparable{
	//Pizza attributes, most are complex data types
	private Money price = new Money(0,0);
	private Fraction size = new Fraction();
	private Shape myShape;
	private int calories = 0;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	//A constructor that builds a Pizza with a random number of ingredients
	//Using Math.random and if statements to determine the specific attributes of a Pizza
	public Pizza() {
		//Making Pizza Shape randomly a circle or square
		if(Math.random() > 0.5){
			Circle c = new Circle();
			myShape = c;
		}
		else{
			Square s = new Square();
			myShape = s;
		}
		
		//Making Random Base required
		if(Math.random() > 0.5){
			ingredients.add(new Marinara());
		}
		else{
			ingredients.add(new Alfredo());
		}
		
		//Making Random Cheese required
		if(Math.random() > 0.5){
			ingredients.add(new Goat());
		}
		else{
			ingredients.add(new Mozzarella());
		}
		
		//Making Meat optional
		//1/3 time Sausage, 1/3 time Pepperoni, 1/3 time no meat
		double meatSeed = Math.random();
		if(meatSeed < 0.33){
			ingredients.add(new Sausage());
		}
		else if(meatSeed > 0.33 && meatSeed < 0.66){
			ingredients.add(new Pepperoni());
		}
		
		//Making Veggies optional
		//1/3 time Pepper, 1/3 time Olive, 1/3 no veggies
		double veggieSeed = Math.random();
		//When selecting a Pepper, 1/2 time black and 1/2 time green
		if(veggieSeed < 0.33){
			if(Math.random() > 0.5){
				ingredients.add(new Pepper(Color.GREEN));
			}
			else{
				ingredients.add(new Pepper(Color.RED));
			}
		}
		//When selecting an Olive, 1/2 time green, 1/2 red
		else if(veggieSeed > 0.33 && veggieSeed < 0.66){
			if(Math.random() > 0.5){
				ingredients.add(new Olive(Color.GREEN));
			}
			else{
				ingredients.add(new Olive(Color.BLACK));
			}
		}
		
		//Updating Pizza Object variables calories and initial cost of ingredients
		int currentCents = 0;
		int currentDollars = 0;
		int ingredientCents = 0;
		int ingredientDollars = 0;
		//Looping through each ingredients in the ingredient Array List
		for(int i=0;i<ingredients.size();i++){
			calories += ingredients.get(i).getCalories();
			//System.out.println(ingredients.get(i).getDescription() + " Calories: " + ingredients.get(i).getCalories() + " Cost: " + ingredients.get(i).getCost());
			
			currentCents = price.getCents();
			currentDollars = price.getDollars();
			ingredientCents = ingredients.get(i).getCost().getCents();
			ingredientDollars = ingredients.get(i).getCost().getDollars();
			
			price.setDollars(currentDollars+ingredientDollars);
			price.setCents(currentCents+ingredientCents);
		}
		
		//System.out.println("Calories: " + calories);
		//System.out.println("Price: " + price.toString());		
	}
	
	//Overriding the base class toString
	@Override
	public String toString(){
		String toppings = "";
		//For loop so that the first ingredient in the ingredient arraylist doesn't have "and" in front of it
		for(int i=0;i<ingredients.size();i++){
			if(i == 0){
				toppings = ingredients.get(i).getDescription();
			}
			else {
				toppings = toppings + " and " + ingredients.get(i).getDescription();	
			}
		}
		//Obtain dynamically calculated remaining value for Pizza by calling getRemainingArea
		double area = getRemainingArea();
		//Downsizing area so it's not as long when printing to console
		String areaStr = String.valueOf(area);
		if(areaStr.length()>7){
			areaStr = areaStr.substring(0, 7);
		}
		//Adding 0's for cleaning formatting of area in console
		//It's a lot easier to read this way
		else if(areaStr.length()<7){
			int temp = 7 - areaStr.length();
			for(int i=0;i<temp;i++){
				areaStr = areaStr + "0";
			}
			
		}
		
		return "Shape: " + myShape.getShapeType() + " Area: " + areaStr + " Calories: " + calories + " Price: " + getCost().toString() + " Fraction Left: " + getFraction() + " Toppings: " + toppings;
	}
	
	//Getters & setters for the Fractional amount of the pizza remaining
	public Fraction getFraction(){
		return size;
	}
	
	public void setFraction(int num, int denom){
		size.setNumerator(num);
		size.setDenominator(denom);
	}
	
	//Dynamically calculates Remaining Area
	public double getRemainingArea(){
		//Obtain the numerator and denominator of size fraction that contains fraction of pizza left
		double numAvail = (double) size.getNumerator();
		double denomAvail = (double) size.getDenominator();
		//Divide numerator and denominator as doubles for accuracy
		double amountAvail = numAvail/denomAvail;
		//System.out.println("amountAvail: " + amountAvail);
		
		//Calculate remaining area by obtaining the starting area with getArea() and
		//multiplying that by the fraction remaining
		return myShape.getArea() * amountAvail;
	}
	
	//Dynamically calculates current cost of pizza
	//Cost finds the percentage of what is available from the current fraction and calculates the new Money object
	public Money getCost(){
		//Obtain the numerator and denominator of size fraction that contains fraction of pizza left
		double numAvail = (double) size.getNumerator();
		double denomAvail = (double) size.getDenominator();
		//Divide numerator and denominator as doubles for accuracy
		double amountAvail = numAvail/denomAvail;
		//System.out.println("amountAvail: " + amountAvail);
		
		//Obtain cost of whole pizza with current ingredients
		double currentCost = Double.parseDouble(price.getDollars() + "." + price.getCents());
		
		//Determine new cost by multiplying original cost and fraction remaining
		double newCost = currentCost * amountAvail;
		
		//Splitting value of double into dollars and cents strings
		//Use regex to split on '.'
		//Split returns an array of results
		String[] newAmount = String.valueOf(newCost).split("\\.");
		//Dollars is the first item in array
		String newDollars = newAmount[0];
		//Cents is the second entry in array
		//Append some 0's so that the next substring doesn't encounter
		//an index out of bounds error for cents of single digits
		String newCents = newAmount[1] + "0000";
		newCents = newCents.substring(0, 2);
		
		//Return new Money object that holds the current cost of a pizza
		return new Money(Integer.parseInt(newDollars), Integer.parseInt(newCents));
	}
	
	//Function to reduce the fraction of pizza remaining
	//This function reduces the fraction of a pizza by the passed fraction amount
	public void eatSomePizza(Object o){
		//Check for valid Fraction passed
		if(o == null || !(o instanceof Fraction)){
			throw new PizzaException("Invalid Fraction passed for eating some pizza");
		}
		Fraction amount = (Fraction) o;

		//Subtract passed Fraction
		size.subtract(amount);
		//If numerator is negative, which is how I determine negatives in my fractions,
		//throw new exception as can't have negative amount of pizza
		if(size.getNumerator() < 0){
			throw new PizzaException("I wish you could, but unfortunately you can't eat more than the available pizza");
		}
		//If passed amount is the same as the current Fraction amount, then someone buys the remaining pizza
		//Throwing exception that the calling function catches
		else if(size.getNumerator() == 0){
			price = new Money(0,0);
			myShape.setArea(0);
			throw new PizzaException("Pizza has been eaten and will be removed from the Pizza list!");
		}
	}
	
	//Set Shape method that calls clone to avoid privacy leaks
	public void setShape(Shape s) {
		myShape = (Shape) s.clone();
	}
	
	//Get shape method that calls clone to avoid privacy leaks
	public Shape getShape() {
		return (Shape) myShape.clone();
	}
	
	//Getter for Calories
	public int getCalories(){
		return calories;
	}

	//CompareTo method for price
	//This allows pizza comparisions in terms of price
	@Override
	public int compareTo(Object o) {
		//Check for valid input
		if(o == null || !(o instanceof Pizza)){
			throw new PizzaException("Invalid money");
		}
		Pizza that = (Pizza) o;
		return this.getCost().compareTo(that.getCost());
	}

	//Compare to on Size
	//Allows pizzas to be compared to with size
	@Override
	public int compareToBySize(Object o) {
		//Check for valid input
		if(o == null || !(o instanceof Pizza)){
			throw new PizzaException("Invalid size");
		}
		Pizza that = (Pizza) o;
		//return this.size.compareTo(that.size);
		return (int) (this.getRemainingArea() - that.getRemainingArea());
	}
	
	//Compare to on Fraction
	//Allows pizzas to be compared to of Fraction
	@Override
	public int compareToByFraction(Object o) {
		//Check for valid input
		if(o == null || !(o instanceof Pizza)){
			throw new PizzaException("Invalid size");
		}
		Pizza that = (Pizza) o;
		return this.size.compareTo(that.size);
	}

	//Compare to on Calories
	//Allows pizzas to be compared to in terms of calories
	@Override
	public int compareToByCalories(Object o) {
		//Check for valid input
		if(o == null || !(o instanceof Pizza)){
			throw new PizzaException("Invalid size");
		}
		Pizza that = (Pizza) o;
		return this.calories - that.calories;
	}
	
	//Main used for testing Pizzas
	public static void main(String[] args){
		Pizza p = new Pizza();
		
		//System.out.println(p.ingredients);
	}
}
