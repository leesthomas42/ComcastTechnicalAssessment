import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveIntegerIteratorTest {

	@Test
	public void testIter() {
	    Iterator<Integer> intIter = Arrays.asList(new Integer[] {null, -1, 2, null, 15, -4, 50, null}).iterator();
	    Iterator<Integer> iter = new PositiveIntegerIterator(intIter);
	    //multiple hasNext() calls succeed
	    for (int i = 0; i < 100; i++) {
	        assert iter.hasNext();
	    }
	    //values are correct
	    assert iter.hasNext();
	    assert iter.next() == 2;
	    //no hasNext() call...
	    assert iter.next() == 15;
	    assert iter.hasNext();
	    assert iter.next() == 50;
	    assert iter.hasNext() == false;
	}	
	
	//extra test cases because why not
	@Test
	public void testNextNoSuchElementException() {
		Iterator<Integer> emptyIterator = Arrays.asList(-1).iterator();
		Iterator<Integer> positiveIterator = new PositiveIntegerIterator(emptyIterator);
		Assertions.assertThrows(NoSuchElementException.class, () -> positiveIterator.next());
	}
	
	@Test
	public void testNext() {
		Iterator<Integer> emptyIterator = Arrays.asList(1).iterator();
		Iterator<Integer> positiveIterator = new PositiveIntegerIterator(emptyIterator);
		assert positiveIterator.next() == 1;
	}
	
	@Test
	public void testHasNextTrue() {
		Iterator<Integer> emptyIterator = Arrays.asList(1).iterator();
		Iterator<Integer> positiveIterator = new PositiveIntegerIterator(emptyIterator);
		assert positiveIterator.hasNext();
	}
	
	@Test
	public void testHasNextFalse() {
		Iterator<Integer> emptyIterator = Arrays.asList(-1).iterator();
		Iterator<Integer> positiveIterator = new PositiveIntegerIterator(emptyIterator);
		assert !positiveIterator.hasNext();
	}
	
	@Test
	public void testRemove() {
		Iterator<Integer> emptyIterator = Arrays.asList(1).iterator();
		Iterator<Integer> positiveIterator = new PositiveIntegerIterator(emptyIterator);
		Assertions.assertThrows(UnsupportedOperationException.class, () -> positiveIterator.remove());
	}

}