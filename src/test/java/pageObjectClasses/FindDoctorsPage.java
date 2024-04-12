package pageObjectClasses;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testBase.BaseClass;
import utilities.ExcelUtility;

public class FindDoctorsPage extends BasePage{
	
	
	public FindDoctorsPage(WebDriver driver) {
		super(driver);	
	}
	
	public static int getRandomIndex(int limit) {
		Random r = new Random();
		int randomIndex = r.nextInt(limit);
		return randomIndex;
	}
	//Locators
	@FindBy(xpath = "//div[text()='Find Doctors']")
	WebElement finddoctors;
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-locality']")
	WebElement searchLocation;
	@FindBy(xpath = "//div[@class='c-omni-suggestion-item__content__title'][1]")
	WebElement locationDropDown;
	
	@FindBy(xpath ="//input[@data-qa-id='omni-searchbox-keyword']") 
	WebElement searchSpecialist;
	@FindBy(xpath = "//div[@class='c-omni-suggestion-item__content__title'][1]") 
	WebElement specialists;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientStories;
	@FindBy(xpath="//ul[@role='listbox'][@data-qa-id='doctor_review_count_list']//li")
	List<WebElement> patientStoriesList;
	
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']")
	WebElement experience;
	@FindBy(xpath="//ul[@role='listbox'][@data-qa-id='years_of_experience_list']//li")
	List<WebElement> experienceList;
	
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']")
	WebElement sort;
	@FindBy(xpath="//ul[@role='listbox'][@data-qa-id='sort_by_list']//li")
	List<WebElement> sortList;
	
	/*@FindBy(xpath="//span[text()='All Filters']")
	WebElement allFilters;*/
	@FindBy(xpath="//div[@data-qa-id='Fees_radio']")
	List<WebElement> fees ;
	@FindBy(xpath="//div[@data-qa-id='Availability_radio']")
	List<WebElement> available ;
	
	@FindBy(xpath = "//span[@class='u-spacer--right-thin']")
	WebElement allfilters;
	@FindBy(xpath = "//label[@class='u-c-pointer u-d-block c-filter__label']//span/span")
	List<WebElement> allfilterslist;
	
	@FindBy(xpath = "//div[@class='info-section']")
	List<WebElement> doctorprofile;

	//Action methods
		//user validates the practo home page title
		public void homepageValidate() {
			String homepagetitle = driver.getTitle();		//gets the title of the homepage
			System.out.println("Title of the homepage is : " + homepagetitle);		//prints the title of the homepage on console
			String homepage="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";		//stores the title in a variable
			if(homepagetitle.contains(homepage)) {
				Assert.assertTrue(true);
			}else {
				Assert.fail();
			}
		}
		
		//Method to click on find doctors
		public void clickOnFindDoctors() throws InterruptedException {
			finddoctors.click();
			TimeUnit.SECONDS.sleep(1);
		}
		//method to click on location text box
		public void clickOnLocationTextBox() throws InterruptedException {
			searchLocation.click();
			searchLocation.clear();
			TimeUnit.SECONDS.sleep(2);
		}
		//Method to send Value Into Location TextBox
		public void sendValueIntoLocationTextBox(String value) throws InterruptedException {
			searchLocation.sendKeys(value);
			TimeUnit.SECONDS.sleep(3);
		}
		// Method to click On Location
		public void clickOnLocation() {
			locationDropDown.click();
			
		}
		//Method to click On Specialist
		public void clickOnSpecialistTextBox() {
			searchSpecialist.click();
		}
		//Method to send Value Into Specialist TextBox
		public void sendValueIntoSpecialistTextBox(String value) throws InterruptedException {
			searchSpecialist.sendKeys(value);
			TimeUnit.SECONDS.sleep(3);
		}
		//Method to select Specialist
		public void clickOnSpecialist() {
			specialists.click();
		}
		
		//Method to click on patient stories
		public void clickOnPatientStories() throws InterruptedException {
			patientStories.click();
			TimeUnit.SECONDS.sleep(2);
		}
		//Method to find total no of patient stories
		public int listOfPatientStories() {
			int limit = patientStoriesList.size();
			return limit;
		}
		//method to select patient stories 
		public void selectPatientStories(int randomIndex) {
			patientStoriesList.get(randomIndex).click();
			
		}
		//Method to click on Experience
		public void clickOnExperience() throws InterruptedException {
			experience.click();
			//TimeUnit.SECONDS.sleep(2);
		}
		//Method to find total no of experience list
		public int listOfExperience() {
			int limit = experienceList.size();
			return limit;	
		}
		//method to select years of experience 
		public void selectExperience(int randomIndex) throws InterruptedException {
			experienceList.get(randomIndex).click();
			TimeUnit.SECONDS.sleep(1);
			//experience.click();
		}
		//Method to click on all filters
		public void clickOnAllFilteres() throws InterruptedException {
			allfilters.click();
			TimeUnit.SECONDS.sleep(2);
		}
		//Method to find total no of fee list
		public int listOfFee() {
			int limit = fees.size();
			return limit;
		}
		//method to select fee range 
		public void selectFee(int randomIndex) throws InterruptedException {
			fees.get(randomIndex).click();
			TimeUnit.SECONDS.sleep(1);
			
		}
		// method to find to number of available list
		public int listOfAvailable() {
			int limit = available.size();
			return limit;
		}
		//method to select available filter 
		public void selectAvailable(int randomIndex) throws InterruptedException {
			available.get(randomIndex).click();
			TimeUnit.SECONDS.sleep(1);
		}
		//method to click on sort
		public void clickOnSort() throws InterruptedException {
			sort.click();
			TimeUnit.SECONDS.sleep(1);
		}
		//method to get number of sort
		public int listOfSort() {
			int limit = sortList.size();
			return limit;	
		}
		//method to select sort
		public void selectSort(int randomIndex) throws InterruptedException {
			sortList.get(randomIndex).click();
			TimeUnit.SECONDS.sleep(3);
			
		}
		//method to get no of doctors
		public int nod() {
			int nod = doctorprofile.size();
			return nod;
		}
		//method to get doctor info
		public String[] getTextFormElements() {
			String[] textArray = new String[doctorprofile.size()];
				
			//String[] textArray = new String[5];
			for(int i=0;i<doctorprofile.size();i++) {
				textArray[i] = doctorprofile.get(i).getText();	
			}
			return textArray;	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
