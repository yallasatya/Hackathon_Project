package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjectClasses.FindDoctorsPage;
import pageObjectClasses.SurgeriesPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class Tc_02_Surgeries {
	
	
	SurgeriesPage surgeriesPageObject = new SurgeriesPage(BaseClass.getDriver());
	//method to click on surgeries
	@Given("user clicks on the surgeries")
	public void user_clicks_on_the_surgeries() throws InterruptedException {
		surgeriesPageObject.clicksOnSurgeries();
		BaseClass.getLogger().info("User is in Surgeries page......");
		System.out.println("User is in Surgeries page......");
		surgeriesPageObject.scrollToSurgeries();
		 
	}
	//method to extract doctor details and print them into excel
	@Then("user extracts and stores the list of surgeries names and prints them in a list")
	public void user_extracts_and_stores_the_list_of_surgeries_names_and_prints_them_in_a_list() throws IOException, InterruptedException {
		String[] textArray = surgeriesPageObject.getSurgeryText();
		int r=1;
		ExcelUtility.setCellData("SurgeryDetails", 0, 0, "List Of Surgeries");
		ExcelUtility.fillGreenColor("SurgeryDetails", 0, 0);
		int noS = surgeriesPageObject.noSurgeries();
		System.out.println("Available Surgeries............");
		for(int i=0 ; i<noS; i++) {
			System.out.println(textArray[i]);
			ExcelUtility.setCellData("SurgeryDetails", r, 0,textArray[i] );
			r+=1;	
		}
		
		BaseClass.getLogger().info("user extracted and stored the list of surgeries names......");
		surgeriesPageObject.scrollUp();

	}

}
