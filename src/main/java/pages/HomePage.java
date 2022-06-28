package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver ;
		action = new Actions(driver);
	}
	@FindBy (className  = "ico-register")
	WebElement registerLink ; 

	@FindBy (className = "ico-login")
	WebElement loginLink ;
	
	@FindBy (linkText = "Contact us")
	WebElement contactUsBtn;

	@FindBy (id = "customerCurrency")
	WebElement currencydropDownList;

	@FindBy(linkText   = "Computers ")
	WebElement computerMenu;
	
	@FindBy (linkText   = "Notebooks ")
	WebElement notebooksMenu;
	
	public void openRegistrationPage ()
	{
		clickButton(registerLink);
	}
	
	public void openLoginPage ()
	{
		clickButton(loginLink);
	}
	public void openContactUsPage ()
	{
		scrolltoButtom();
		clickButton(contactUsBtn);
		
	}
	public void changeCurrency()
	{
		select = new Select(currencydropDownList);
		select.selectByIndex(1);
	}
	public void moveTOComputerMenu()
	{
		action.moveToElement(computerMenu).click().perform();
		
	}
}
