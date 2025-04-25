package org.howard.edu.lspfinal.question3;

abstract class Report {
	
	public final void createReport() {
		loadData();
		formatData();
		printData();
	}

	abstract void loadData();
	abstract void formatData();
	abstract void printData();
	
}
