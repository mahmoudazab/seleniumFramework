package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage home ;

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchOBJ ;
	ProductDetailsPage detailsObj ;

	@Test(priority = 1)
	public void TestChangeCurrency()
	{
		home = new HomePage(driver);
		home.changeCurrency();
	}

	@Test(priority = 2)
	public void UserCanSearchWithAutoSuggest ()
	{
		try {

			searchOBJ = new SearchPage(driver);
			searchOBJ.ProductSearchUsingAutoSuggest("MacB");
			detailsObj = new ProductDetailsPage(driver);
			assertEquals(detailsObj.productNameBreadCrumb.getText(), productName);
			assertTrue(detailsObj.productPricelbl.getText().contains("€"));
		} catch (Exception e) {
			System.out.println("Error Happened" + e.getMessage());
		}
	}

}
