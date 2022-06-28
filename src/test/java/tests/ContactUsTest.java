package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	
	HomePage home ;
	ContactUsPage contactPage ;
	
	String email = "test@test.com";
	String fullname = "Test User";
	String enqiury = "Hello I am learning selenium";
	
	@Test
	public void TestContactUs () throws InterruptedException
	{
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUS(fullname, email, enqiury);
		Thread.sleep(3000);
		//assertTrue(contactPage.successMessage.getText().contains(" Your enquiry has been successfully sent to the store owner. "));
		
		assertEquals(contactPage.successMessage.getText(),  "Your enquiry has been successfully sent to the store owner." );
	}

}
