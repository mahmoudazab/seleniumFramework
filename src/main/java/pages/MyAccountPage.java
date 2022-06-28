package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy (linkText = "Change password")
	WebElement change_password_btn;
	public void OpenChangePassword()
	{
		clickButton(change_password_btn);
	}
	@FindBy(id="OldPassword")
	WebElement oldPassword_txt;
	
	@FindBy(id = "NewPassword")
	WebElement newPassword_txt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirm_newPassword_txt;
	
	@FindBy (partialLinkText =  "Change password")
	WebElement changePassword_btn;
	
	@FindBy (linkText =   "Password was changed")
	public WebElement result;
	
	public void ChangePassword (String oldPassword , String newPassword)
	{
		setTextElementText(oldPassword_txt, oldPassword);
		setTextElementText(newPassword_txt, newPassword);
		setTextElementText(confirm_newPassword_txt, newPassword);
		clickButton(changePassword_btn);
	}
	
	
	
	

}
