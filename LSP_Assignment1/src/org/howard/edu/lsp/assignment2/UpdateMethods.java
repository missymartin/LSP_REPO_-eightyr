package org.howard.edu.lsp.assignment2;

public class UpdateMethods {
	String Name ;
	Double Price;
	String Category;
	String PriceRange = null;
	
	public void UpdateForAll (String NameGiven, Double PriceGiven, String CategoryGiven) {
		CapitlizeProduct(NameGiven);
		AssignRange(PriceGiven);
		Category = CategoryGiven;
		Price = PriceGiven;
	}

	//For all Items
	public void CapitlizeProduct (String NameGiven) {
		Name = NameGiven.toUpperCase();
	}
	
	//For all Items
	public void AssignRange (double PriceGiven) {
		if (0 <= PriceGiven && PriceGiven <= 10) {
			PriceRange = "Low";
		}
		else if (10.01 <= PriceGiven && PriceGiven <= 100) {
			PriceRange = "Medium";
		}
		else if (100.01 <= PriceGiven && PriceGiven <= 500) {
			PriceRange = "High";
		}
		else {
			PriceRange = "Premium"; 
		}
	}
	
	//For Electronics 
	// Rounding code was found from https://onextdigital.com/how-to-round-doubles-in-java-to-two-decimal-places/
	

	public void ApplyDiscount () {
		Price = Price - (Price*.1);
		//Rounds discount up to 2 decimals
		Price = Math.round(Price*100.0)/100.0;
	}
	
	//Only used on electronics under price range premium
	public void AdjustCategory () {
		Category = "Premium Electronics";
	}
	
	
}
