package org.howard.edu.lspfinal.question3;

public class Driver {
	public static void main(String[] args) {
		Report salesReport = new SalesReport(); 
		Report hrReport = new HRReport(); 
		
		System.out.println("Creating Sales Report:");
		salesReport.createReport();
		
		System.out.println("Creating HR Report:");
		hrReport.createReport();
	}
	
	
}
