package StepsDefinition;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ActionDriver.action;
import PageObject.customersPage;
import PageObject.loginPage;
import Utilities.propertiesManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class newCustomerSteps extends propertiesManager {

	public static String email;
	public static String FisrtName;
	WebDriver drive;

	customersPage inCustomers = new customersPage(driver);
	loginPage inLoginPage = new loginPage(driver);
	propertiesManager prop = new propertiesManager();

	@Given("user can login to nopCommerce dashboard")
	public void user_can_login_to_nop_commerce_dashboard() {

		inLoginPage.enterEmail(pro.getProperty("email"));
		inLoginPage.enterPassword(pro.getProperty("password"));
		inLoginPage.clickLoginButton();
		String actualTitle = driver.getTitle();
		String expectedTilte = "Dashboard / nopCommerce administration";
		Assert.assertEquals(actualTitle, expectedTilte, "You are not in admin Page");

	}

	@Given("user is in customers page")
	public void user_is_in_customers_page() {
		inCustomers.clickCustomerList();
		inCustomers.clickCustomers();
	}

	@When("user clicks add new button")
	public void user_clicks_add_new_button() {
		inCustomers.clickAddNewButton();

	}

	@When("user enters {string} in email")
	public void user_enters_in_email(String string) {
		string = action.randomString() + "@gmail.com";

		inCustomers.enterEmail(string);
		email = string;

	}

	@When("user enters guest or registered in customer role")
	public void user_enters_guest_or_registered_in_customer_role() {
		String customerRole = action.getText("selectedCustomerRoles_xpath");

		if (!customerRole.contains("Registered") || customerRole.isEmpty()
				|| !customerRole.contains("Guests") == false) {
			inCustomers.selectCustomerRole("Guests");
			action.keyBoardkeys(KeyEvent.VK_ENTER);
			System.out.println(action.getText("Roloe is " + action.getText("selectedCustomerRoles_xpath")));

		}

		System.out.println("Roloe is " + action.getText("selectedCustomerRoles_xpath"));

	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		inCustomers.clickSaveButton();
	}

	@Then("MESSAGE The new customer has been added successfully. MUST DISPLAY")
	public void message_the_new_customer_has_been_added_successfully_must_display() {

		Assert.assertTrue(action.IsElementPresent("customerAddedSuccessful_xpath"),
				"The message \"The new customer has been added successfully.\" is not showing");
	}

	@Then("customer unique email address should reflect in customers list")
	public void customer_unique_email_address_should_reflect_in_customers_list() {

		List<WebElement> customerList = driver.findElements(By.xpath(lo.getProperty("customerList_xpath")));
		boolean emailFound = false;
		for (int i = 1; i <= customerList.size(); i++) {
			String customer = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]//div[2]/table[1]/tbody[1]/tr[" + i + "]/td[2]"))
					.getText();

			if (customer.contains("email")) {
				emailFound = true;
				break;
			}

		}

		if (emailFound == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Cannot find email address");
		}

	}

	@When("user clicks Edit button")
	public void user_clicks_edit_button() {

		inCustomers.clickEditButton();

	}

	@When("user enters first name")
	public void user_enters_first_name() {
		FisrtName = "Lemo";
		inCustomers.enterFirstName(FisrtName);

	}

	@Then("MESSAGE The customer has been updated successfully. MUST DISPLAY")
	public void message_the_customer_has_been_updated_successfully_must_display() {

		Assert.assertTrue(action.IsElementPresent("customerAddedSuccessful_xpath"),
				"The message \"The new customer has been added successfully.\" is not showing");

	}

	@Then("customer updated name should reflect in customers list")
	public void customer_updated_name_should_reflect_in_customers_list() {

		List<WebElement> customerList = driver.findElements(By.xpath(lo.getProperty("customerList_xpath")));
		boolean firstNameFound = false;
		for (int i = 1; i <= customerList.size(); i++) {
			String customer = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]//div[2]/table[1]/tbody[1]/tr[" + i + "]/td[3]"))
					.getText();

			if (customer.contains(FisrtName)) {
				firstNameFound = true;
				break;
			}

		}

		if (firstNameFound == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Cannot find the edited name");
		}

	}

}
