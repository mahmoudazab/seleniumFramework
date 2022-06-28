package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "Email")
	WebElement e_mail_txt ;
	@FindBy (id = "Password")
	WebElement password_txt ;
	@FindBy (className = "ico-login")
	WebElement login_btn;
	
	public void userCanLogin (String e_mail , String password)
	{
		setTextElementText(e_mail_txt, e_mail);
		setTextElementText(password_txt, password);
		clickButton(login_btn);
		
	}

}
