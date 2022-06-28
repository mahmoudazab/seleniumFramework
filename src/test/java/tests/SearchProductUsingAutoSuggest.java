package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchOBJ ;
	ProductDetailsPage detailsObj ;
	
	@Test
	public void UserCanSearchWithAutoSuggest ()
	{
		try {
			
			searchOBJ = new SearchPage(driver);
			searchOBJ.ProductSearchUsingAutoSuggest("MacB");
			detailsObj = new ProductDetailsPage(driver);
			assertEquals(detailsObj.productNameBreadCrumb.getText(), productName);
		} catch (Exception e) {
				System.out.println("Error Happened" + e.getMessage());
		}
	}

}
