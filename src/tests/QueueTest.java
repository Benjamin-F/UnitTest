package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stack.*;

public class QueueTest {
	Queue myQueue;
	
	@Before
	public void setUp(){
		myQueue = new Queue(5);
	}
	
	@After
	public void tearDown(){
		myQueue = null;
	}
	
	/**
	 * Test the exception throw if bad init
	 */
	@Test(expected=IllegalStateException.class)
	public void testConstructorFail() {
		myQueue = new Queue(0);
	}
	
	/**
	 * Test enqueue
	 */
	@Test
	public void testPush(){
		myQueue.push(5);
		assertEquals(false, myQueue.isEmpty());
		assertEquals(1, myQueue.getNumberOfElements());
		assertEquals(5, myQueue.head());
	}
	
	
	/**
	 * Test full queue enqueue
	 */
	@Test(expected=IllegalStateException.class)
	public void testFullQueuePush(){
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);
		myQueue.push(6);
	}
	
	/**
	 * Test full
	 */
	@Test
	public void testIsFull(){
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);
		assertEquals(true, myQueue.isFull());
	}
	
	/**
	 * Test getStackTmp
	 */
	@Test
	public void testGetStackTmp(){
		assertEquals(true, myQueue.getStackTmp().isEmpty());
	}
	
	/**
	 * Test dequeue
	 */
	@Test
	public void testPop(){
		myQueue.push(5);
		myQueue.push(3);
		myQueue.pop();
		myQueue.pop();
		
		assertEquals(true, myQueue.isEmpty());
		assertEquals(true, myQueue.getStackTmp().isEmpty());
	}
	
	/**
	 * Test FIFO
	 */
	@Test
	public void testFIFO(){
		myQueue.push(1);
		myQueue.push(2);
		myQueue.pop();
		
		assertEquals(2, (int)myQueue.getStackArray()[0]);
		assertEquals(1, (int)myQueue.getNumberOfElements());
		assertEquals(true, myQueue.getStackTmp().isEmpty());
	}
}
