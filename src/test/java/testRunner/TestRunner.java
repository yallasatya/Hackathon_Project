package testRunner;





import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
 
//@RunWith(Cucumber.class)
@CucumberOptions(features =  
									//{".\\FeatureFiles/"},
								{".\\FeatureFiles/F1_doctorDetails.feature"},
								//{".\\FeatureFiles/F3_formFilling.feature"},
								//{".\\FeatureFiles/F2_Surgeries.feature"},
								//{".\\FeatureFiles/F3_InvalidFormFilling.feature"},
								//{".\\FeatureFiles/F4_ValidFormFilling.feature"},

                              glue = {"stepDefinitions"}, 
							 plugin = {"pretty", "html:reports/myreport.html",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
							 dryRun = false, 	//to check the mapping between feature steps and step definitions
							 monochrome = false, 	//to avoid junk characters in output
							 publish = true,		// to publish report in cucumber server
							 tags = "@smoke or @regression"
							 )


public class TestRunner extends AbstractTestNGCucumberTests{

}
