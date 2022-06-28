package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	//Something Went Wrong with this test
	HomePage home ;
	@Test
	public void userCanSelectSubCategoryFromMainMenu()
	{
		
			home = new HomePage(driver);
			home.moveTOComputerMenu();
			assertTrue(driver.getCurrentUrl().contains("notebooks"));
	
	}
	

}
