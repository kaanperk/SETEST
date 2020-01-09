package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientInvoice {
	public static WebElement element = null;
	
	
	
	 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	 
	 
	 public static WebElement finance(WebDriver driver){
		  element = driver.findElement(By.xpath("//li[contains(.,'Finance')]")); 
		  return element;
	  }
	  
	 public static void FinanceClick(WebDriver driver){
		  element = finance(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	
	 
	 public static WebElement addinvoice(WebDriver driver){
		  element = driver.findElement(By.xpath("//td[contains(.,'Find/Add Invoice')]")); 
		  return element;
	  }
	  
	 public static void AddinvoiceClick(WebDriver driver){
		  element = addinvoice(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	
	 public static WebElement addnewinvoice(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Add New']")); 
		  return element;
	  }
	  
	 public static void AddNewInvoiceClick(WebDriver driver){
		  element = addnewinvoice(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement newinvoicesearch(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='Search']")); 
		  return element;
	  }
	  
	 public static void NewInvoiceSrchClick(WebDriver driver){
		  element = newinvoicesearch(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 
	 public static WebElement newinvoiceresult(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='cust_uid_1']")); 
		  return element;
	  }
	  
	 public static void NewInvoiceResultClick(WebDriver driver){
		  element = newinvoiceresult(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement OK(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='OK']")); 
		  return element;
	  }
	  
	 public static void OKClick(WebDriver driver){
		  element = OK(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement comments(WebDriver driver){
		  element = driver.findElement(By.xpath("(//textarea[@name='comment'])[2]")); 
		  return element;
	  }
	
	 
	 public static WebElement save(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Save']")); 
		  return element;
	  }
	  
	 public static void SaveClick(WebDriver driver){
		  element = save(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement send(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(.,'Send')]")); 
		  return element;
	  }
	  
	 public static void SendClick(WebDriver driver){
		  element = send(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }

	 
	 public static WebElement send2(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Send']")); 
		  return element;
	  }
	  
	 public static void Send2Click(WebDriver driver){
		  element = send2(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 


}