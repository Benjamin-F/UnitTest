package stackOrig;

import java.util.Arrays;

public class Stack {
	private Integer[] stackArray = null;
	private int size;
	
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
	 * Add new int in the stack
	 * @param x
	 * @throws IllegalStateException
	 */
	public void push(int x) throws IllegalStateException{
		
		if(isFull())
			throw new IllegalStateException("La pile est pleine!");
		
		for(int i=0; i<stackArray.length; i++){
			if(stackArray[i] == null){
				stackArray[i] = x;
				break;
			}
		}
	}
	
	/**
	 * Delete from stack 
	 * @param x
	 * @throws IllegalStateException
	 */
	public void pop() throws IllegalStateException{
		
		if(isEmpty())
			throw new IllegalStateException("La pile est vide!");
		
		for(int i=stackArray.length-1; i>=0; i--){
			if(stackArray[i] != null){
				stackArray[i] = null;
				break;
			}
		}
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
	
	/*Getters*/
	public Integer[] getStackArray() {
		return stackArray;
	}
	
	public int getSize(){
		return stackArray.length;
	}
	
	/*Overrides*/
	@Override
	public String toString() {
		return "Stack [stackArray=" + Arrays.toString(stackArray) + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		result = prime * result + Arrays.hashCode(stackArray);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stack other = (Stack) obj;
		if (size != other.size)
			return false;
		if (!Arrays.equals(stackArray, other.stackArray))
			return false;
		return true;
	}
}
