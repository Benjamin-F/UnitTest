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
		for(; i<q.getStackBegin().getSize(); i++){
			tmp = (q.getStackBegin().getStackArray()[i] == null)? "-": q.getStackBegin().getStackArray()[i].toString();
			
			System.out.print(tmp + "|");
		}
		System.out.println("");
		
		i=0;
		for(; i<q.getStackEnd().getSize(); i++){
			tmp = (q.getStackEnd().getStackArray()[i] == null)? "-": q.getStackEnd().getStackArray()[i].toString();
			
			System.out.print(tmp + '|');
		}
		
	}

}
