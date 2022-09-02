package ActionDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WaitHelper;
import Utilities.propertiesManager;

public class action extends propertiesManager {
	

	
	
	public static WebElement waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void type(String locator, String value) {

		WebElement ele;
		if (locator.endsWith("_xpath")) {
			ele = waitForElement(driver.findElement(By.xpath(lo.getProperty(locator))));
			ele.clear();
			ele.sendKeys(value);
		} else if (locator.endsWith("_css")) {
			ele = waitForElement(driver.findElement(By.cssSelector(lo.getProperty(locator))));
			ele.clear();
			ele.sendKeys(value);
		} else if (locator.endsWith("_id")) {
			ele = waitForElement(driver.findElement(By.id(lo.getProperty(locator))));
			ele.clear();
			ele.sendKeys(value);
		}
		if (locator.endsWith("_link")) {
			ele = waitForElement(driver.findElement(By.linkText(lo.getProperty(locator))));
			ele.clear();
			ele.sendKeys(value);
		} else if (locator.endsWith("_class")) {
			ele = waitForElement(driver.findElement(By.className(lo.getProperty(locator))));
			ele.clear();
			ele.sendKeys(value);
		}

	}

	public static void click(String locator) {
		{

			if (locator.endsWith("_xpath")) {
				waitForElement(driver.findElement(By.xpath(lo.getProperty(locator)))).click();

			} else if (locator.endsWith("_css")) {
				waitForElement(driver.findElement(By.cssSelector(lo.getProperty(locator)))).click();

			} else if (locator.endsWith("_id")) {
				waitForElement(driver.findElement(By.id(lo.getProperty(locator)))).click();

			}
			if (locator.endsWith("_link")) {
				waitForElement(driver.findElement(By.linkText(lo.getProperty(locator)))).click();

			} else if (locator.endsWith("_class")) {
				waitForElement(driver.findElement(By.className(lo.getProperty(locator)))).click();

			}

		}
	}

	public static String selectByName(String locator, String value) {

		Select select;
		if (locator.endsWith("_xpath")) {
			select = new Select(waitForElement(driver.findElement(By.xpath(lo.getProperty(locator)))));
			select.selectByVisibleText(value);
		} else if (locator.endsWith("_css")) {
			select = new Select(waitForElement(driver.findElement(By.cssSelector(lo.getProperty(locator)))));
			select.selectByVisibleText(value);
		} else if (locator.endsWith("_id")) {
			select = new Select(waitForElement(driver.findElement(By.id(lo.getProperty(locator)))));
			select.selectByVisibleText(value);
		}
		if (locator.endsWith("_link")) {
			select = new Select(waitForElement(driver.findElement(By.linkText(lo.getProperty(locator)))));
			select.selectByVisibleText(value);
		} else if (locator.endsWith("_class")) {
			select = new Select(waitForElement(driver.findElement(By.className(lo.getProperty(locator)))));
			select.selectByVisibleText(value);
		}
		return value;
	}

	public static String getText(String locator) {

		String ele = null;
		if (locator.endsWith("_xpath")) {
			ele = driver.findElement(By.xpath(lo.getProperty(locator))).getText();

		} else if (locator.endsWith("_css")) {
			ele = driver.findElement(By.cssSelector(lo.getProperty(locator))).getText();

		} else if (locator.endsWith("_id")) {
			ele = driver.findElement(By.id(lo.getProperty(locator))).getText();

		}
		if (locator.endsWith("_link")) {
			ele = driver.findElement(By.linkText(lo.getProperty(locator))).getText();

		} else if (locator.endsWith("_class")) {
			ele = driver.findElement(By.className(lo.getProperty(locator))).getText();

		}
		return ele;

	}

	public static String getAttribute(String locator) {

		String ele = null;
		if (locator.endsWith("_xpath")) {
			ele = driver.findElement(By.xpath(lo.getProperty(locator))).getAttribute("value");

		} else if (locator.endsWith("_css")) {
			ele = driver.findElement(By.cssSelector(lo.getProperty(locator))).getAttribute("value");

		} else if (locator.endsWith("_id")) {
			ele = driver.findElement(By.id(lo.getProperty(locator))).getAttribute("value");

		}
		if (locator.endsWith("_link")) {
			ele = driver.findElement(By.linkText(lo.getProperty(locator))).getAttribute("value");

		} else if (locator.endsWith("_class")) {
			ele = driver.findElement(By.className(lo.getProperty(locator))).getAttribute("value");

		}
		return ele;

	}

	public static boolean isAlertPresent() {
		
		
		boolean result = false;
		try {
			 driver.switchTo().alert();
			 driver.switchTo().alert().accept();
			
			result = true;
		} catch (NoAlertPresentException e) {
			result = false;
		}
		return result;
		

	}

	public static boolean IsElementPresent(String locator) {

		boolean result = false;
		try {
			if (locator.endsWith("_xpath")) {
				driver.findElement(By.xpath(lo.getProperty(locator)));

			} else if (locator.endsWith("_css")) {
				driver.findElement(By.cssSelector(lo.getProperty(locator)));

			} else if (locator.endsWith("_id")) {
				driver.findElement(By.id(lo.getProperty(locator))).getText();

			}
			if (locator.endsWith("_link")) {
				driver.findElement(By.linkText(lo.getProperty(locator)));

			} else if (locator.endsWith("_class")) {
				driver.findElement(By.className(lo.getProperty(locator)));

			}
			result = true;
		} catch (NoSuchElementException e) {
			result = false;
		}

		return result;
	}

	public static void PressKeyboardKeys(String locator, Keys keys) {

		if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(lo.getProperty(locator))).sendKeys(keys);
		} else if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(lo.getProperty(locator))).sendKeys(keys);
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(lo.getProperty(locator))).sendKeys(keys);
		}
		if (locator.endsWith("_link")) {
			driver.findElement(By.linkText(lo.getProperty(locator))).sendKeys(keys);
		} else if (locator.endsWith("_class")) {
			driver.findElement(By.className(lo.getProperty(locator))).sendKeys(keys);
		}

	}

	public static void keyBoardkeys(int keys) {
		try {
			Robot robot = new Robot();
			robot.keyPress(keys);

		} catch (AWTException e) {

		}
	}

	public static String randomString() {
		return RandomStringUtils.randomAlphabetic(8);
	}

}
