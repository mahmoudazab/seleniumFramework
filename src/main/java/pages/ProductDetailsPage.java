package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement emailFriendbtn;
	
	@FindBy (css="span.price-value-4")
	public WebElement productPricelbl;
	
	@FindBy (linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn ; 
	

	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn ; 
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn ; 

	public void openSendEmail ()
	{
		clickButton(emailFriendbtn);
	}
	public void openAddReviewPage ()
	{
		clickButton(addReviewLink);
	}
	public void AddProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}
	
	public void AddProductToCompare() 
	{
		clickButton(addToCompareBtn);
	}

	public void AddToCart() 
	{
		clickButton(addToCartBtn);
	}

}
