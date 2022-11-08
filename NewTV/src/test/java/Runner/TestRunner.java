package Runner;

import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
		
        features = {"src/test/resources/Features"} ,
        glue = {"StepDefinition","Hooks"},
        tags = "@Regression",
        publish = true,
        monochrome = true,
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		            
		)

public class TestRunner extends io.cucumber.testng.AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
