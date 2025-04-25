package org.howard.edu.lspfinal.question3;

public class SalesReport extends Report {
	
	
	@Override
	void loadData() {
		System.out.println("Loading product sales data from the sales database...");
	};
	@Override
	void formatData() {
		System.out.println("Formating product Sales Data...");
	};
	@Override
	void printData() {
		System.out.println("Printing Product Sales Report as an .xlx");
	};

}
