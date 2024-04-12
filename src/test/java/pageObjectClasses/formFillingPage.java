package pageObjectClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;

public class formFillingPage extends BasePage{
	
	public formFillingPage(WebDriver driver) {
		super(driver);
	}
	//locators
	@FindBy(xpath="//span[@class='nav-interact']")
	WebElement for_Corp;
	
	@FindBy(xpath= "//a[normalize-space()='Health & Wellness Plans']")
	WebElement health;
	
	@FindBy(xpath="(//input[@name='name'])[1]")
	public WebElement name;
	
	@FindBy(xpath="(//input[@id='organizationName'])[1]")
	public WebElement organizationName;
	
	@FindBy(xpath="(//input[@id='contactNumber'])[1]")
	public WebElement contactNumber;
	
	@FindBy(xpath="(//input[@id='officialEmailId'])[1]")
	public WebElement email;
	
	@FindBy(xpath="(//select[@id='organizationSize'])[1]")
	public WebElement org_size;
	
	@FindBy(xpath="(//select[@id='interestedIn'])[1]")
	public WebElement interest;
	
	@FindBy(xpath="(//button[text()='Schedule a demo'])[1]")
	public WebElement button ;
	
	@FindBy(xpath="(//div[@class='u-text--bold text-alpha'])[1]")
	public WebElement thankyou;


	//Action methods
	//click on forCorporates
		public void clickOnForCorporates() throws InterruptedException {
			for_Corp.click();
			TimeUnit.SECONDS.sleep(1);
			health.click();
		}
	
		//selects "1001-5000" from the dropdown
		public void select_org_size() {
			Select sel= new Select(org_size);
			sel.selectByValue("1001-5000");
		}
		//selects the Taking a demo from dropdown
		public void select_interest() throws InterruptedException {
			Select sel= new Select(interest);
			sel.selectByValue("Taking a demo");
			TimeUnit.SECONDS.sleep(2);
			
		}
		//Method to click on Schedule button
		public void clickButton() throws InterruptedException {
			TimeUnit.SECONDS.sleep(3);
			button.click();
		 }
		//method to send text into the name text box
		public void sendValueIntonameTextBox(String value) throws InterruptedException {
			name.sendKeys(value);
			TimeUnit.SECONDS.sleep(1);
		}
		//method to send text into the organization name text box
		public void sendValueIntoOrganizationnameTextBox(String value) throws InterruptedException {
			organizationName.sendKeys(value);
			TimeUnit.SECONDS.sleep(1);
		}
		//method to send text into the email text box
		public void sendValueIntoEmailTextBox(String value) throws InterruptedException {
			email.sendKeys(value);
			TimeUnit.SECONDS.sleep(1);
		}
		//method to send text into the phone text box
		public void sendValueIntoPhoneTextBox(String value) throws InterruptedException {
			contactNumber.sendKeys(value);
			TimeUnit.SECONDS.sleep(1);
		}
		
		
		public void refresh() throws InterruptedException {
			driver.navigate().refresh();
			TimeUnit.SECONDS.sleep(3);	
		}
		//method to check that thank you is displayed or not
		public boolean thankYouMessage() {
			if(thankyou.isDisplayed())
			{
				return true;
			}
			else
				return false;
		}
		//method to check that thank you is displayed or not
		public void isThankYouMessageDisplayed() throws InterruptedException {
			TimeUnit.SECONDS.sleep(3);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(thankyou));
		}

		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
