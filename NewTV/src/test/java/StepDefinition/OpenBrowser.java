package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
	
	public static WebDriver driver;

	public void Open_Browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\taimur.hassan\\Downloads\\chromedriver_win32(3)\\chromedriver.exe");
   		driver = new ChromeDriver();
   		driver.manage().window().maximize();
   		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   		driver.get("https://uat:abcd@1234@weu-uat.service.teamviewer.com/en-be/checkout/cart/index/productsku/TVP0020_000686/qty/1/");
	}
}
