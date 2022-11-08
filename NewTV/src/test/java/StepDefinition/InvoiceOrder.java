package StepDefinition;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Factory.DriverFactory;
import Pages.BillingDetails;
import Pages.CartFunctions;
import Pages.CheckoutFunctions;
import Pages.PaymentMethods;
import Pages.SuccessPage;
import Utilities.ReadXLSdata;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

/*import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;*/

public class InvoiceOrder {
	
	//public static WebDriver driver;
	//CartFunctions pf;
	private CheckoutFunctions checkout;
	private CartFunctions pf;
	private BillingDetails GetBillingDetails;
	private PaymentMethods pm;
	
	SuccessPage sp;
	
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
	

	@Given("User open browser and redirects to cart page") public void Cart_URL()
	  {
	  
			/*
			 * System.setProperty(
			 * "webdriver.chrome.driver","C:\\Users\\taimur.hassan\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe"
			 * ); driver = new ChromeDriver(); driver.manage().window().maximize();
			 * 
			 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 */
	    DriverFactory.getDriver().get("https://uat:abcd@1234@weu-uat.service.teamviewer.com/en-be/checkout/cart/index/productsku/TVB0010_000681/qty/1/");
	  }
	  
	  @When("accept cookies") public void Cookie() throws InterruptedException {
	  
	  //pf = new CartFunctions(driver); 
	  pf = new CartFunctions(DriverFactory.getDriver());
	  pf.Accept_Cookie(); }
	  
	  @And("refresh cart page") public void reload_cart_page() throws
	  InterruptedException {
	  
	  pf.Refresh_Cart_Page(); }
	  
	  @And("close chat window") public void close_chat_window() throws InterruptedException
	  { 
		  pf.close_chat_window(); 
	  }
	  @And("enter valid email") public void Email() throws InterruptedException
	  { 
		  pf.Enter_Email(); 
	  }
	  
	  @And("click on cotinue button") public void click_on_continue_button() throws
	  InterruptedException {
	  
	  pf.Continue_button();
	  
	  }
	  
	  
	  @And("fills the form from sheetname {string} and rownumber {int}")
	  public void fills_the_form_from_given_sheetname_and_rownumbe(String sheetName, Integer rowNumber) throws
	  InterruptedException, InvalidFormatException, IOException 
	  { 
	 
			
			/*
			 * ReadXLSdata reader = new ReadXLSdata(); List<Map<String,String>> testData =
			 * reader.getData(
			 * "\\Users\\taimur.hassan\\eclipse-workspace\\NewTV\\src\\test\\resources\\TestData\\testdata.xlsx",
			 * sheetName); String FName = testData.get(rowNumber).get("FirstName"); String
			 * LName = testData.get(rowNumber).get("LastName"); String PhoneNo =
			 * testData.get(rowNumber).get("Phone"); String CompanyName =
			 * testData.get(rowNumber).get("Company"); String Address =
			 * testData.get(rowNumber).get("Address"); String Zip =
			 * testData.get(rowNumber).get("Zip"); String city =
			 * testData.get(rowNumber).get("City");
			 * 
			 * 
			 * checkout = new CheckoutFunctions(DriverFactory.getDriver());
			 * checkout.Add_Data(FName, LName, PhoneNo, CompanyName, Address, Zip, city);
			 */
		  
		  GetBillingDetails = new BillingDetails();
		  GetBillingDetails.AddBillingDetails("Enter_Data",0);
		
	  
	  }
	  
	  
	  @And("select Invoice Payment Method") public void Select_Payment_Method()
	  throws InterruptedException {
	  
			/*
			 * checkout = new CheckoutFunctions(DriverFactory.getDriver());
			 * checkout.Invoice_Payment_Method();
			 */
		  pm = new PaymentMethods(DriverFactory.getDriver());
		  pm.Invoice();
		  
	   }
	  
	  @And("select terms and condition check box") public void checkbox() {
	  
	  checkout.Accept_Policy(); }
	  
	  @Then("Order place successfuly and user redirects to success page") public
	  void success_page() {
	  
	  System.out.print("Total are verified");} 
	  
	  //WebDriver.quit(); }
	 
	//----------   Credit Card Order------------------------------//
	
	@Given("Open browser and redirects to cart page")
	public void URL() {
		
		//Cart_URL();
		DriverFactory.getDriver().get("https://uat:abcd@1234@weu-uat.service.teamviewer.com/en-be/checkout/cart/index/productsku/TVP0020_000686/qty/1/");
	}

	@When("User accept cookies")
	public void Cookies() throws InterruptedException {
		
		//pf = new CartFunctions(driver);
		pf = new CartFunctions(DriverFactory.getDriver());
		pf.Accept_Cookie();
	}

	@And("User refresh cart page")
	public void load_cart_page() throws InterruptedException {
		
		pf.Refresh_Cart_Page();
	}
    
	@And("User close chat window")
	public void close_window() throws InterruptedException{
	      pf.close_chat_window();
	}

	@And("User select additional concurrent users addon")
	public void User_addon1() throws InterruptedException {
		
		pf.Concurrent_users_addon();
	}
	@And("User select MDS addon")
	public void MDS_addon2() throws InterruptedException {
		
		pf.MDS_Addon();
	}
	@And("User enters valid email")
	public void Enetr_Email() throws InterruptedException {
		
		pf.Enter_Email();
	}
	
	@And("User click on cotinue button")
    public void click_continue_button() throws InterruptedException {
		
		pf.Continue_button();
		
	}
	
	
	  @And("User fills the form from given sheet {string} and rownbr {int}")
	  public void Add_Data(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException
	{	  
		  GetBillingDetails = new BillingDetails();
		  GetBillingDetails.AddBillingDetails("Enter_Data",0);
		 
	}
	 
	
	@And("User select CC Payment Method")
    public void CC_Method() throws InterruptedException {
		
		/*
		 * checkout = new CheckoutFunctions(DriverFactory.getDriver());
		 * checkout.CC_Payment_Method();
		 */
		pm.CreditCard();
	}
	
	@And("User select terms and condition check box")
    public void select_checkbox() {
		
		checkout.Accept_Policy();
		//checkout.Place_Order();
	}
	@And("Click on Place Order button")
	public void success_page2() {

		checkout.Place_Order();
		System.out.print("Total are verified");
	}
	@Then("Take Channel reference id on success page")
	public void OrderId() throws InterruptedException {

          sp.Channel_reference_id();		
	}
}
