package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hook {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	
	@Before
    public void beforeScenario(){
		
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();

    }	
	
	@After
    public void afterScenario(Scenario scenario){
		
		
			String screenshotName = scenario.getName();
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		
    }

}
