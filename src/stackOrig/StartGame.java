package stackOrig;

import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {
		HanoiTowers towers = null;
		
		System.out.print("Enter number of discs: ");
		Scanner scan = new Scanner(System.in);
		int discs = scan.nextInt();
		
		towers = new HanoiTowers(discs);
		towers.printStacks();
		
		towers.solve(discs, towers.getLeftStack(), towers.getMiddleStack(), towers.getRightStack());
	}
}
