package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	
	}
	@FindBy (id = "small-searchterms")
	WebElement searchtxt ;
	
	@FindBy (css="button.button-1.search-box-button")
	WebElement searchbtn;
	
	@FindBy (id = "ui-id-1")
	List<WebElement> searchList;
	
	@FindBy (linkText  ="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	 
	public void ProductSearch (String product) throws InterruptedException
	{
		setTextElementText(searchtxt, product);
		clickButton(searchbtn);
		Thread.sleep(1000);
		
	}
	
	public void OpenProductTitlePage ()
	{
		clickButton(productTitle);
		
	}
	public void ProductSearchUsingAutoSuggest(String searchtxtBox)
	{
		setTextElementText(searchtxt, searchtxtBox);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchList.get(0).click();
	}
	
	

}
