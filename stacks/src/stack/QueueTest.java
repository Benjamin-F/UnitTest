package stack;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	 * Test getNumberOfElements
	 */
	@Test
	public void testNbElem(){
		assertEquals(0, myQueue.getNumberOfElements());
	}
	
	/**
	 * Test isEmpty
	 */
	@Test
	public void testIsEmpty(){
		assertEquals(true, myQueue.isEmpty());
	}
	
	/**
	 * Test isFull
	 */
	@Test
	public void testIsFull(){
		assertEquals(false, myQueue.isFull());
	}
	
	/**
	 * Test enqueue
	 */
	@Test
	public void testEnqueue(){
		myQueue.getStackBegin().push(5);
		myQueue.enqueue();
		assertEquals(true, myQueue.getStackBegin().isEmpty());
		assertEquals(1, myQueue.getNumberOfElements());
		assertEquals(0, myQueue.getStackBegin().getNumberOfElements());
		assertEquals(5, (int)myQueue.getQueueArray()[0]);
	}
	
	/**
	 * Test empty begin enqueue
	 */
	@Test(expected=IllegalStateException.class)
	public void testEmptyBeginEnqueue(){
		myQueue.enqueue();
	}
	
	/**
	 * Test full queue enqueue
	 */
	@Test(expected=IllegalStateException.class)
	public void testFullQueueEnqueue(){
		myQueue.getStackBegin().push(5);
		myQueue.getStackBegin().push(5);
		myQueue.getStackBegin().push(5);
		myQueue.getStackBegin().push(5);
		myQueue.getStackBegin().push(5);
		myQueue.enqueue();
		myQueue.enqueue();
		myQueue.enqueue();
		myQueue.enqueue();
		myQueue.enqueue();
		myQueue.getStackBegin().push(5);
		myQueue.enqueue();
	}
	
	/**
	 * Test dequeue
	 */
	@Test
	public void testDequeue(){
		myQueue.getStackBegin().push(5);
		myQueue.enqueue();
		myQueue.dequeue();
		assertEquals(true, myQueue.isEmpty());
		assertEquals(5, myQueue.getStackEnd().head());
	}
	
	/**
	 * Test empty dequeue
	 */
	@Test(expected=IllegalStateException.class)
	public void testEmptyDequeue(){
		myQueue.dequeue();
	}
	
	/**
	 * Test full end stack dequeue
	 */
	@Test(expected=IllegalStateException.class)
	public void testFullEndDequeue(){
		myQueue.getStackEnd().push(1);
		myQueue.getStackEnd().push(1);
		myQueue.getStackEnd().push(1);
		myQueue.getStackEnd().push(1);
		myQueue.getStackEnd().push(1);
		myQueue.dequeue();
	}
	

}
