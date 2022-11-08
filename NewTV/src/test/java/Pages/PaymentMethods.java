package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaymentMethods {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[5]/div[1]/label/span[2]")
	WebElement Invoice; // span[@class = 'fake-radio-box'][4]

	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[1]/label/span[1]")
	WebElement CC_Method; // span[@class = 'fake-radio-box'][4]

	@FindBy(xpath = "//input[@type='text']")
	WebElement CardNumber; // span[@class = 'fake-radio-box'][4]

	@FindBy(xpath = "//input[@type='text']")
	WebElement Expire; // span[@class = 'fake-radio-box'][4]

	@FindBy(xpath = "//input[@type='text']")
	WebElement CVV; // span[@class = 'fake-radio-box'][4]

	@FindBy(xpath = "//*[@id=\"cardContainer\"]/div/div/div[2]/div[2]/label/div/input")
	WebElement CardHolder; // span[@class = 'fake-radio-box'][4]
	
	public PaymentMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	}
	
	public void Invoice()
	{
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,450)", "");
	   Invoice.click();
	
	}

	public void CreditCard() throws InterruptedException
	{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		CC_Method.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		CardNumber.sendKeys("4111 1111 1111 1111");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		Expire.sendKeys("03/30");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		CVV.sendKeys("737");
		driver.switchTo().defaultContent();
		CardHolder.sendKeys("Taimi");
	}
}
