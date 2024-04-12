package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectClasses.formFillingPage;
import testBase.BaseClass;

public class Tc_03_InvalidFormFilling {
	
	formFillingPage formFillingPageObject = new formFillingPage(BaseClass.getDriver());
	
	//method to click on ForCorporates page and selects Wellness Plans
	@Given("User clicked on For corporates page and selects wellness plans")
	public void user_clicked_on_for_corporates_page_and_selects_wellness_plans() throws InterruptedException {
		formFillingPageObject.clickOnForCorporates();
		BaseClass.getLogger().info("User clicked on corporates and selected Health and Wellness......");
		BaseClass.getLogger().info("User is at Health and Wellness page.........");
		System.out.println("User clicked on corporates and selected Health and Wellness......");
	    System.out.println("User is at Health and Wellness page.........");
	}
	//Method to give all the valid details except email
	@When("user gives all the valid details except emailId")
	public void user_gives_all_the_valid_details_except_email_id() throws IOException, InterruptedException {
		String  username = BaseClass.getProperties().getProperty("username");
		String  organizationname = BaseClass.getProperties().getProperty("organizationname");
		String  invalidEmail = BaseClass.getProperties().getProperty("invalidemail");
		String  phone = BaseClass.getProperties().getProperty("validContact");
		formFillingPageObject.sendValueIntonameTextBox(username);
		formFillingPageObject.sendValueIntoOrganizationnameTextBox(organizationname);
		formFillingPageObject.sendValueIntoPhoneTextBox(phone);
		formFillingPageObject.sendValueIntoEmailTextBox(invalidEmail);
		formFillingPageObject.select_org_size();
		formFillingPageObject.select_interest();
		BaseClass.getLogger().info("User entered all the valid details except email...........");
		System.out.println("User entered all the valid details except email...........");

	    
	}
	//Method to check Schedule a demo button is disabled or not
	@Then("Schedule demo button has to be disabled")
	public void schedule_demo_button_has_to_be_disabled() {
		Assert.assertEquals(formFillingPageObject.button.isEnabled(), false);
		BaseClass.getLogger().info("Schedule a demo button is disabled....."); 
	    System.out.println("Schedule a demo button is disabled.....");
	}

}
