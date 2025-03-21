package org.howard.edu.lsp.midterm.question2;

import java.util.Objects;

public class Book {
	
	private String title;
	private String author;
	private String ISBN; 
	private int yearPublished;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * This method creates an instance of the book with the needed info as below
	 * @param title - this is a with the title
	 * @param author - this is the authors name
	 * @param ISBN 
	 * @param yearPublished - this is changed to an int because this is inharently and integer 
	 */
	public Book(String title, String author, String ISBN, int yearPublished) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.yearPublished = yearPublished;
		
	}
	
	/**
	 * This overide the abstracted equals method. I did use chatgpt to understand the syntax. It is a recursive function, it makes sure the inputed paramater is a book class and the recursivly checkes if its equal/
	 */
	@Override
	public boolean equals(Object Book) {
		if(this == Book) {
			return true;
		}
		if (Book == null || getClass() != Book.getClass()) { 
			return false;} 
		Book book = (Book) Book;
		
		return Objects.equals(this.ISBN, book.ISBN) && Objects.equals(this.author, book.author);
		
	}
	
	/**
	 * this changes the return for the toString method to fit the desired format that access the attributes of the class in a readable way.
	 */
	@Override
	public String toString() {
		return "Title:" + this.title +", Author:"+ this.author+",ISBN:"+this.ISBN +"Year Published:"+ this.yearPublished;
	}
	
	

}
