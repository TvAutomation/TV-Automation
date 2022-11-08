package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
	
	WebDriver success_driver;
	String OrderId;
	
	@FindBy(name = "channel-reference-number")
	WebElement ChannelReferenceId;
	
	public SuccessPage(WebDriver driver)
	{
		this.success_driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Channel_reference_id() throws InterruptedException
	{
		Thread.sleep(3000);
		OrderId = ChannelReferenceId.getAttribute("Value");
		System.out.println("Channel id is"+OrderId); 
		
	}

}
