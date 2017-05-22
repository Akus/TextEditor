/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import textgen.MyLinkedList;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	MyLinkedList<Integer> akosEmptyList;
	MyLinkedList<String> akosList2;

	MyLinkedList<Integer> akosShortList;
	MyLinkedList<Integer> akosShortList2;

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		akosEmptyList = new MyLinkedList<Integer>();
		akosList2 = new MyLinkedList<String>();
		akosList2.add("Albert Zsuzsanna");
		akosList2.add("Erl Gyorgyi");
		//akosList2.add("Bodor Akos");
		
		akosList2.add("Bodor Eliza Natalia");
		
		
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
		akosShortList = new MyLinkedList<Integer>();
		akosShortList.add(1);
		akosShortList.add(2);
		akosShortList.add(3);
		
		akosShortList2 = new MyLinkedList<Integer>();
		akosShortList2.add(4);
		akosShortList2.add(5);
		akosShortList2.add(6);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		// test akosList2
				assertEquals("Check first", "Albert Zsuzsanna", akosList2.get(0));
				assertEquals("Check second", "Erl Gyorgyi", akosList2.get(1));
				
				////System.out.println("The 3th element of akosList2 is " + akosList2.get(2));

				
				
				try {
					akosList2.get(-1);
					fail("Check out of bounds");
				}
				catch (IndexOutOfBoundsException e) {
				
				}
				try {
					akosList2.get(4);
					fail("Check out of bounds");
				}
				catch (IndexOutOfBoundsException e) {
				
				}
				
				
				//System.out.println("\nTEST: Get: \nElements of akosList2 are: " + akosList2 + " The size of akosList2 is " + akosList2.size() + "\nThe second element is: " + akosList2.get(1) + "\n");

		
				
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		//System.out.println("TEST: Remove:\nThe original elements of akosShortList are " + akosShortList  + " The current size of the list is: " + akosShortList.size());

		int akosRemoved = akosShortList.remove(1);
		assertEquals("Remove: check a is correct ", 2, akosRemoved);
		assertEquals("Remove: check element 1 is correct ", (Integer)3, akosShortList.get(1));
		assertEquals("Remove: check size is correct ", 2, akosShortList.size());
		//System.out.println("The current elements of akosShortList are " + akosShortList + " The removed element is: " + akosRemoved + " The current size of the list is: " + akosShortList.size() + "\n");
		
		
		try {
			akosShortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			akosShortList.remove(4);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
	}
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		//System.out.println("\nTEST: AddEnd: \nakosShortlist2 before addEnd: " + akosShortList2 + " and its original size is: " + akosShortList2.size());
		
		akosShortList2.add(7);
		assertEquals("AddEnd: check last element is correct ", (Integer)7, akosShortList2.get(3));
		assertEquals("AddEnd: check size is correct ", 4, akosShortList2.size());
		//System.out.println("The akosShortList2 is: " + akosShortList2 + " The current size of the list is: " + akosShortList2.size() + "\n");
	
		try {
			akosShortList.add(null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e) {
	}
	
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size is correct ", 3, list1.size());
		assertEquals("Size: check size is correct ", 3, akosShortList2.size());
		
		//System.out.println("\nTEST: Size:\nThe size of akosShortList2 is " + akosShortList2.size() + " akosShortList2 : " + akosShortList2 + "\n");
	
	
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		// adding at index
		String original2 = akosList2.get(2);
		//System.out.println("TEST: AddAtIndex: \nakosList2: " + akosList2 + " Original element at index 2 is: " + original2);
		akosList2.add(2, "Bodor Akos");
		assertEquals("Size: check size is correct ", 4, akosList2.size());
		assertEquals("AddAt: check element at 2 ", "Bodor Akos", akosList2.get(2));
		assertEquals("AddAt: check element at 3 ", "Bodor Eliza Natalia", akosList2.get(3));
		//System.out.println("akosList2: " + akosList2 + " New element at index 2 is: " + akosList2.get(2));
		
		//System.out.println("\nakosShortList2 before add: " + akosShortList2);
		akosShortList2.add(0, 1);
		//System.out.println("\nakosShortList2 after add: " + akosShortList2);
		assertEquals("Size: check size is correct ", 4, akosShortList2.size());
		assertEquals("AddAt: check element at 0 ", (Integer)1, akosShortList2.get(0));

		


		
		try {
			akosShortList.add(-1, 101);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			akosShortList.add(111, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
	}
		
		try {
			akosShortList.add(1, null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e) {
	}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		
		//System.out.println("TEST: Set:\nakosShortlist2 before set: " + akosShortList2 );
		int oldValue1 = akosShortList2.get(2);
		int newValue = 99;
		int oldValue2 = akosShortList2.set(2, newValue);
		
		//System.out.println("oldvalue at index 2 with get() was: " + oldValue1 + " oldvalue at index 2 with set() is: " + oldValue2);
		assertEquals("Size: check size is correct ", 3, akosShortList2.size());
		assertEquals("Set: check element at 2 ", (Integer)99, akosShortList2.get(2));
		assertEquals("Set: check old value at 2 ", 6, oldValue2);
		
		//System.out.println("akosShortlist2 after set: " + akosShortList2);

		try {
			akosShortList.set(-1,10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			akosShortList.set(10,10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			akosShortList.set(2, null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e) {
	}
		
		
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
