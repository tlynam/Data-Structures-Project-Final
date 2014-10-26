/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Fraction class that holds fraction value as two ints, one for numerator and one for denominator
//Has ability to reduce and subtract
public class Fraction implements Comparable{
	private int numerator;
	private int denominator;
	
	//Default constructor sets fraction as 1/1
	public Fraction() {
		setNumerator(1);
		setDenominator(1);
	}
	
	//Another constructor that takes numerator and denominator as arguments
	public Fraction(int num, int denom){
		reduce(num, denom);
	}
	
	//Copy constructor that takes fraction as argument
	public Fraction(Fraction toCopy){
		//Calls setters to set values
		setNumerator(toCopy.getNumerator());
		setDenominator(toCopy.getDenominator());
	}
	
	//Implementing Cloneable with this clone method
	//Overrides base class clone
	//Utilizes copy constructor to return new clone
	@Override
	public Fraction clone(){
		return new Fraction(this);
	}
	
	//Reduce function that reduces fraction to lowest form
	//Can accept negative values and store the negative value in the numerator
	public void reduce(int num, int denom){
		//Here we check for a denominator that's 0 and alert the user to the issue
		if(denom == 0){
			throw new PizzaException("Denom can't be 0");
		}
		
		//This counter is to determine the value to count to when looping in a for loop to find the greatest common divisor for the numerator and denominator.
		int counter = 1;
		
		//This is greatest common divisor variable.  It will be set to the highest value that is divisible by both numerator and denominator. 
		int gcd = 1;
		
		//This is a boolean to determine if the fraction is negative or not.  If both numerator and denominator are negative, it will become positive.
		boolean positiveFraction;
		
		if(num < 0 && denom < 0){
			positiveFraction = true;
		}
		else if(num > 0 && denom > 0){
			positiveFraction = true;
		}
		else {
			positiveFraction = false;
		}
		
		//This creates new temporary numerator and denominators that have the computed absolute values.  This will avoid issues when looping to a negative number.
		int tempNum = Math.abs(num);
		int tempDenom = Math.abs(denom);
		
		//Setting counter to the smaller value between the numerator and denominator for loop when finding the greatest common denominator to reduce the fractions.  This is more efficient.
		if(tempNum < tempDenom){
			counter = tempNum;
		}
		else {
			counter = tempDenom;
		}
		
		//For loop to find the greatest common divisor for both the numerator and denominator
		for(int i=1; i<=counter; i++){
			if((tempNum % i == 0) && (tempDenom % i == 0)) gcd = i; //Use modulus to see if the incrementer i divides by both the numerator and denominator
		}
		
		//After finding the greatest common divisor, we divide both numerator and denominator by the value to reduce the fraction as far as it can go.
		num = num / gcd;
		denom = denom / gcd;
		
		//Initialize numerator and denominator to positive
		num = Math.abs(num);
		denom = Math.abs(denom);
		
		//Here we apply a negative value to the numerator if the fraction is negative.
		//Applying the negative to just the numerator instead of a mix of the negative value
		//on the numerator and denominator will consolidate those scenarios.
		if(positiveFraction == false) {
			num = num * -1;
		}
		
		if(num == 0){
			setNumerator(0);
			setDenominator(0);
		}
		//else if(positiveFraction == false){
			//throw new RuntimeException("Can't have negative fraction");
		//}
		else{
			//Finally we have our final reduced fraction and use our setters to set the values.
			setNumerator(num);
			setDenominator(denom);
		}
	}
	
	//This is the getter for the Numerator
	public int getNumerator(){
		return this.numerator;
	}
	
	//Setting Numerator for the fraction class.
	public void setNumerator(int num){
		this.numerator = num;
	}
	
	//This is the getter for the Denominator
	public int getDenominator(){
		return this.denominator;
	}
	
	//Setting Denominator for the fraction class.  Including a validation that the denominator can't be 0.
	public void setDenominator(int denominator){
		if(denominator != 0){
			this.denominator = denominator;
		} else if(numerator == 0){
			this.denominator = 0;
		}
		else{
			throw new PizzaException("Can't have denominator of 0");
		}
	}

	//This equals overrides the default equals as it checks based on the primitive values of the fraction
	public boolean equals(Object o){
		if(o == null || !(o instanceof Fraction)){
			throw new PizzaException("Bad input");
		}
		Fraction that = (Fraction) o;
		return this.numerator == that.numerator && this.denominator == that.denominator;
	}
	
	//Fraction compare to
	//Uses equals method to see if fractions are equal and returns 0
	//Uses subtract method as the return value, which will be positive or negative
	//Returning positive means this Fraction is greater
	//Returning negative means the compared Fraction is greater
	@Override
	public int compareTo(Object o) {
		if(o == null || !(o instanceof Fraction)){
			throw new PizzaException("Bad input");
		}
		Fraction that = (Fraction) o;
		if(this.equals(that)){
			return 0;
		}
		Fraction temp = this.clone();
		temp.subtract(that);
		return temp.numerator;
	}
	
	//This toString overrides the default toString to be more readable
	public String toString(){
		return getNumerator() + "/" + getDenominator();
	}

	//Subtracts the Fraction f from this Fraction.
	//Throws an exception if < 0, but not == 0
	public void subtract(Fraction f){
		//Validates for proper input
		if(f == null || !(f instanceof Fraction)){
			throw new PizzaException("Bad input");
		}
		Fraction that = (Fraction) f;
		//Multiplies numerators and denominators to have same denominators
		int newDenom = this.denominator * that.denominator;
		int num1 = this.numerator * that.denominator;
		int num2 = that.numerator * this.denominator;
		//Can now simply subtract
		int finalNum = num1 - num2;
		//Reducing in case reduction is needed
		reduce(finalNum, newDenom);
	}
	
	//This is the main driver of the application
	public static void main(String[] args){
		/*
		 * Old Fractions homework
		//This is the ObjectList object called fractions that will contain a list of the FractionCounters
		ObjectList fractions = new ObjectList();
		//Read input file and write data into fractionInputList array
    	try { //Using try/catch blocks to respond appropriately if the text file is missing or typed incorrectly
	        //Scanner reads the fractions text file
    		Scanner sc = new Scanner(new File("fractions.txt"));
		    //Will keep reading the next lines of the file until there are no more
    		while(sc.hasNextLine()) {
    			//This converts each line of the file to a string
		    	String line = sc.nextLine();
		    	//System.out.println(line);
		    	//This splits the line string based on the dividing symbol using the String split method and the regular expression for /.  This requires escaping the /.
		    	String[] result = line.split("\\/");
		    	//System.out.println(result[0] + "/" + result[1]);
		    	//Creating new Fraction object f
		        Fraction f = new Fraction(Integer.parseInt(result[0]), Integer.parseInt(result[1]));		        
		        //System.out.println(f.toString());
		        
		        //This calls the contains method on the fractions ObjectList to see if the fraction exists in the list
		        if(fractions.contains(f) == false){
		        	//If the fraction is unique, then a new FractionCounter object is created.  Otherwise, the existing counter is incremented.
		        	FractionCounter fc = new FractionCounter(f);
		        	//The fraction is then added to the Object List
		        	fractions.add(fc);
		        	//System.out.println(f.toString());
		        }
		    }
		    sc.close(); //Close scanner object to save memory
    	}
    	catch (FileNotFoundException e) {
    		throw new RuntimeException("File not found");
    	}
    	//This prints the reduced fractions to the console with an instance count
    	System.out.println(fractions.toString());
    	*/
		Fraction f1 = new Fraction(1,1);
		Fraction f2 = new Fraction(1,20);
		
		f1.subtract(f2);
		
		System.out.println(f1.toString());
		//System.out.println(f2.toString());
		//f1.subtract(f2);
		//System.out.println(f1.compareTo(f2));
    	
	}
}
