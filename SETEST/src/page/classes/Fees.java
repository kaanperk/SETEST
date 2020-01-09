package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fees {
	public static WebElement element = null;
	
	
	 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	 
	 public static WebElement addnewfee(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Add New']")); 
		  return element;
	  }
	  
	 public static void AddNewFeeClick(WebDriver driver){
		  element = addnewfee(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement feename(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='fee_name']")); 
		  return element;
	  }
	 
	 public static WebElement feeDRacct(WebDriver driver){
		    element = driver.findElement(By.xpath("//input[@id='DebitAccount_TextBoxMaster']")); 
	        return element;     
	   }
	 
	 public static void FeeDRacctClick(WebDriver driver){
		  element = feeDRacct(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement DR1020(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[@id='DebitAccount_0']")); 
		  return element;
	  }
	 public static void DR1020Click(WebDriver driver){
		  element = DR1020(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 public static WebElement feeCRacct(WebDriver driver){
		    element = driver.findElement(By.xpath("//input[@id='CreditAccount_TextBoxMaster']")); 
	        return element;     
	   }
	 
	 public static void FeeCRacctClick(WebDriver driver){
		  element = feeCRacct(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 public static WebElement CR20000(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[@id='CreditAccount_0']")); 
		  return element;
	  }
	 public static void CR20000Click(WebDriver driver){
		  element = CR20000(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 

	 
	
	 
	

	 public static WebElement feeamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='fee_amount']")); 
		  return element;
	  }
	 
	 
	 public static WebElement feepostnow(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Post Now']")); 
		  return element;
	  }
	 
	 public static void PostNowClick(WebDriver driver){
		  element = feepostnow(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }

}