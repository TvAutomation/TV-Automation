package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCheckout {
	
	WebDriver checkout_driver;
	String CartSubTotal;
	String CartTax;
	String CartTotal;
	String Checkout_subtotal;
	String Checkout_tax;
	String Checkout_total;

	@FindBy(xpath = "(//input[@type = 'text'])[1]")
	WebElement First_Name;
	
	@FindBy(xpath = "(//input[@type = 'text'])[2]")
	WebElement Last_Name;
	
	@FindBy(xpath = "(//input[@type = 'text'])[3]")
	WebElement Email;
	
	@FindBy(xpath = "(//input[@type = 'text'])[4]")
	WebElement Phone_No;
	
	@FindBy(xpath = "(//input[@type = 'text'])[5]")
	WebElement Company_Name;
	
	@FindBy(xpath = "(//input[@type = 'text'])[7]")
	WebElement Address;
	
	@FindBy(xpath = "(//input[@type = 'text'])[8]")
	WebElement Zip;
	
	@FindBy(xpath = "(//input[@type = 'text'])[9]")
	WebElement City;
	
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[5]/div[1]/label/span[2]")
	WebElement Invoice; //span[@class = 'fake-radio-box'][4]
	
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[1]/label/span[1]")
	WebElement CC_Method; //span[@class = 'fake-radio-box'][4]
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement CardNumber; //span[@class = 'fake-radio-box'][4]
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement Expire; //span[@class = 'fake-radio-box'][4]
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement CVV; //span[@class = 'fake-radio-box'][4]
	
	@FindBy(xpath = "//*[@id=\"cardContainer\"]/div/div/div[2]/div[2]/label/div/input")
	WebElement CardHolder; //span[@class = 'fake-radio-box'][4]
	
	@FindBy(xpath = "(//span[@class='fake-checkbox-box'])[5]")
	WebElement Conditional_Checkbox;
	
	@FindBy(xpath = "//span[@class = 'amount right checkout-subtotal']/span")
	WebElement CheckoutSubtotal;
	
	@FindBy(xpath = "//span[@class = 'amount text-right']/span")
	WebElement CheckoutTax;
	
	@FindBy(xpath = "//span[@class = 'price order-total-tag']/span")
	WebElement CheckoutTotals;
	
	@FindBy(id = "action-primary-continue")
	WebElement Place_Order_Button;
	
	public NewCheckout(WebDriver driver)
	{
		this.checkout_driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	  public void Add_Data(String FirstName, String LastName , String email, String PhoneNumber, String CompanyName , String Adress, String ZipCode, String city) throws InterruptedException 
	{
	  WebDriverWait wait = new WebDriverWait(checkout_driver, Duration.ofSeconds(60));
	  wait.until(ExpectedConditions.elementToBeClickable(First_Name));
	  JavascriptExecutor js = (JavascriptExecutor) checkout_driver;
	  js.executeScript("window.scrollBy(0,250)","");
	  First_Name.sendKeys(FirstName); Last_Name.sendKeys(LastName);
	  Email.sendKeys(email); Phone_No.sendKeys(PhoneNumber);
	  Company_Name.sendKeys(CompanyName); Address.sendKeys(Adress); Zip.sendKeys(ZipCode);
	  Thread.sleep(2000); City.sendKeys(city); 
	  }
	 
	
	public void Invoice_Payment_Method() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(checkout_driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(Invoice));
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) checkout_driver;
		js.executeScript("window.scrollBy(0,450)","");
		Invoice.click();
	}
	
	public void CC_Payment_Method() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(checkout_driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(Invoice));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) checkout_driver;
		js.executeScript("window.scrollBy(0,400)","");
		CC_Method.click();
		Thread.sleep(2000);
		checkout_driver.switchTo().frame(0);
		//checkout_driver.findElement(By.xpath("//input[@type='text']")).sendKeys("4111 1111 1111 1111");
		CardNumber.sendKeys("4111 1111 1111 1111");
		checkout_driver.switchTo().defaultContent();
		checkout_driver.switchTo().frame(1);
		//checkout_driver.findElement(By.xpath("//input[@type='text']")).sendKeys("03/30");
		Expire.sendKeys("03/30");
		checkout_driver.switchTo().defaultContent();
		checkout_driver.switchTo().frame(2);
		//checkout_driver.findElement(By.xpath("//input[@type='text']")).sendKeys("737");
		CVV.sendKeys("737");
		checkout_driver.switchTo().defaultContent();
		//checkout_driver.findElement(By.xpath("//*[@id=\"cardContainer\"]/div/div/div[2]/div[2]/label/div/input")).sendKeys("Taimi");
		CardHolder.sendKeys("Taimi");
		
	}
	
	public void Accept_Policy()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) checkout_driver;
  		js.executeScript("arguments[0].scrollIntoView();", Conditional_Checkbox);
		Conditional_Checkbox.click();
	}
	
	public void Place_Order()
	{
		Place_Order_Button.click();
	}


}
