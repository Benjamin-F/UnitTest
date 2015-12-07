package stackOrig;

import java.util.Arrays;

public class Queue {
	private Stack stackBegin = null;
	private Stack stackEnd = null;
	private Integer[] queueArray = null;
	private int size;
	
	/**
	 * Constructor
	 * @param s size
	 * @throws IllegalStateException if too small
	 */
	public Queue(int s)throws IllegalStateException{
		//Throw exception
		if(s<1)
			throw new IllegalStateException("La taille de la pile doit être supérieure à 1!");
		
		//Size
		size = s;
		
		//Stacks init
		stackBegin = new Stack(size);
		stackEnd = new Stack(size);
		
		//Queue init
		queueArray = new Integer[size];
		for(int i=0; i<queueArray.length; i++){
			queueArray[i] = null;
		}
	}

	/**
	 * Enqueue
	 */
	public void enqueue(){
		//If empty stack, exception
		if(stackBegin.isEmpty())
			throw new IllegalStateException("La pile de début est vide!");
		
		//If full queue, exception
		if(isFull())
			throw new IllegalStateException("La file d'attente est pleine!");
		
		//Go through queue
		for(int i=0; i<queueArray.length; i++){
			//First null element
			if(queueArray[i] == null){
				//Enqueue
				queueArray[i] = stackBegin.head();
				stackBegin.pop();
				break;
			}
		}
	}

	/**
	 * Dequeue
	 */
	public void dequeue(){
		//If stack full, exception
		if(stackEnd.isFull())
			throw new IllegalStateException("La pile de fin est pleine!");
		
		//If queue empty, exception
		if(isEmpty())
			throw new IllegalStateException("La file d'attente est vide!");
		
		//Dequeue
		stackEnd.push(queueArray[0]);
		
		//Move elements
		for(int i=1; i<queueArray.length; i++){
			queueArray[i-1] = queueArray[i];
		}
		
		//Last element must be null
		queueArray[queueArray.length-1] = null;
	}
	
	/**
	 * Return the number of elements in the array
	 * @return number of elements
	 */
	public int getNumberOfElements(){
		int count = 0;
		for(int i=0; i<queueArray.length; i++){
			if(queueArray[i] != null)
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
	
	/*Getters*/
	public Stack getStackBegin() {
		return stackBegin;
	}

	public Stack getStackEnd() {
		return stackEnd;
	}

	public Integer[] getQueueArray() {
		return queueArray;
	}
	
	/*Overrides*/
	@Override
	public String toString() {
		return "Queue [stackBegin=" + stackBegin + ", stackEnd=" + stackEnd + ", queueArray="
				+ Arrays.toString(queueArray) + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(queueArray);
		result = prime * result + size;
		result = prime * result + ((stackBegin == null) ? 0 : stackBegin.hashCode());
		result = prime * result + ((stackEnd == null) ? 0 : stackEnd.hashCode());
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
		Queue other = (Queue) obj;
		if (!Arrays.equals(queueArray, other.queueArray))
			return false;
		if (size != other.size)
			return false;
		if (stackBegin == null) {
			if (other.stackBegin != null)
				return false;
		} else if (!stackBegin.equals(other.stackBegin))
			return false;
		if (stackEnd == null) {
			if (other.stackEnd != null)
				return false;
		} else if (!stackEnd.equals(other.stackEnd))
			return false;
		return true;
	}
		
}
