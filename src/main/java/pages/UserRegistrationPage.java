package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{
	
	public UserRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy (id = "gender")
	WebElement gender_Rdo_btn ;
	
	@FindBy(id = "FirstName")
	WebElement firstName_txt;
	
	@FindBy (id = "LastName")
	WebElement lastName_txt ;
	
	@FindBy (id = "Email")
	WebElement e_mail_txt ;
	
	@FindBy (id="Password")
	WebElement password_Txt ;
	
	@FindBy (id ="ConfirmPassword")
	WebElement confirmPassword_Txt ;
	
	@FindBy (id = "register-button")
	WebElement register_btn ;
	
	@FindBy (className = "result")
	public WebElement successMessage;
	
	@FindBy (className = "ico-logout")
	public WebElement logout_btn;
	public void userRegistration (String firstname , String lastname , String e_mail , String password , String re_password)
	{
		clickButton(gender_Rdo_btn);
		setTextElementText(firstName_txt, firstname);
		setTextElementText(lastName_txt, lastname);
		setTextElementText(e_mail_txt, e_mail);
		setTextElementText(password_Txt, password);
		setTextElementText(confirmPassword_Txt, re_password);
		clickButton(register_btn);
		
	}
	public void userLogout ()
	{
		clickButton(logout_btn);
	}
	@FindBy (className = "ico-account")
	WebElement myacountLink;
	public void openMyAccountPage ()
	{
		clickButton(myacountLink);
	}
	
	
	

}
