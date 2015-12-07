package stackHerit;

public class Fifo extends Stack{
	
	/**
	 * Constructor
	 * @param s Stack size
	 */
	public Fifo(int s){
		super(s);
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
}
