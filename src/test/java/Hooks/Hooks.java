package Hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.propertiesManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends propertiesManager {

	@Before
	public void goToWebsite() {

		try {
			file1 = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
			pro.load(file1);

			file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/locators.properties");
			lo.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (pro.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (pro.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (pro.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get((pro.getProperty("url")));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

	}

	@After
	public void tearDown() {
		driver.quit();
		// EmailManager.SendEmail(System.getProperty("user.dir")+"/target/SparkReport/Spark.html");
	}

}
