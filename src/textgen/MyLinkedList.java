package textgen;

import java.util.AbstractList;


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
		this.size = 0;
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		this.add(this.size, element);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (this.size == 0) {
			throw new IndexOutOfBoundsException("The linked list is empty!");
		}
		if(index < 0 || index>=this.size) {
			throw new IndexOutOfBoundsException("Index ouf of bound!");
		}
		LLNode<E> dest = this.head;
		for (int i = 0; i <= index; i++) {
			dest = dest.next;
		}
		return dest.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index < 0 || index>this.size) {
			throw new IndexOutOfBoundsException("Index ouf of bound!");
		}
		if(element == null) {
			throw new NullPointerException("Null element is invalid!");
		}
		LLNode<E> dest = this.head;
		LLNode<E> add = new LLNode<E> (element);
		for (int i = 0; i <= index; i++) {
			dest = dest.next;
		}
		add.next = dest;
		add.prev = dest.prev;
		dest.prev = add;
		add.prev.next = add;
		this.size += 1;
		
		
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
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Invalid remove!");
		}
		LLNode<E> dest = this.head;
		for (int i = 0; i <= index; i++) {
			dest = dest.next;	
		}
		dest.next.prev = dest.prev;
		dest.prev.next = dest.next;
		this.size -= 1;
		return dest.data;
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
		if (element == null) {
			throw new NullPointerException("The input is null!");
		}
		if (this.size == 0) {
			throw new IndexOutOfBoundsException("The linked list is empty!");
		}
		if(index < 0 || index>=this.size) {
			throw new IndexOutOfBoundsException("Index ouf of bound!");
		}
		LLNode<E> dest = this.head;
		for (int i = 0; i <= index; i++) {
			dest = dest.next;
		}
		E replaced = dest.data;
		dest.data = element;
		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
