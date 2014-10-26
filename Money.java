import java.io.Serializable;

/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Money class holds a monetary value
//It stores dollars and cents as ints
//Money implements comparable and cloneable
public class Money implements Comparable, Cloneable, Serializable{
	private int dollars = 0;
	private int cents = 0;
	
	//Setter for dollars with invariants
	public void setDollars(int d){
		//Don't allow negative dollars and exit the program if passed negative dollars.
		if(d < 0) {
			System.out.println("Dollars can't be negative.  Please fix dollars");
			System.exit(-1);
		} else {
			dollars = d;
		}
	}
	
	//Setter for cents with invariants
	public void setCents(int c){
		//Can't have negative cents
		if(c < 0) {
			System.out.println("Cents can't be negative.  Please fix cents");
			System.exit(-1);
		}
		//If pass > 99 cents, adds to dollar amount.  
		else if(c > 99){
			cents = c % 100;
			dollars += (c - cents)/100;
		} else {
			cents = c;
		}
	}
	
	//Getter for dollars
	public int getDollars() {
		return dollars;
	}
	
	//Getter for cents
	public int getCents() {
		return cents;
	}
	
	//Default constructor
	public Money() {}
	
	//Constructor that takes an int for dollars
	public Money(int d) {
		dollars = d;
	}
	
	//Copy constructor that takes a Money object
	public Money(Money amount){
		setDollars(amount.dollars);
		setCents(amount.cents);
	}
	
	//Clone method that uses the copy constructor
	//Overriding the clone method to ensure I didn't make a mistake
	@Override
	public Money clone(){
		return new Money(this);
	}
	
	public Money(int d, int c){
		setMoney(d, c);
	}
	
	//Setter for money that takes dollars and cents.  Calls the dollar and cents setters.
	public void setMoney(int d, int c){
		setDollars(d);
		setCents(c);
	}
	
	//Getter for the amount of dollars and cents
	public String getAmount(){ 	
		return String.format("$%d.%d", dollars, cents);
	}

	//Setter for amount of dollars and cents
	public void setAmount(Money amount){
		setDollars(amount.dollars);
		setCents(amount.cents);
	}
	
	//Overridden toString from Object class returning amount method.
	@Override
	public String toString(){
		return getAmount();
	}
	
	//Overridden equals from Object class.  Returns false if passed null.
	@Override
	public boolean equals(Object o){
		if(o == null || ! (o instanceof Money)){
			return false;
		} else {
		Money that = (Money) o;
		return this.dollars == that.dollars &&
				this.cents == that.cents;
		}
	}
	
	//Driver for money to test
	public static void main(String[] args){
		Money a = new Money(0);
		//money.setCents(1000);
		//System.out.println(money.toString());
		
		Money b = a.clone();
		
		a.setCents(100);
		
		System.out.println(a.toString());
		
		//System.out.println(b.toString());
	}

	//Implementing compareTo interface
	//This compares this Bill with that of a passed Bill object
	//It compares on the amount of the Bill
	@Override
	public int compareTo(Object o) {
		if(o == null || !(o instanceof Money)){
			throw new PizzaException("Passed Object isn't Money");
		}
		Money that = (Money) o;
		//I obtain the string value of the Bill in terms of dollars and cents
		String this_money = this.getDollars() + "." + this.getCents();
		String that_money = that.getDollars() + "." + that.getCents();
		//I parse this string value into a double and subtract this Bill value from the passed Bill value
		Double retVal = Double.parseDouble(this_money) - Double.parseDouble(that_money);
		//I made a variable retVal that takes the double value so that it can handle comparisons less than a dollar
		//I go through the cases with If else clauses to return 0 if equal, 1 if this is greater, and -1 if that passed Bill object is greater
		if(retVal == 0){
			return 0;
		}
		else if(retVal>0){
			return 1;
		}
		else{
			return -1;
		}
	}

}
