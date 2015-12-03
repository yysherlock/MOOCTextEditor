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
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null,head,null);
		head.next = tail;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> node = new LLNode<E>(element, tail.prev, tail);
		tail.prev.next = node;
		tail.prev = node;
		size ++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if ( index < size && index >= 0){
			LLNode<E> pointer = head;
			for (int i=0; i <= index; i++){
				pointer = pointer.next;
			}
			return pointer.data;
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index <= size && index >= 0 ){ // reasonable
			if (element == null) throw new NullPointerException();
			
			LLNode<E> pointer = head; 
			for ( int i=0; i<=index; i++){
				pointer = pointer.next;
			}
			// pointer is pointing to the indexed node
			LLNode<E> node = new LLNode<E>(element, pointer.prev, pointer);
			node.prev.next = node;
			node.next.prev = node;
			size ++;
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
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
		if (index < size && index >= 0 ){ // reasonable
			LLNode<E> pointer = head; 
			for ( int i=0; i<=index; i++){
				pointer = pointer.next;
			}
			// pointer is pointing to the indexed node
			pointer.prev.next = pointer.next;
			pointer.next.prev = pointer.prev;
			pointer.next = null;
			pointer.prev = null;
			size --;
			
			return pointer.data;
			
		} else {
			throw new IndexOutOfBoundsException();
		}
		
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
		
		if (index < size && index >= 0 ){ // reasonable
			if (element == null) throw new NullPointerException();
			else {
				LLNode<E> pointer = head; 
				for ( int i=0; i<=index; i++){
					pointer = pointer.next;
				}
				E olddata = pointer.data;
				pointer.data = element;
				return olddata;
			}
			
		}  else {
			throw new IndexOutOfBoundsException();
		}
		
	}  
	
	public String toString(){
		String str = "";
		LLNode<E> pointer = head;
		for ( int i=0; i < size; i++){
			pointer = pointer.next;
			str += pointer.data.toString();
			if( i!=size-1) str += ", ";
		}
		return str;
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
		//this.data = e;
		//this.prev = null;
		//this.next = null;
		this(e, null, null);
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next)
	{
		this.data = e;
		this.prev = prev;
		this.next = next;
	}

}
