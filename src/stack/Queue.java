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
		/*
		if(stackEnd.isEmpty()){
			while(!stackBegin.isEmpty()){
				stackEnd.push(stackBegin.head());
				stackBegin.pop();
			}
			
			stackEnd.pop();
		}else{
			
			//Store end into tmp
			while(!stackEnd.isEmpty()){
				tmp.push(stackEnd.head());
				stackEnd.pop();
			}
			
			//Push Begin into end
			while(!stackBegin.isEmpty()){
				stackEnd.push(stackBegin.head());
				stackBegin.pop();
			}
			
			//Push tmp on top of the end stack
			while(!tmp.isEmpty()){
				stackEnd.push(tmp.head());
				tmp.pop();
			}			
			
			stackEnd.pop();
		}
		*/
		
		//Push Begin into end
		while(!stack.isEmpty()){
			stackTmp.push(stack.head());
			stack.pop();
		}
		
		stackTmp.pop();
		
		//Push End into begin
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
