package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stack.*;


public class StackTest {
	Stack myStack;
	
	@Before
	public void setUp(){
		myStack = new Stack(5);
	} 
	
	@After
	public void tearDown(){
		myStack = null;
	}
	
	/**
	 * Test the exception throw if bad init
	 */
	@Test(expected=IllegalStateException.class)
	public void testConstructorFail() {
		myStack = new Stack(0);
	}
	
	/**
	 * Test getSize
	 */
	@Test
	public void testSize() {
		assertEquals(5, myStack.getSize());
	}
	
	/**
	 * Test getNumberOfElements
	 */
	@Test
	public void testNbElem(){
		assertEquals(0, myStack.getNumberOfElements());
	}
	
	/**
	 * Test isEmpty
	 */
	@Test
	public void testIsEmpty(){
		assertEquals(true, myStack.isEmpty());
	}
	
	/**
	 * Test push
	 */
	@Test
	public void testPush() {
		myStack.push(3);
		assertEquals(1, myStack.getNumberOfElements());
	}
	
	/**
	 * Test exception throw if push overflow
	 */
	@Test(expected=IllegalStateException.class)
	public void testOverflow(){
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(6);
		myStack.push(6);
	}
	
	/**
	 * Test isFull
	 */
	@Test
	public void testIsFull(){
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(6);
		assertEquals(true, myStack.isFull());
	}
	
	/**
	 * Test exception throw empty pop
	 */
	@Test(expected=IllegalStateException.class)
	public void testNullPop(){
		myStack.pop();
	}
	
	/**
	 * Test pop
	 */
	@Test
	public void testPop(){
		myStack.push(4);
		myStack.pop();
		assertEquals(true, myStack.isEmpty());
	}
	
	/**
	 * Test exception throw if null head
	 */
	@Test(expected=IllegalStateException.class)
	public void testNullHead(){
		myStack.head();
	}
	
	/**
	 * Test head
	 */
	@Test
	public void testHead(){
		myStack.push(3);
		assertEquals(3, myStack.head());
	}
	
	/**
	 * Test LIFO
	 */
	@Test
	public void testLIFO(){
		myStack.push(1);
		myStack.push(2);
		myStack.pop();
		assertEquals(1, (int)myStack.getStackArray()[0]);
		assertEquals(null, myStack.getStackArray()[1]);
	}
}
