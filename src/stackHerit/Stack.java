package stackHerit;

abstract class Stack {
	protected Integer[] stackArray = null;
	protected int size;
	
	/**
	 * Constructor
	 * @param s size of the Array
	 */
	public Stack(int s) throws IllegalStateException{
		if(s<1)
			throw new IllegalStateException("La taille de la pile doit être supérieure à 1!");
		
		size = s;
		stackArray = new Integer[size];
		for(int i=0; i<stackArray.length; i++){
			stackArray[i] = null;
		}
	}
	
	/**
	 * Return the number of elements in the array
	 * @return number of elements
	 */
	public int getNumberOfElements(){
		int count = 0;
		for(int i=0; i<stackArray.length; i++){
			if(stackArray[i] != null)
				count++;
		}
		
		return count;
	}
	
	/**
	 * Check is the array is empty
	 * @return boolean
	 */
	public boolean isEmpty(){
		if(getNumberOfElements() == 0)
			return true;
		else 
			return false;
	}
	
	/**
	 * Check is the array is full
	 * @return boolean
	 */
	public boolean isFull(){
		if(getNumberOfElements() == size)
			return true;
		else 
			return false;
	}

	/**
	 * Return the head int of the stack
	 * @return int
	 * @throws IllegalStateExceptio
	 */
	public int head() throws IllegalStateException{
		Integer headInt = null;
		
		if(isEmpty())
			throw new IllegalStateException("La pile est vide!");
		
		for(int i=stackArray.length-1; i>=0; i--){
			if(stackArray[i] != null){
				headInt = stackArray[i];
				break;
			}
		}
		
		return headInt;
	}
	
	/* Abstract functions */
	abstract void push(int x);
	abstract void pop();
	
	/*Getters*/
	public Integer[] getStackArray() {
		return stackArray;
	}
	
	public int getSize(){
		return stackArray.length;
	}
}
