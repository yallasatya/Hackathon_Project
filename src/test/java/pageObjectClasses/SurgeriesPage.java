package pageObjectClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class SurgeriesPage extends BasePage{

	public SurgeriesPage(WebDriver driver) {
		super(driver);
	}
	//locators
	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Surgeries']")
	WebElement surgeries;
	
	@FindBy(xpath = "//p[normalize-space()='Piles']")
	WebElement scroll;
	
	
	@FindBy(xpath = "//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeriesname;
	
	@FindBy(xpath="//span[@class='nav-interact']")
	WebElement for_Corp;
	
	@FindBy(xpath= "//a[normalize-space()='Health & Wellness Plans']")
	WebElement health;
	
	//Action Methods
	//user clicks on surgeries
	public void clicksOnSurgeries() throws InterruptedException {
		surgeries.click();
		TimeUnit.SECONDS.sleep(3);	
	}
	// method to scroll to the surgeries
	public void scrollToSurgeries() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		TimeUnit.SECONDS.sleep(3);
		
	}
	
	//user extracts and stores the list of surgery names and prints them in a list
	public void listOfSurgeries() throws IOException, InterruptedException {
		System.out.println("----------------Surgeries------------------");
		List<String> data=new ArrayList<String> ();
		System.out.println("Total no of surgeries elements : " + surgeriesname.size());
		int r=1;
		ExcelUtility.setCellData("SurgeryDetails", 0, 0, "List Of Surgeries");
		ExcelUtility.fillGreenColor("SurgeryDetails", 0, 0);
		for(int i=0;i<surgeriesname.size();i++) {
			String list=surgeriesname.get(i).getText();
			System.out.println("Surgeries are : " +list);
			data.add(list);
			ExcelUtility.setCellData("SurgeryDetails", r, 0, list);
			r+=1;
		}
		System.out.println("List of surgeries are : " +data);
		TimeUnit.SECONDS.sleep(2);
	}
	//method to get number of surgeries
	public int noSurgeries() {
		int nos = surgeriesname.size();
		return nos;
	}
	// method to get text of suegeries
	public String[] getSurgeryText() {
		String[] textArray = new String[surgeriesname.size()];
		for(int i=0;i<surgeriesname.size();i++) {
			textArray[i] = surgeriesname.get(i).getText();	
		}
		return textArray;
	}

	
	//Scroll to the for corporate
	public void scrollUp() throws InterruptedException {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",for_Corp);
		TimeUnit.SECONDS.sleep(2);
		
	}
	
	//click on forCorporates
	public void clickOnForCorporates() throws InterruptedException {
		for_Corp.click();
		TimeUnit.SECONDS.sleep(3);
		health.click();
		
		
	}
}
