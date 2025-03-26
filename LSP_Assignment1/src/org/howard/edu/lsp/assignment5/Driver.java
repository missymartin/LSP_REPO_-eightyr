package org.howard.edu.lsp.assignment5;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// Intilizes first set and adds elements
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
//Tests the toString, length, smallest, and largest methods.
		System.out.println("Value of Set1 is: "+ set1.toString());
		System.out.println("Length of Set1 is " + set1.length());
		System.out.println("Smallest value in Set1 is: " + set1.smallest());
		System.out.println("Largest value in Set1 is: " + set1.largest());
		System.out.println();
//intializes second set
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		set2.add(5);
//Tests the contains method
		System.out.println("Value of Set2 is: "+ set2.toString());
		System.out.println("The statement 'Set2 contains 19' is "+ set1.contains(19));
		System.out.println();

// Tests the union method
		System.out.println("Union of Set1 and Set2 Test");
		System.out.println("Value of Set1 is: " + set1.toString());
		//Set1: [1,2,3]
		System.out.println("Value of Set2 is: " + set2.toString());
		//Set2: [3,4,5]
		set1.union(set2);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2: " + set1.toString());
		// result of union of set1 and set2
		//: [1,2,3,4,5]
		System.out.println();
		
//tests the difference method
		System.out.println("Difference of Set1 and Set2 Test");
		System.out.println("Current Value of Set1 is : " + set1.toString());
		//Set1: [1,2,3,4,5]
		System.out.println("Value of Set2 is: " + set2.toString());
		//Set2: [3,4,5]
		set1.diff(set2);	// union of set1 and set2
		System.out.println("Result of difference of Set1 and Set2: "+ set1.toString());
		//[1,2]
		System.out.println();
		
//Tests Removes method
		set1.remove(1);
		System.out.println("This removes 1 from Set1. See: "+ set1.toString());
		System.out.println();
		
//intializes third set
		IntegerSet set3 = new IntegerSet();
		set3.add(4);
		set3.add(5);
		set3.add(6); 

//test intersection method
		System.out.println("Intersection of Set2 and Set3 Test");
		System.out.println("Current Value of Set2 is: " + set2.toString());
		//Set1: [3,4,5]
		System.out.println("Value of Set3 is: " + set3.toString());
		//Set2: [4,5,6]
		set2.intersect(set3);	// union of set1 and set2
		System.out.println("Result of intersection of Set1 and Set2"+set2.toString());
		//[4,5]
		System.out.println();
		
//tests equals
		System.out.println("Equals method Test");
		System.out.println("The statement 'Set3 equals Set 2' is "+ set2.equals(set3));
		System.out.println();
		
//tests complement method
		System.out.println("Complement of Set2 and Set3 Test");
		System.out.println("Current Value of Set2 is: " + set2.toString());
		//Set1: [4,5]
		System.out.println("Value of Set3 is: " + set3.toString());
		//Set2: [4,5,6]
		set2.complement(set3);	// union of set1 and set2
		System.out.println("Result of complement of Set1 and Set2: " + set2.toString());
		//[6]
		System.out.println();
		
//tests clear and isempty
		set1.clear();
		System.out.println(" The statement 'Set1 is cleared' is "+ set1.isEmpty());

	}

}
