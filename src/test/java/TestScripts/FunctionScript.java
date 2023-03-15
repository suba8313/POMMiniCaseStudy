package TestScripts;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Base.TestBase;
import pages.CartListPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ViewCartPage;


public class FunctionScript extends TestBase{
	
	LoginPage loginpage;
	HomePage additem;
	ViewCartPage cartpage;
	CartListPage purchase;
	WebDriverWait wait;
	
	@BeforeTest
	public void startup()
	{
		initialize();
	}
	
	
	@Test(priority=1)
	public void purchase()
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("uname"), prop.getProperty("pass"));
		Assert.assertEquals(loginpage.welcome.getText(),"Welcome Lijo");			
	}
	
	@Test(dataProvider="item",priority=2)
	
	public void additem(String item)
	
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		additem= new HomePage();
		
		additem.search(item);
		additem.GoTOCart();
		wait.until(ExpectedConditions.visibilityOfAllElements(additem.items));
		boolean flag=false;
		for(WebElement itemlist: additem.items)
		  {
			  if(itemlist.getText().equalsIgnoreCase(item)) {
			  Assert.assertEquals(itemlist.getText(), item);
			  flag=true;
			  }			  
		  }
		Assert.assertTrue(flag);	  
	}

	@Test(priority=3)
	public void delete() throws InterruptedException
	{
		cartpage=new ViewCartPage();
		purchase=new CartListPage();
		boolean success= cartpage.delete();
	}
	
	@Test(priority=4)
	public void placeorder() throws InterruptedException 
	{
		purchase=new CartListPage();
		Thread.sleep(3000);
		purchase.confirmorder();
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));

		
	}
	
	 @DataProvider(name="item")
	  public Object[][] ProListCSV() throws CsvValidationException, IOException{
		  String path=System.getProperty("user.dir")+"//src//test//resources//Data//productlist.csv";
		  String[] cols;
		  CSVReader reader = new CSVReader(new FileReader(path));
		  ArrayList<Object> dataList=new ArrayList<Object>();
		  while((cols=reader.readNext())!=null)
		  {
			  Object[] record= {cols[0]};
			  dataList.add(record);
		  }
		  return dataList.toArray(new Object[dataList.size()][]);
		  
	  }
	
}
