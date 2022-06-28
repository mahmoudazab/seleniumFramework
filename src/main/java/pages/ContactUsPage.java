package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "FullName")
	WebElement fullnameTxt ;
	
	@FindBy (id = "Email")
	WebElement emailTxt ;
	
	@FindBy (id = "Enquiry")
	WebElement enquiryTxt ;
	
	@FindBy (name = "send-email")
	WebElement submitbtn;
	
	@FindBy (css = "div.result")
	public WebElement successMessage;
	
	public void ContactUS (String fullname , String email , String enqiry)
	{
		setTextElementText(fullnameTxt, fullname);
		setTextElementText(emailTxt, email);
		setTextElementText(enquiryTxt, enqiry);
		clickButton(submitbtn);
	}
	
	
}
