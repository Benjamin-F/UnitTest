package stack;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HanoiTowersTest {
	HanoiTowers myTower;
	
	@Before
	public void setUp(){
		myTower = new HanoiTowers(4);
	}
	
	@After
	public void tearDown(){
		myTower = null;
	}
	
	@Test(expected=IllegalStateException.class)
	public void testFailConstructor(){
		myTower = new HanoiTowers(0);
	}
	
	@Test 
	public void testMoveDisk(){
		myTower.moveDisk(myTower.getLeftStack(), myTower.getMiddleStack());
		assertEquals(1, myTower.getMiddleStack().getNumberOfElements());
		assertEquals(3, myTower.getLeftStack().getNumberOfElements());
		assertEquals(1, myTower.getMiddleStack().head());
	}
	
	@Test
	public void testSolve(){
		myTower.solve(4, myTower.getLeftStack(), myTower.getMiddleStack(), myTower.getRightStack());
		assertEquals(0, myTower.getMiddleStack().getNumberOfElements());
		assertEquals(0, myTower.getLeftStack().getNumberOfElements());
		assertEquals(4, myTower.getRightStack().getNumberOfElements());
		assertEquals(1, myTower.getRightStack().head());
	}
}
