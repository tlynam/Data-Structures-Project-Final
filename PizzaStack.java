/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//ObjectStack class is a stack for objects.
//Includes: default constructor, copy constructor, isEmpty?, size, Overridden toString and Equals, push, and pop
public class PizzaStack {
	//Initialized variables
	int capacity = 100; //Setting capacity to start at 100 and later can update if reach capacity.
	Object data[] = new Object[capacity]; //Initializing Object array with size of capacity variable.
	int numElements = 0; //Start number of elements at 0

	//Default constructor
	public PizzaStack() {}
	
	//Copy constructor.  This copies the primitives of each attribute.
	public PizzaStack(PizzaStack other){
		this.capacity = other.capacity;
		this.numElements = other.numElements;
		for(int i=0; i<other.numElements; i++){ //Iterate through array and copy each object
			this.data[i] = other.data[i];
		}
	}
	
	//Is empty method checks to see if numElements is 0 and returns boolean value
	public boolean isEmpty() {
		if(numElements == 0){
			return true;
		}
		return false;
	}
	
	//Size returns numElements
	public int size(){
		return numElements;
	}
	
	//push method will add passed object to top of stack.  Will check to see if object array will need to be increased.
	public void push(Pizza o){
		if(capacity == numElements){ //If capacity is equal to numElements, dynamically increase array
			capacity = capacity * 2;
			Object tempData[] = new Object[capacity];
			for(int i=0;i<numElements;i++){ //Copy all objects to new temp array
				tempData[i] = (Pizza) data[i];
			}
			tempData[numElements++] = o; //Set new value in the larger temp array
			data = tempData; //Set original array to new address of larger temp array
		} else{  //If resize isn't needed, adds object to top of Object array
			data[numElements] = o;
			numElements++;
		}
	}
	
	//Pop returns the last item in the array and decreases numElements
	public Object pop(){
		if(numElements == 0){ //If there are zero elements, exit
			System.out.println("Stack is already empty.");
			System.exit(-1);
		}
		if(numElements > 0) {
			Object retval = data[numElements-1]; //Set retval
			numElements--; //Decrease numElements
			return retval; //Return retval
		}
		return "Stack is empty";
	}

	//Override default object toString that normally returns the memory value to return a string comprising of the array objects
	@Override
	public String toString(){
		String temp = ""; //Create temp string to hold all values
		for(int i=0; i<numElements; i++){ //Iterate through data array of objects
			temp += data[i].toString() + " "; //Append to temp string new object string values
		}
		return temp; //Return temp string with all object string values
	}
	
	//Equals will first check if the passed object is null or not an ObjectList.
	//Then it scans through the list of elements and checks the items and ordering for equality.
	//It also checks the size value in case the second object is longer.
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof PizzaStack)){  //Validate passed object is an ObjectStack
			return false;
		}
		PizzaStack that = (PizzaStack) o; //Cast that variable as ObjectStack of o
		for(int i=0; i<numElements; i++){
			if(data[i] != that.data[i]) return false; //If an object doesn't match return false
		}
		if(this.size() != that.size()){ //If the ObjectStack sizes are different return false
			return false;
		}
		return true; //Return true when nothing has matched as false
	}
}
