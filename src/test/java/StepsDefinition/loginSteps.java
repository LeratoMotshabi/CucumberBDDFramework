package StepsDefinition;

import org.testng.Assert;

import PageObject.loginPage;
import Utilities.propertiesManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps extends propertiesManager {

	loginPage inLoginPage = new loginPage(driver);

	@Given("user is in nopCormmece login page")
	public void user_is_in_nop_cormmece_login_page() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Your store. Login";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@When("user enters valid email address")
	public void user_enters_valid_email_address() {

		inLoginPage.enterEmail(pro.getProperty("email"));
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {

		inLoginPage.enterPassword(pro.getProperty("password"));
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {

		inLoginPage.clickLoginButton();
	}

	@Then("user should be in admin page")
	public void user_should_be_in_admin_page() {

		String actualTitle = driver.getTitle();
		String expectedTilte = "Dashboard / nopCommerce administration12345";

		Assert.assertEquals(actualTitle, expectedTilte, "You are not in admin Page");

	}

	@Then("user clicks logout button")
	public void user_clicks_logout_button() {

		inLoginPage.clickLogoutButton();

	}

	@Then("MESSAGE No customer account found SHOULD DISPLAY")
	public void message_no_customer_account_found_should_display() {
		Assert.assertTrue(inLoginPage.noCustomerAccountFoundError(),
				"Message error \"No customer account found\" is not showing");

	}

	@When("user enters invalid email address")
	public void user_enters_invalid_email_address() {

		inLoginPage.enterEmail("Invalid@Email.com");
	}

	@When("user enters invalid password")
	public void user_enters_invalid_password() {

		inLoginPage.enterPassword("invalidPassword");
	}

	@Then("MESSAGE The credentials provided are incorrect SHOULD DISPLAY")
	public void message_the_credentials_provided_are_incorrect_should_display() {
		Assert.assertTrue(inLoginPage.credentialsProvidedAareIncorrectError(),
				"Message error \"The credentials provided are incorrect\" is not showing");

	}
}
