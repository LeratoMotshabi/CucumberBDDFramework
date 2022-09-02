package PageObject;

import org.openqa.selenium.WebDriver;

import ActionDriver.action;

public class loginPage {

	WebDriver driver;
	
	 		

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmail(String value) {
		action.type("email_xpath", value);
	}

	public void enterPassword(String value) {
		action.type("password_id", value);
	}

	public void clickLoginButton() {
		action.click("loginButton_xpath");
	}

	public void clickLogoutButton() {
		action.click("logoutButton_xpath");
	}

	public boolean noCustomerAccountFoundError() {
		return action.IsElementPresent("noCustomerAccountFound_xpath");

	}

	public boolean credentialsProvidedAareIncorrectError() {

		return action.IsElementPresent("credentialsProvidedAareIncorrect_xpath");

	}

}
