package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistartion extends TestBase {
	
	HomePage home ;
	UserRegistrationPage registration;
	
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		home = new HomePage(driver);
		home.openRegistrationPage();
	    throw new io.cucumber.java.PendingException();
	}
	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		throw new io.cucumber.java.PendingException();
	}
	@When("I entered the user data")
	public void i_entered_the_user_data() {
		registration = new UserRegistrationPage(driver);
		registration.userRegistration("Mahmoud", "Azab","Mahmoud@Mahmoud.com","123456","123456");
		throw new io.cucumber.java.PendingException();
	}
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registration.userLogout();
		throw new io.cucumber.java.PendingException();
	}
}
