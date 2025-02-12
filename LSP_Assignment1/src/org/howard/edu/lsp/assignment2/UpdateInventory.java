package org.howard.edu.lsp.assignment2;

//Geeks for Geeks and StackOverflow were used to figure out the syntax how to read files in Java
//It was a mix of sources for 
import java.io.*;
import java.util.Scanner;
import java.nio.file.Path;


public class UpdateInventory {
	
	//global constants for files
	private File InventoryFile;
	private FileWriter UpdatedInventoryFile;
	
	
	//Runs on the access of this main UpdateInventory File
	public static void main(String[] args) {
		try {
		//Runs method that accesses CSV Files
		UpdateInventory newInstance = new UpdateInventory();
		//Runs processing method
		newInstance.ProcessingInventory();
		}
		catch (Exception e){
	            System.out.println("An error occurred." + e);
	            e.printStackTrace();
		}}
	
	//Accesses CSV files in data folder
	public UpdateInventory () throws IOException {
		InventoryFile = new File("data/products.csv");
		UpdatedInventoryFile = new FileWriter("data/transformed_products.csv");
	}
	
	
	public void ProcessingInventory() throws IOException {
		
		//Creates instance to read and write to files
	try (Scanner ReadInventFile = new Scanner(InventoryFile);
		BufferedWriter WriterFile = new BufferedWriter(UpdatedInventoryFile))
	{
		
		while(ReadInventFile.hasNext()) {

			String ProductRow = ReadInventFile.nextLine();
			
			//Takes care of header row and add it to
			if (ProductRow.contains("ProductID")) {
				ProductRow = ProductRow  +",PriceRange";
				WriterFile.write(ProductRow);
				WriterFile.newLine();
			}
			//Skips if there are any empty rows
			else if( ProductRow.isEmpty()) {
				continue;
			}
			
			//Processing for the Products
			else {
			String[] ProductSplit = ProductRow.split(",");
			Double ProductPrice = Double.parseDouble(ProductSplit[2]); //Make the price a double so it can be manipulated
			
			//Create instance to modify product rows
			UpdateMethods UpdateProduct = new UpdateMethods();
			UpdateProduct.UpdateForAll(ProductSplit[1], ProductPrice, ProductSplit[3]); // This runs the 2 updating methods applied to all products
				
			if(ProductSplit[3].equals("Electronics")) { // This is for the two methods(discount, update category) used on Electronics
				UpdateProduct.ApplyDiscount();
				if (UpdateProduct.Price > 500) { //If after discount's it is over 500, category is updated
					UpdateProduct.AdjustCategory();
					}
				}
			//Changes Price it back into a string for loading
			ProductSplit[2] = Double.toString(UpdateProduct.Price);
			//Restrutcures row for loading 
			String[] newRow = {ProductSplit[0], UpdateProduct.Name, ProductSplit[2],
					UpdateProduct.Category,UpdateProduct.PriceRange};
			//Write to new file
			WriterFile.write(String.join(",", newRow));
			WriterFile.newLine();
			}
		}
			
			
		}
	catch (Exception e) {
            System.out.println("An error occurred." + e); //Throws if there is an error (e)
            e.printStackTrace();
	}
}}