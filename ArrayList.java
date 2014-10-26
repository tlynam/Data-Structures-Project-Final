/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

public class ArrayList<TBA> {
	private int capacity = 100;
	private Object[] data = new Object[capacity];
	private int numElements = 0;
	
	//Get method that returns TBA object for an index
	public TBA get(int index){
		//Invariants for index
		if(index > numElements || index < 0){
			throw new PizzaException("Bad index");
		}
		//Cast return value as TBA object
		return (TBA) data[index];
	}
	
	//Set method that will write or overwrite value at index
	public void set(TBA o, int index){
		//Check for bad index
		if(index > numElements || index < 0){
			throw new PizzaException("Bad index");
		}
		TBA that = (TBA) o;
		//Set data to new TBA object
		data[index] = that;
	}
	
	//Insert TBA object into data at index
	public void insert(TBA o, int index){
		//Invariants for object and index
		if(o == null || index < 0 || index > numElements){
			throw new PizzaException("Bad input");
		}
		
		//Resize data array if reach max size
		if(numElements == capacity){
			//Call resize method to increase size
			resize();
		}
		TBA that = (TBA) o;
		
		//Shift array to insert new TBA
		shiftRight(index);
		data[index] = that;
		//Increase number of elements after inserting new TBA
		numElements++;
	}
	
	//Add function that redirects to insert
	public void add(TBA o){
		insert(o, numElements);
	}
	
	//Private resize method that increases size of array
	//Create new array that's 10x larger and copy in data from old array
	private void resize(){
		//Increasing by factor of 10
		capacity = capacity * 2;
		Object tempData[] = new Object[capacity];
		//Copy old array into new array
		for(int i=0;i<numElements;i++){
			tempData[i] = data[i];
		}
		data = tempData;
	}
	
	//Shift right method for inserting objects
	private void shiftRight(int start){
		for(int i=numElements-1; i >= start; i--){
			data[i+1] = data[i];
		}
	}
	
	//Remove method that delete object by shifting array left to overwrite it
	public TBA remove(int index){
		//Index invariants
		if(index < 0 || index >= data.length){
			throw new PizzaException("Bad Index");
		}
		//Shift array left to overwrite
		Object retval = shiftLeft(index);
		//Decrease number of elements
		numElements--;
		//Return TBA object
		return (TBA) retval;
	}
	
	//Shift left method to overwrite array object for removing
	private Object shiftLeft(int start){
		Object retVal = data[start];
			//Iterate over array for overwriting
			for(int i = start; i < numElements-1; i++) {
				data[i] = data[i+1];
			}
		//Return value that was overwritten
		return retVal;
	}
	
	public ArrayList() {}
	
	//Copy constructor for ArrayList
	public ArrayList(ArrayList<TBA> other){
		this.capacity = other.capacity;
		this.numElements = other.numElements;
		for(int i=0; i<other.numElements; i++){
			this.data[i] = other.data[i];
		}
	}
	
	//Return size of arraylist
	public int size(){
		return numElements;
	}
	
	//Swaps the two elements in the arraylist using the specified indices.
	public void swap(int idx1, int idx2){
		Object temp = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = temp;
	}
	
	//Overridden toString that shows TBAs in List
	@Override
	public String toString(){
		String temp = "";
		//Iterates over array and prints out each TBA
		for(int i=0; i<numElements; i++){
			temp += data[i].toString() + "\n";
		}
		return temp;
	}

	//Finds index of TBA
	public int indexOf(TBA o){
		//Invariant to see if passed object is null
		if(o == null){
			throw new PizzaException("Bad input");
		}
		//Iterate through array to find TBA
		for(int i=0; i<numElements; i++){
			if(data[i] == o) return i;
		}
		return -1;
	}
	
	//Main to test ArrayList
	public static void main(String[] args){
		ArrayList<String> a = new ArrayList<String>();
		
		a.insert("Foo",0);
		a.insert("b",1);
		a.remove(1);
		
		System.out.println(a.toString());
		
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		
		pizzas.add(new Pizza());
		
	}
}
