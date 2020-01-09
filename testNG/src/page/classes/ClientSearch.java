package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientSearch {
	public static WebElement element = null;
	

	 
	 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	
	 public static WebElement clientfldr(WebDriver driver){
		  element = driver.findElement(By.xpath("//span[@name='modText2']"));
		  return element;
	  }
	 
	 public static void ClientFldrClick(WebDriver driver){
		  element = clientfldr(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	
	 public static WebElement clientname(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='org_name']"));
		  return element;
	  }
	 
	 public static WebElement clientnbr(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='org_numb']"));
		  return element;
	  }
	 
	 public static WebElement search(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Search']"));
		  return element;
	  }
	 
	
	 public static void SrchClick(WebDriver driver){
		  element = search(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	
	 
	 public static WebElement clientsrchresult20th(WebDriver driver){
		  element = driver.findElement(By.xpath("//a[contains(.,'20th Century Fox Film Corporation')]"));
		  return element;
	  }
	 
	
	 public static void ClientresultClick20th(WebDriver driver){
		  element = clientsrchresult20th(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 
	 }