/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Pizza Exception class that extends RuntimeException
public class PizzaException extends RuntimeException{

	//Default no-arg constructor
	public PizzaException() {
		super();
	}
	
	//Constructor that passes the passed String to RuntimeException
	public PizzaException(String msg){
		super(msg);
	}

}
