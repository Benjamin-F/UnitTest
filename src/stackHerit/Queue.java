package stackHerit;

import stackOrig.Stack;

public class Queue extends Storage{
	private Stack stackBegin = null;
	private Stack stackEnd = null;
	
	/**
	 * Constructor
	 * @param s Stack size
	 */
	public Queue(int s){
		super(s);
	}
	
	/**
	 * Enqueue
	 */
	public void push(){
		//If empty stack, exception
		if(stackBegin.isEmpty())
			throw new IllegalStateException("La pile de début est vide!");
		
		//If full queue, exception
		if(isFull())
			throw new IllegalStateException("La file d'attente est pleine!");
		
		//Go through queue
		for(int i=0; i<stackArray.length; i++){
			//First null element
			if(stackArray[i] == null){
				//Enqueue
				stackArray[i] = stackBegin.head();
				stackBegin.pop();
				break;
			}
		}
	}

	/**
	 * Dequeue
	 */
	public void pop(){
		//If stack full, exception
		if(stackEnd.isFull())
			throw new IllegalStateException("La pile de fin est pleine!");
		
		//If queue empty, exception
		if(isEmpty())
			throw new IllegalStateException("La file d'attente est vide!");
		
		//Dequeue
		stackEnd.push(stackArray[0]);
		
		//Move elements
		for(int i=1; i<stackArray.length; i++){
			stackArray[i-1] = stackArray[i];
		}
}
