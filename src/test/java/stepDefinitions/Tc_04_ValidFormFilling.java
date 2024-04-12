package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectClasses.formFillingPage;
import testBase.BaseClass;

public class Tc_04_ValidFormFilling {
	
	formFillingPage formFillingPageObject1 = new formFillingPage(BaseClass.getDriver());
	//method to click on ForCorporates page and selects Wellness Plans
	@Given("User clicked on ForCorporates page and selects Wellness Plans")
	public void user_clicked_on_for_corporates_page_and_selects_wellness_plans() throws InterruptedException {
		formFillingPageObject1.clickOnForCorporates();
		BaseClass.getLogger().info("User clicked on corporates and selected Health and Wellness......");
		BaseClass.getLogger().info("User is at Health and Wellness page.........");
		System.out.println("User clicked on corporates and selected Health and Wellness......");
	    System.out.println("User is at Health and Wellness page.........");
	}
	//Method to give all the valid details
	@When("user gives all the valid details")
	public void user_gives_all_the_valid_details() throws IOException, InterruptedException {
		String  username = BaseClass.getProperties().getProperty("username");
		String  organizationname = BaseClass.getProperties().getProperty("organizationname");
		String  validEmail = BaseClass.getProperties().getProperty("validemail");
		String  phone = BaseClass.getProperties().getProperty("validContact");
		formFillingPageObject1.sendValueIntonameTextBox(username);
		formFillingPageObject1.sendValueIntoOrganizationnameTextBox(organizationname);
		formFillingPageObject1.sendValueIntoPhoneTextBox(phone);
		formFillingPageObject1.sendValueIntoEmailTextBox(validEmail);
		formFillingPageObject1.select_org_size();
		formFillingPageObject1.select_interest();
		BaseClass.getLogger().info("User entered all the valid details...........");
		System.out.println("User entered all the valid details...........");
	    
	}
	//Method to check Schedule a demo button is enabled or not
	@When("Schedule a demo button has to be enabled")
	public void schedule_a_demo_button_has_to_be_enabled() {
		Assert.assertEquals(formFillingPageObject1.button.isEnabled(), true);
		BaseClass.getLogger().info("Schedule a demo button is enabled.....");
		System.out.println("Schedule a demo button is enabled.....");
	   
	}
	//Method to check thank you msg is displayed or not
	@Then("Thank Message should be displayed")
	public void thank_message_should_be_displayed() throws InterruptedException {
		formFillingPageObject1.clickButton();
		Assert.assertEquals(formFillingPageObject1.thankYouMessage(),true);
		BaseClass.getLogger().info("Thank You Message is Displayed.....");
		System.out.println("Thank You Message is Displayed.....");
	   
	}

}
