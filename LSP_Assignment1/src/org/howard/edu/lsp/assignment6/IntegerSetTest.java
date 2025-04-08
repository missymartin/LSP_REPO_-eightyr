package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class IntegerSetTest {
	private IntegerSet set1;
	private IntegerSet set2;
	private IntegerSet set3;

	@BeforeEach
	void setUp(TestInfo testInfo) {
			ArrayList<Integer> preset1 = new ArrayList<Integer>();
			preset1.add(1);
			preset1.add(2);
			preset1.add(3);
			
			ArrayList<Integer> preset2 = new ArrayList<Integer>();
			preset2.add(3);
			preset2.add(4);
			preset2.add(5);
			
			set1 = new IntegerSet(preset1);
			set2 = new IntegerSet(preset2);
			set3 = new IntegerSet();
	}


	@Test
	@DisplayName("Test for To String Method.")
	public void testToString() {
		assertEquals(set1.toString(),"[1, 2, 3]");
		assertEquals(set3.toString(),"[]");
	}
	
	@Test
	@DisplayName("Test for Clear Method.")
	public void testClear() {
		set1.clear();
		assertTrue(set1.toString() == "[]");
		set3.clear();
		assertTrue(set3.toString() == "[]");
	}
	

	@Test
	@DisplayName("Test for Length Method.")
	public void testLength() {
		assertEquals(set1.length(), 3);
		assertEquals(set3.length(), 0);
	}
	
	@Test
	@DisplayName("Test for Add Method.")
	public void testAdd() {
		set3.add(2);
		assertEquals(set3.toString(),"[2]" );
		set1.add(2);
		assertEquals(set1.toString(), "[1, 2, 3]");
		set2.add(2);
		assertEquals(set2.toString(), "[3, 4, 5, 2]");
	}
	
	@Test
	@DisplayName("Test for Remove Method.")
	public void testRemove() {
		set1.remove(2);
		assertEquals(set1.toString(),"[1, 3]" );
		set2.remove(2);
		assertEquals(set2.toString(),"[3, 4, 5]" );
		set3.remove(2);
		assertEquals(set3.toString(), "[]");
	}
	
	@Test
	@DisplayName("Test for Empty Method.")
	public void testIsEmpty() {
		assertTrue(set3.isEmpty());
		assertFalse(set1.isEmpty());
	}
	
	
	 //This first replicates set 1 then tests, clears and mix up the order of numbers, then checks a non-example
	@Test
	@DisplayName("Test for Equals Method.")
	public void testEquals() {
		set3.add(1);
		set3.add(2);
		set3.add(3);
		assertTrue(set1.equals(set3));
		set3.clear();
		set3.add(3);
		set3.add(1);
		set3.add(2);
		assertTrue(set1.equals(set3));
		assertFalse(set1.equals(set2));
	}
	
	@Test
	@DisplayName("Test for Contains Method.")
	public void testContains() {
		assertTrue(set1.contains(2));
		assertFalse(set2.contains(2));
		assertFalse(set3.contains(2));
	}
	
	@Test
	@DisplayName("Test for Intersection Method.")
	public void testIntersect() {
		set1.intersect(set2);
		assertEquals(set1.toString(),"[3]");
		set2.intersect(set3);
		assertEquals(set2.toString(),"[]");
	}
	
	@Test
	@DisplayName("Test for Union Method.")
	public void testUnion() {
		set1.union(set3);
		assertEquals(set1.toString(),"[1, 2, 3]");
		set1.union(set2);
		assertEquals(set1.toString(),"[1, 2, 3, 4, 5]");
		set2.clear();
		set2.union(set3);
		assertEquals(set2.toString(),"[]");
	}
	
	@Test
	@DisplayName("Test for Complement Method.")
	public void testComplement() {
		set1.complement(set2);
		assertEquals(set1.toString(),"[4, 5]");
		set1.complement(set3);
		assertEquals(set1.toString(),"[]");
	}
	
	@Test
	@DisplayName("Test for Difference Method.")
	public void testDiff() {
		set1.diff(set3);
		assertEquals(set1.toString(),"[1, 2, 3]");
		set1.diff(set2);
		assertEquals(set1.toString(),"[1, 2]");
	}
	
	 //Tests all 3 sets 
	 //@throws IntegerSetException throws this exception for set3, an empty set
	
	@Test
	@DisplayName("Test for Largest Method.") 
	public void testLargest() throws IntegerSetException {
		assertEquals(set1.largest(), 3);
		assertEquals(set2.largest(), 5);
		Throwable exception = assertThrows(IntegerSetException.class, ()->set3.largest());
		assertEquals("Set is Empty Set. Cannot define largest element.", exception.getMessage());
		set3.add(-3);
		assertEquals(set3.largest(), -3);
		
	}
	
	
	 //Tests all 3 sets
	 // @throws IntegerSetException throws this exception for set3, an empty set
	 
	@Test
	@DisplayName("Test for Smallest Method.") 
	public void testSmallest() throws IntegerSetException {
		assertEquals(set1.smallest(), 1);
		assertEquals(set2.smallest(), 3);
		set2.add(-12457);
		assertEquals(set2.smallest(), -12457);
		Throwable exception = assertThrows(IntegerSetException.class, ()->set3.smallest());
		assertEquals("Set is Empty Set. Cannot define smallest element.", exception.getMessage());
	}

}
