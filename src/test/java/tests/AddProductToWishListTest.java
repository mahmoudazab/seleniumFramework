package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddToWishListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToWishListTest extends TestBase {
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	AddToWishListPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";

	
	@Test(priority = 1 )
	public void UserCanSearchWithAutoSuggest ()
	{
		try {
			
			searchPage = new SearchPage(driver);
			searchPage.ProductSearchUsingAutoSuggest("MacB");
			productDetails = new ProductDetailsPage(driver);
			assertEquals(productDetails.productNameBreadCrumb.getText(), productName);
		} catch (Exception e) {
				System.out.println("Error Happened" + e.getMessage());
		}
	}
	

	@Test(priority=2)
	public void UserCanAddProductToWishlist() throws InterruptedException {
		productDetails = new ProductDetailsPage(driver);
		productDetails.AddProductToWishlist();
		driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
		wishlistObject = new AddToWishListPage(driver); 
		assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		assertTrue(wishlistObject.productCell.getText().contains(productName));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject = new AddToWishListPage(driver); 
		wishlistObject.removeProductFromWishlist();
		assertTrue(wishlistObject.EmptyCartLbl.getText().contains("The wishlist is empty!"));
	}
}
