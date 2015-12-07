package stackHerit;

import stackOrig.Stack;

public class Queue{
	private Stack stackBegin = null;
	private Stack stackEnd = null;
	
	/**
	 * Constructor
	 * @param s Stack size
	 */
	public Queue(int s){
		stackBegin = new Stack(s);
		stackEnd = new Stack(s);
	}
	
	/**
	 * Enqueue
	 */
	public void push(int x){
		//If empty stack, exception
		if(stackBegin.isFull())
			throw new IllegalStateException("La pile de début est pleine!");
		
		stackBegin.push(x);
	}

	/**
	 * Dequeue
	 */
	public void pop(){
		for(int i = 0; i<stackBegin.getNumberOfElements()-1; i++){
			stackEnd.push(stackBegin.head());
		}
		
		stackEnd.pop();
	}
}
