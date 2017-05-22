package textgen;

import java.util.AbstractList;

import textgen.LLNode;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		
		size = 0;
		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Invalid element input!");
		}
				
		LLNode<E> addN = new LLNode<E>(element);
		LLNode<E> prevN = tail.prev;
		prevN.next = addN;
		addN.prev = prevN;
		addN.next = tail;
		tail.prev = addN;
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bound!");
		}
		LLNode<E> getN = head;
		for (int i = 0; i <= index; i++) {
			getN = getN.next;
		}
		E value = getN.data;
		return value;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if (element == null) {
			throw new NullPointerException("Invalid element input: null!");
		}
		
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Index out of bound!");
		}
		
		LLNode<E> currN = head;

		for (int i = 0; i <= index; i++) {
			
			currN = currN.next;
		}
		
		LLNode<E> newN = new LLNode<E>(element);
		newN.next = currN;
		newN.prev = newN.next.prev;
		newN.next.prev = newN;
		newN.prev.next = newN;
		size++;
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bound!");
		}
		
		LLNode<E> currN = head;

		for (int i = 0; i <= index; i++) {
			
			currN = currN.next;
		}
		E akosRemoved = currN.data;
		
		currN.prev.next = currN.next;
		currN.next.prev = currN.prev;
		currN.next = null;
		currN.prev = null;
		currN.data = null;
		currN = null;
		
		size--;
		
		return akosRemoved;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bound!");
		}
		
		if (element == null) {
			throw new NullPointerException("Invalid element input!!");
		}
		
		LLNode<E> currN = head;

		for (int i = 0; i <= index; i++) {
			
			currN = currN.next;
		}
		E akosSet = currN.data;
		currN.data = element;
		
		return akosSet;
	}

	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;
	
	
	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
		
	}
	
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	
	
}
