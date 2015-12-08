package stack;

public class test {

	public static void main(String[] args) {
		Queue q = new Queue(6);
		q.push(1);
		q.push(2);
		q.push(3);
		q.pop();
		q.push(4);
		q.pop();
		
		int i=0;
		String tmp = null;
		for(; i<q.getStack().getSize(); i++){
			tmp = (q.getStack().getStackArray()[i] == null)? "-": q.getStack().getStackArray()[i].toString();
			
			System.out.print(tmp + "|");
		}
		System.out.println("");
		
		i=0;
		for(; i<q.getStackTmp().getSize(); i++){
			tmp = (q.getStackTmp().getStackArray()[i] == null)? "-": q.getStackTmp().getStackArray()[i].toString();
			
			System.out.print(tmp + '|');
		}
		
	}

}
