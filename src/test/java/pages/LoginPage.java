package pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="login2")
	WebElement loginhome;
	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginbtn;
	
	@FindBy(xpath="//li/a[text()='Welcome Lijo']")
	public WebElement welcome;
	
	WebDriverWait wait;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass)
	
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		
		
		loginhome.click();
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbtn.click();
	}
}


