package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
	
	
	
	HomePage homeObj ;
	UserRegistrationPage registerObj;
	LoginPage loginObj;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchOBJ ;
	ProductDetailsPage detailsObj = new ProductDetailsPage(driver);
	ProductReviewPage product_review;
	
	
	
	//1-Registration
	@Test (priority = 1 ,alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObj = new HomePage(driver);
		homeObj.openRegistrationPage();
		registerObj = new UserRegistrationPage(driver);
		registerObj.userRegistration("Mahmoud", "Azab", "t10@Try.com", "123456", "123456");
		
		assertTrue(registerObj.successMessage.getText().contains("Your registration completed"));
	}
	//2-Search
	@Test (priority =  2)
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
	@Test (priority = 3)
	//3-Add Review
	public void userCanAddReview()
	{
		
		
		detailsObj.openAddReviewPage();
		product_review = new ProductReviewPage(driver);
		product_review.AddProductReview("new review", "bla bla bla");
		assertTrue(product_review.reviewNotification.getText().contains("Product"));
	}
	
	
	
	//4-Logout
	
	@Test (priority = 4)
	public void UserCanLogout ()
	{
		//registerObj = new UserRegistrationPage (driver);
		registerObj.userLogout();
	}


}
