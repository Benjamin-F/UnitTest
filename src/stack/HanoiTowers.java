package stack;

public class HanoiTowers {
	private Stack leftStack = null;
	private Stack middleStack = null;
	private Stack rightStack = null;
	private int numberOfDiscs = 0;

	/**
	 * Constructor
	 * @param discs Number of discs
	 */
	public HanoiTowers(int discs){
		//Init stack
		leftStack = new Stack(discs);
		middleStack = new Stack(discs);
		rightStack = new Stack(discs);
		numberOfDiscs = discs;
		
		//Fill left stack
		for(int i = numberOfDiscs; i>0; i--){
			leftStack.push((i*2)-1);
		}
	}
   
	/**
	 * Solve
	 * @param topN
	 * @param from
	 * @param inter
	 * @param to
	 */
	public void solve(int number, Stack from, Stack via, Stack to) {
		if (number > 0){
			solve(number - 1, from, to, via);
			moveDisk(from,to);
			solve(number - 1, via, from, to);
		}
	}
	
	/**
	 * Move disk
	 * @param from stack
	 * @param to stack
	 */
	public void moveDisk(Stack from, Stack to){
		to.push(from.head());
		from.pop();
		printStacks();
	}
	
	/**
	 * Display stacks
	 */
	public void printStacks(){
		//For all the stacks, begining at the top
		for(int i=numberOfDiscs-1; i>=0; i--){
			//Left stack
			if(leftStack.getStackArray()[i] != null){
				System.out.print( new String(new char[numberOfDiscs-((leftStack.getStackArray()[i]-1)/2)]).replace("\0", " ") );
				System.out.print(new String(new char[leftStack.getStackArray()[i]]).replace("\0", "*"));
				System.out.print( new String(new char[numberOfDiscs-((leftStack.getStackArray()[i]-1)/2)]).replace("\0", " ") );
			}
			else{
				System.out.print( new String(new char[numberOfDiscs*2+1]).replace("\0", " ") );
			}
			
			System.out.print("||");
			
			//Middle stack
			if(middleStack.getStackArray()[i] != null){
				System.out.print( new String(new char[numberOfDiscs-((middleStack.getStackArray()[i]-1)/2)]).replace("\0", " ") );
				System.out.print(new String(new char[middleStack.getStackArray()[i]]).replace("\0", "*"));
				System.out.print( new String(new char[numberOfDiscs-((middleStack.getStackArray()[i]-1)/2)]).replace("\0", " ") );
			}
			else{
				System.out.print( new String(new char[numberOfDiscs*2+1]).replace("\0", " ") );
			}
			
			System.out.print("||");
			
			//Right stack
			if(rightStack.getStackArray()[i] != null){
				System.out.print( new String(new char[numberOfDiscs-((rightStack.getStackArray()[i]-1)/2)]).replace("\0", " ") );
				System.out.print(new String(new char[rightStack.getStackArray()[i]]).replace("\0", "*"));
				System.out.print( new String(new char[numberOfDiscs-((rightStack.getStackArray()[i]-1)/2)]).replace("\0", " ") );
			}
			else{
				System.out.print( new String(new char[numberOfDiscs*2+1]).replace("\0", " ") );
			}
			
			System.out.print("||");
			System.out.println();
		}
		System.out.println( new String(new char[((numberOfDiscs*2)+3)*3]).replace("\0", "-"));
		
	}
	
	/*Getters*/
	public Stack getLeftStack() {
		return leftStack;
	}

	public Stack getMiddleStack() {
		return middleStack;
	}

	public Stack getRightStack() {
		return rightStack;
	}
}
