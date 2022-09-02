package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, 
				 glue = { "StepsDefinition","Hooks" },
				 monochrome = true, 
				 plugin = { "html:src/test/resources/Reports/cucuber-report/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty" })
public class runner extends AbstractTestNGCucumberTests {

}
