package org.howard.edu.lspfinal.question3;

public class HRReport extends Report{
			
		@Override
		void loadData() {
			System.out.println("Loading data from the HR files...");
		};
		@Override
		void formatData() {
			System.out.println("Formating HR Data by emplotyee case...");
		};
		@Override
		void printData() {
			System.out.println("Printing HR Report as an .pdf");
		};

	}

