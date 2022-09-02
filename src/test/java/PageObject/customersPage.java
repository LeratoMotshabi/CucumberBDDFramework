package PageObject;

import org.openqa.selenium.WebDriver;

import ActionDriver.action;


public class customersPage  {
	
WebDriver driver;
	
	public customersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickCustomerList()
	{
		action.click("customersList_xpath");
	}
	
	public void clickCustomers()
	{
		action.click("customers_xpath");	
		
	}
	
	public void clickAddNewButton()
	{
		action.click("addNewButton_xpath");
	}
	
	public void enterEmail(String value)
	{
		action.type("emailField_xpath", value);
		
	}
	
	public void selectCustomerRole(String value)
	{
		action.type("customerRoles_xpath", value);
	}
	
	public void clickSaveButton()
	{
		action.click("save_xpath");;
	}
	
	public boolean customerAddeduccessful()
	{
		action.IsElementPresent("customerAddedSuccessful_class");
		return false;
	}
	
	public void clickEditButton()
	{
		action.click("editButton_xpath");
	}
	
	public void enterFirstName(String value)
	{
		action.type("firstName_name_xpath", value);
	}
	
	public void closeDriver()
	{
		driver.quit();
	}
	
	

}
