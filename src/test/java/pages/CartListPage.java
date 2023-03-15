package pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class CartListPage extends TestBase{
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	public WebElement placeorderbtn;
	
	@FindBy(xpath="(//button/span[text()='×'])[3]")
	public WebElement close;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement namebox;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement countrybox;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement citybox;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement cardbox;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement monthbox;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement yearbox;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchasebtn;
	
//	@FindBy(xpath="(//h2)[3]")
//	public WebElement verify;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement accept;
	
	WebDriverWait wait;
	
	public CartListPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void confirmorder() throws InterruptedException
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		placeorderbtn.click();
		Thread.sleep(2000);
		namebox.sendKeys("Suba");		
		countrybox.sendKeys("India");
		citybox.sendKeys("Tirunelveli");
		cardbox.sendKeys("846924280");
		monthbox.sendKeys("July");
		yearbox.sendKeys("2020");
		Thread.sleep(3000);
		purchasebtn.click();
		Thread.sleep(2000);
		accept.click();
		
		
		
	}
	

}


