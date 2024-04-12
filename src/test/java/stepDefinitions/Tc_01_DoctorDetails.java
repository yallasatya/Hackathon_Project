package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectClasses.FindDoctorsPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class Tc_01_DoctorDetails {
	
	public static WebDriver driver;
	FindDoctorsPage findDoctorsPage = new FindDoctorsPage(BaseClass.getDriver());
	
	
	// method to navigate to practo page
	@Given("user is on the practo home page")
	public void user_is_on_the_practo_home_page() {
		BaseClass.getLogger().info("Practo Home page....");
		System.out.println("User navigated to the practo Website..........");
	    
	}
	//method to navigate to parcto home page
	@Then("user validates the practo home page title")
	public void user_validates_the_practo_home_page_title() {
		findDoctorsPage.homepageValidate();
		BaseClass.getLogger().info("Validates the practo page");
		System.out.println("User navigated is at practo home page");
	}
	//method to click on find doctors
	@When("user clicks on find doctors")
	public void user_clicks_on_find_doctors() throws InterruptedException {
		findDoctorsPage.clickOnFindDoctors();
		BaseClass.getLogger().info("Clicks on find doctors....");
		System.out.println("Clicks on find doctors....");
	}
	//method to select location
	@When("user selects location feild")
	public void user_selects_location_feild() throws InterruptedException, IOException {
		findDoctorsPage.clickOnLocationTextBox();
		String actualText = BaseClass.getProperties().getProperty("location");
		findDoctorsPage.sendValueIntoLocationTextBox(actualText);
		findDoctorsPage.clickOnLocation();
		BaseClass.getLogger().info("selects the location....");
		System.out.println("User selected the location.........");
	}
	//method to select specialist
	@When("user selects specialist feild")
	public void user_selects_specialist_feild() throws IOException, InterruptedException {
		findDoctorsPage.clickOnSpecialistTextBox();
		String actualText = BaseClass.getProperties().getProperty("specialist");
		findDoctorsPage.sendValueIntoSpecialistTextBox(actualText);
		findDoctorsPage.clickOnSpecialist();
		BaseClass.getLogger().info("selects the specialist....");
		System.out.println("User Selected the Specialist.......");
	}
	//method to apply filters for patient stories feild
	@When("user applies filters for patient stories feild")
	public void user_applies_filters_for_patient_stories_feild() throws InterruptedException {
		findDoctorsPage.clickOnPatientStories();
		int limit = findDoctorsPage.listOfPatientStories();
		int randomIndex = BaseClass.getRandomIndex(limit);
		findDoctorsPage.selectPatientStories(randomIndex);
		BaseClass.getLogger().info("Applied filter for patient stories dropdown....."); 
		System.out.println("Applied filter for patient stories dropdown.....");
	}
	//method to apply filters for experience feild
	@When("user applies filters for experience feild")
	public void user_applies_filters_for_experience_feild() throws InterruptedException {
		findDoctorsPage.clickOnExperience();
		//TimeUnit.SECONDS.sleep(2);
		int limit = findDoctorsPage.listOfExperience();
		int randomIndex = BaseClass.getRandomIndex(limit);
		findDoctorsPage.selectExperience(randomIndex);
		TimeUnit.SECONDS.sleep(2);
		findDoctorsPage.clickOnExperience();
		findDoctorsPage.clickOnExperience();
		BaseClass.getLogger().info("Applied filter for experience field....."); 
		System.out.println("Applied filter for experience field.....");
	}
	//method to apply filters for fee feild
	@When("user applies filters for fee feild")
	public void user_applies_filters_for_fee_feild() throws InterruptedException {
		findDoctorsPage.clickOnAllFilteres();
		int limit = findDoctorsPage.listOfFee();
		int randomIndex = BaseClass.getRandomIndex(limit);
		findDoctorsPage.selectFee(randomIndex);
		BaseClass.getLogger().info("Applied filter for fee field.....");  
		System.out.println("Applied filter for fee field.....");
	}

	//method to apply filters for availability feild
	@When("user applies filters for availability feild")
	public void user_applies_filters_for_availability_feild() throws InterruptedException {
		findDoctorsPage.clickOnAllFilteres();
		int limit = findDoctorsPage.listOfAvailable();
		int randomIndex = BaseClass.getRandomIndex(limit);
		findDoctorsPage.selectAvailable(randomIndex);
		BaseClass.getLogger().info("Applied filter for availability field.....");
		System.out.println("Applied filter for availability field.....");
	   
	}
	////method to apply filters sort feild
	@When("user applies filters for sort feild")
	public void user_applies_filters_for_sort_feild() throws InterruptedException {
		findDoctorsPage.clickOnSort();
		int limit = findDoctorsPage.listOfSort();
		int randomIndex = BaseClass.getRandomIndex(limit);
		findDoctorsPage.selectSort(randomIndex);
		BaseClass.getLogger().info("Applied filter for availability field.....");
		System.out.println("Applied filter for sort field.....");
	    
	}
	//method to print doctors details
	@Then("user stores the top five doctors in a list and prints their detials")
	public void user_stores_the_top_five_doctors_in_a_list_and_prints_their_detials() throws IOException {
		String[] textArray = findDoctorsPage.getTextFormElements();
		int numOfDoc = findDoctorsPage.nod();
		int r=1;
		ExcelUtility.clearExcel("DoctorDetails");
		ExcelUtility.setCellData("DoctorDetails", 0, 0, "Doctor Details");
		ExcelUtility.fillGreenColor("DoctorDetails", 0, 0);
		if(numOfDoc>=5) {
			for(int i=0; i<5; i++) {
				System.out.println("-------------------------------------------------");
				System.out.println(textArray[i]);
				ExcelUtility.setCellData("DoctorDetails", r, 0,textArray[i] );
				r+=1;
			}
		}else {
			for(int i=0; i<numOfDoc; i++) {
				System.out.println("-------------------------------------------------");
				System.out.println(textArray[i]);
				ExcelUtility.setCellData("DoctorDetails", r, 0,textArray[i] );
				r+=1;
			}
			
		}
		
		BaseClass.getLogger().info("Stored first five doctor details.....");
	}
	
	
	
	
	
	


}
