package stack;

public class Queue{
	private Stack stack = null;
	private Stack stackTmp = null;

	/**
	 * Constructor
	 * @param s Stack size
	 */
	public Queue(int s){
		stack = new Stack(s);
		stackTmp = new Stack(s);
	}
	
	/**
	 * Enqueue
	 */
	public void push(int x){
		//If empty stack, exception
		if(stack.isFull())
			throw new IllegalStateException("La pile de début est pleine!");
		
		stack.push(x);
	}

	/**
	 * Dequeue
	 */
	public void pop(){
		//Push stack into tmp
		while(!stack.isEmpty()){
			stackTmp.push(stack.head());
			stack.pop();
		}
		
		//Pop the element
		stackTmp.pop();
		
		//Push tmp into stack
		while(!stackTmp.isEmpty()){
			stack.push(stackTmp.head());
			stackTmp.pop();
		}
		
	}
	
	/**
	 * Return the head int of the queue
	 * @return int
	 * @throws IllegalStateExceptio
	 */
	public int head(){
		return stack.head();
	}
	
	/**
	 * Return the number of elements in the queue
	 * @return number of elements
	 */
	public int getNumberOfElements(){
		return stack.getNumberOfElements();
	}
	
	/**
	 * Check is the queue is empty
	 * @return boolean
	 */
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	/**
	 * Check is the queue is full
	 * @return boolean
	 */
	public boolean isFull(){
		return stack.isFull();
	}
	
	public Integer[] getStackArray() {
		return stack.getStackArray();
	}

	public Stack getStackTmp() {
		return stackTmp;
	}
}
