package stack;

public class Queue{
	private Stack stackBegin = null;
	private Stack stackEnd = null;
	private Stack tmp = null;

	/**
	 * Constructor
	 * @param s Stack size
	 */
	public Queue(int s){
		stackBegin = new Stack(s);
		stackEnd = new Stack(s);
		tmp = new Stack(s);
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
	}
	
	/* Getters */
	public Stack getStackBegin() {
		return stackBegin;
	}

	public Stack getStackEnd() {
		return stackEnd;
	}
}
