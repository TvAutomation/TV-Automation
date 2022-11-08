package Pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Factory.DriverFactory;
import Utilities.ReadXLSdata;

public class BillingDetails {
	
	private CheckoutFunctions checkout;

	public void AddBillingDetails(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException
	{
		ReadXLSdata reader = new ReadXLSdata();
		  List<Map<String,String>> testData = reader.getData("\\Users\\taimur.hassan\\eclipse-workspace\\NewTV\\src\\test\\resources\\TestData\\testdata.xlsx", sheetName);
		  String FName = testData.get(rowNumber).get("FirstName");
		  String LName = testData.get(rowNumber).get("LastName");
		  String PhoneNo = testData.get(rowNumber).get("Phone");
		  String CompanyName = testData.get(rowNumber).get("Company");
		  String Address = testData.get(rowNumber).get("Address");
		  String Zip = testData.get(rowNumber).get("Zip");
		  String city = testData.get(rowNumber).get("City");
		  
		  checkout = new CheckoutFunctions(DriverFactory.getDriver());
		  checkout.Add_Data(FName, LName, PhoneNo, CompanyName, Address, Zip, city);
		  
	}
}
