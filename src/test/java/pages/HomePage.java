package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;


public class HomePage extends TestBase {
	@FindBy(xpath="//li/a[contains(text(),'Home')]")
	WebElement homebtn;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement addtocart;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> items;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement viewcart;
	
	WebDriverWait wait;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void search(String product)

	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		
		homebtn.click();
		
		WebElement itemlist= driver.findElement(By.linkText(product));
		itemlist.click();
		 addtocart.click();
		 wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();		  
		  alert.accept();
	}
	
	public void GoTOCart()
	{
		viewcart.click();
	}
}
