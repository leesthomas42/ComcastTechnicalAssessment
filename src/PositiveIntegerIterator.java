import java.util.Iterator;
import java.util.LinkedList;

/*
 * Goal: Given an Iterator of type Integer, provide an Iterator<Integer> implementation 
 *       that only provides non-negative values. Only implement next() and hasNext()
 * 
 * Input: Iterator of type Integer
 * Output: next() should only ever return positive integers, hasNext() should only return
 *         true if there is a positive integer ahead in the underlying Iterator
 * 
 * Notes:
 *      remove() does not need to be implemented
 *      testIter() is a test case that should pass
 */
public class PositiveIntegerIterator implements Iterator<Integer> {
	
	//Used a LinkedList because we are adding N number of elements, then parsing the list one at a time. A LinkedList is better at adding elements compared to the ArrayList, 
	//and it's slower traverse time is not a concern because the methods only look at the next element
	private LinkedList<Integer> list;
	private int pointer;
	
	public PositiveIntegerIterator(Iterator<Integer> i) {
		pointer = 0;
		list = new LinkedList<Integer>();
		while(i.hasNext()) {
			Integer value = i.next();
			//only save in our list positive integers
			if(value != null && value > 0) {
				list.add(value);
			}
		}
	}

	@Override
	public boolean hasNext() {
		//Since there is only positive integers in our list, if the pointer is less than the size of the list then we can return true witout checking
		return pointer < list.size();
	}

	@Override
	public Integer next() { // throws NoSuchElementException
		//Since there is only positive integers in our list, if there is a next element then it can be returned without checking it
		if(hasNext()) {
			Integer value = list.get(pointer);
			pointer++;
			return value;
		}
		throw new NoSuchElementException("No elements left in the iterator");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}