package org.howard.edu.lsp.assignment5;
import java.util.List;
import java.util.ArrayList ;

/**
 * Creation of the Integer Set class
 */
public class IntegerSet {
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

	/**
	 *  Default Constructor
	 */
	public IntegerSet() {
	}

	/**
	 * Constructor if you want to pass in already initialized
	 * @param set, this is a set intialized outside of the class
	 */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}
/** This empties the set. there is no output as it should be a clear array. clear is already a built in function so it is utilized here
 * 
 */
	// Clears the internal representation of the set. 5 pts.
	public void clear() 
	{
		set.clear();
	};

	/**
	 * This also utlizes the built in Array method to return the number of elements in the set. 
	 * @return this is an integer equal to the length of the set. 
	 */
	// Returns the length of the set. 5 pts.
	public int length() {
		return set.size();
		}; // returns the length


/**
 * This override'd the objects method of equals. It checks if the set is already the same of o.
 * if not, it checks that o isn't null and that it is the correct class type.
 * It sets the parameter passed in, into a list then runs ArrayList method contains all and returns a true or false
 */
	public @Override boolean equals(Object o) {
		if (set == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		IntegerSet obj = (IntegerSet) o; 
		return set.containsAll(obj.set);
	};
	
/**
 * This uses the array list contains method. if the int passed in is in the set it return true, otherwise, false.
 * @param value, the is an integer passed in to be compared to the set
 * @return boolean, it returns a true or false
 */
	// Returns true if the set contains the value, otherwise false. 5 pts.
	public boolean contains(int value) {
		return set.contains(value);
	};
	
	/** The largest method iterates through the set replacing the largest variable if the element at i is larger
	 * 
	 * @return the largest element is returned.
	 */
	// Returns the largest item in the set. 5 pts.
	public int largest()  {
		int largest = 0;
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i)> largest) {
				largest = set.get(i);}}
		return largest;
	};  

/**
 * This method creates a local variable, smallest, and iterates through the set replacing the variable if there is a smaller element.
 * @return smallest, the smallest element is returned
 */
	// Returns the smallest item in the set. 5 pts.
	public int smallest()  {
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < set.size(); i++) {
		if (set.get(i)<smallest) {
			smallest = set.get(i);}}
		return smallest;};

	
		// Adds an item to the set or does nothing it already there. 5 pts.
	/**
	 * Since the array operations allows duplicates, there is an if statement, checking that the item is not a duplicate
	 * @param item, item is already passed in as an integer, so it eligible to be added into the list.
	 */
 	public void add(int item) {
 		if (set.contains(item) == false) {
 			set.add(item);
 		}
 	}; // adds item to the set or does nothing if it is in set
 	
 	/**
 	 * This uses the .indexOf method to find the index of passed in item then remove the item at that index.
 	 * @param item, item is the element wanted to remove
 	 */

	// Removes an item from the set or does nothing if not there. 5 pts.
 	public void remove(int item) {
 		set.remove(set.indexOf(item));
 	}; 

 	/**
 	 * This checks if the elements are in the set already, if not it adds the element into the set. 
 	 * @param intSetb, this is an instance of the IntgerSet that is to be combined with set
 	 */
 	// Set union. 11 pts.
 	public void union(IntegerSet intSetb) {
 		for (int i = 0; i < intSetb.length(); i++) {
 			if (set.contains(intSetb.set.get(i)) == false) {
 				set.add(intSetb.set.get(i));
 			}}
 	};
	
/**
 * This method takes action if there is an element in set that is not in the intersecting set. This is because this instance set is what shows the intersection.
 * @param intSetb, intSetb is an instance of IntegerSet we have to refer to its .set variable
 */
 	// Set intersection, all elements in s1 and s2. 12 pts.
 	public void intersect(IntegerSet intSetb) {
 		ArrayList<Integer> intersectList = new ArrayList<Integer>();
 		for (int i = 0; i < intSetb.length(); i++) {
 			if (set.contains(intSetb.set.get(i)) == true) {
 				intersectList.add(intSetb.set.get(i));
 			}
 		}
 		set = intersectList;
 		
 	}; 

/**
 * This method is similar to the intersection method. if the element is found in both sets, it is removed to create the set of differences.
 * @param intSetb an Instance of IntergerSet (this class)
 */
 	// Set difference, i.e., s1 –s2. 12 pts.
 	public void diff(IntegerSet intSetb) {
 		for (int i = 0; i < intSetb.length(); i++) {
 			if (set.contains(intSetb.set.get(i)) == true) {
 				set.remove(intSetb.set.get(i));
 			}
 		}
 	}; // set difference, i.e. s1 - s2

 	/**
 	 * This method changes the IntSetb's .set. Once it iterates through removing the similar items, the intSetb set is switches to display the complement
 	 * It only increases the index if there isn't a removal up to the set's length
 	 * @param intSetb, this is a new instance of IntegerSet, so it has access to all methods defined in this class
 	 */
 	// Set complement, all elements not in s1. 11 pts.
 	public void complement(IntegerSet intSetb) {
 		for (int i = 0; i < set.size();i++) {
 			System.out.println("");
 			if (intSetb.set.contains(set.get(i)) == true) {
 				intSetb.remove(set.get(i));
 				}
 			}
 		set = intSetb.set;
 		};

 	// Returns true if the set is empty, false otherwise. 5 pts.
/**
 * This simply uses the array's isempty method.
 * @return it returns the boolean true or false the array list method provides.
 */
 	boolean isEmpty() {
 		return set.isEmpty();
 	}; 

 	// Return String representation of your set.  This overrides the equal method from 
 	// the Object class. 5 pts.

/**
 * This uses the arrayList .toString that overrides the objects toString.
 * @return it returns the string "[...]" with all the arrays elements
 */
 	public String toString() {
 		return set.toString();
 			};	// return String representation of your set
	
}
