package Pages;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartFunctions {
	
	private WebDriver driver;
	//public static WebDriver new_driver;
	public String cart_sub_total;
	public String tax;
	public String cart_totals;
	
	
	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement accept_cookie;
	
	@FindBy(id="userlike-close")
	WebElement chat_window;
	
	@FindBy(xpath = "//*[@id='addons-content']/div[2]/div/div/div[2]/div/div/div")
	//*[@id='addons-content']/div[2]/div/div/div[2]/div/div/div
	WebElement addon_dropdown;
   
	@FindBy(xpath = "//ul[@class='select-options add-to-product-qty-TVAD001_000000086']/li[2]")
	//*[@id='addons-content']/div[2]/div/div/div[2]/div/div/ul/li[2]
	WebElement addon_qty;
	
	@FindBy(xpath = "//label[@id = 'add_update_action_fake_checkbox_23']/em[1]")
	//*[@id='addons-content']/div[3]/div/div/div[2]/div/label/em[1]
	WebElement MDS_addon;
	
	@FindBy(xpath = "//button[@class='checkout-submit']")
	WebElement Continue_btn;
	
	@FindBy(xpath = "//td[@class = 'amount text-right']/span/span")
	WebElement Cart_subtotal;
	
	@FindBy(xpath = "//td[@class = 'amount text-right']/span[2]")
	WebElement Cart_Tax;
	
	@FindBy(xpath = "//span[@class = 'price order-total-tag']/span")
	WebElement Cart_Total;
	
	@FindBy(id="email-input")
	WebElement Email;
	
	
	
	  public CartFunctions(WebDriver driver) { 
		  
		  this.driver = driver;
          PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	  }
	  
	 
    public void Accept_Cookie() throws InterruptedException
    {
    
    	
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  wait.until(ExpectedConditions.elementToBeClickable(accept_cookie));
		  
		  //Thread.sleep(30000); 
		  accept_cookie.click();
		 
	}
    public void Refresh_Cart_Page() throws InterruptedException {
		Thread.sleep(1000);
		driver.navigate().to("https://weu-uat.service.teamviewer.com/en-be/checkout/cart/");
		
	}

	 public void close_chat_window() throws InterruptedException {
	  
			/*
			 * if(!new_driver.findElements(By.id("userlike-close")).isEmpty()) {
			 * chat_window.click(); } else {
			 * System.out.println("Chat Box is not available");
			 * 
			 * }
			 */
		 System.out.println("Chat Box is not available");
	 }
	 
    public void Concurrent_users_addon() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(addon_dropdown));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,140)","");
		Thread.sleep(1000);
		addon_dropdown.click();
        addon_qty.click();
	}
    public void MDS_Addon() throws InterruptedException {
		
		  Thread.sleep(5000);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();", MDS_addon);
		  MDS_addon.click();
		 
		
	}
   
    public void Cart_Totals()
    {
    	cart_sub_total = Cart_subtotal.getText();
    	tax = Cart_Tax.getText();
    	cart_totals = Cart_Total.getText();
    	
    	//CheckoutPage cp = new CheckoutPage(new_driver);
    	//cp.calculations(cart_sub_total, tax, cart_totals);
  
    }
   public void Enter_Email() throws InterruptedException {
		
    	Thread.sleep(2000);
  		JavascriptExecutor js = (JavascriptExecutor) driver;
  		//js.executeScript("arguments[0].scrollIntoView();", Email);
  		js.executeScript("window.scrollBy(0,150)","");
		Email.sendKeys("smith@visionet.com");
		
	}
    public void Continue_button() throws InterruptedException {
		
    	Thread.sleep(1000);
  		Continue_btn.click();
  		
  	}

}
