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
	
	/* Getters */
	public Stack getStack() {
		return stack;
	}

	public Stack getStackTmp() {
		return stackTmp;
	}
}
