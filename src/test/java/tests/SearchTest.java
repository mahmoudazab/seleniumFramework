package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObj ;
	ProductDetailsPage productObj ;
	
	@Test
	public void UserCanSearchProducts () throws InterruptedException
	{
		searchObj = new SearchPage(driver);
		productObj = new ProductDetailsPage(driver);
		searchObj.ProductSearch(productName);
		searchObj.OpenProductTitlePage();
		
		 Assert.assertTrue(productObj.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	}
}
