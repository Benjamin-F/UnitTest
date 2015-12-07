package stackHerit;

public class Stack extends Storage{
	
	/**
	 * Constructor
	 * @param s Stack size
	 */
	public Stack(int s){
		super(s);
	}
	
	/**
	 * Enqueue
	 */
	public void push(int x){
		//If full queue, exception
		if(isFull())
			throw new IllegalStateException("La file d'attente est pleine!");
		
		//Go through stack
		for(int i=0; i<stackArray.length; i++){
			//First null element
			if(stackArray[i] == null){
				//Enqueue
				stackArray[i] = x;
				break;
			}
		}
	}

	/**
	 * Dequeue
	 */
	public void pop(){
		//If empty queue, exception
		if(isEmpty())
			throw new IllegalStateException("La file d'attente est vide!");
		
		//Move elements
		for(int i=1; i<stackArray.length; i++){
			stackArray[i-1] = stackArray[i];
		}
		
		//Last element must be null
		stackArray[stackArray.length-1] = null;
	}
}
