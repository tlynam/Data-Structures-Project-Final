//package pizzaMainClasses;
/* 
 * CSS 162, Pizza Manager Project
 * Summer 2014
 * 
 * This interface can do everything the Comparable interface can and more
 * 
 * Author: Rob Nash
 * Student: Todd Lynam
 */
public interface PizzaComparable extends Comparable {  //Example of interface inheritance
	
	@Override
	public int compareTo(Object o); 	 		//a.k.a compareToByPrice
	//non-overrides
	public int compareToBySize(Object o); 		//a.k.a. compareToByAreaLeft
	public int compareToByFraction(Object o); 		//a.k.a. compareToByFraction
	public int compareToByCalories(Object o);	
	
}
