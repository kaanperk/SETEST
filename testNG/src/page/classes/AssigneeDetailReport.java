package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssigneeDetailReport {
	public static WebElement element = null;

	 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	

	
	
	  public static WebElement ReportsFldr(WebDriver driver){ element =
	  driver.findElement(By.xpath("//div[contains(@id,'cpfolder_8')]"));
	   return
	  element; }
	 
	 
	/*
	 * public static void ReportsFldrClick(WebDriver driver) { element =
	 * driver.findElement(By.xpath("//div[contains(@id,'cpfolder_8')]"));
	 * waitForElementToBeClickable(driver,element,5); element.click(); }
	 */	 
	 public static WebElement ClientSpecific(WebDriver driver){
		  element = driver.findElement(By.xpath("(//td[@class='handtext'][contains(.,'Client Specific')])[1]")); 
		  return element;
	  }
	 public static void ClientSpecificClick(WebDriver driver) {
		   element = ClientSpecific(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}

	 public static WebElement Asgne3MDetailRept(WebDriver driver){
		  element = driver.findElement(By.xpath("//a[contains(.,'3M Assignee Detail')]")); 
		  return element;
	  }
	 
	 public static void Asgne3MDetailReptClick(WebDriver driver) {
		   element = Asgne3MDetailRept(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}

	 public static Select DateCriteria(WebDriver driver){ 
		  Select element = null;
		  WebElement datecriteria_dropdown =  driver.findElement(By.xpath("//select[@id='crit_DateRange']"));
		    element = new Select(datecriteria_dropdown);  
	        return element;     
	  }
	 
	 public static Select DateType(WebDriver driver){ 
		  Select element = null;
		  WebElement datetype_dropdown = driver.findElement(By.xpath("//select[@id='crit_DateType']"));
		    element = new Select(datetype_dropdown);  
	        return element;     
	  }
	 
	 public static WebElement Preview(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Preview']")); 
		  return element;
	  }
	 
	 public static void PreviewClick(WebDriver driver) {
		   element = Preview(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static WebElement PreviewClose(WebDriver driver){
		  element = driver.findElement(By.xpath("//a[@id='did_modbox_closer_1']")); 
		  return element;
	  }
	 
	 public static void PreviewCloseClick(WebDriver driver) {
		   element = PreviewClose(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 public static WebElement Export(WebDriver driver){
		  element = driver.findElement(By.xpath(" //input[@value='Export']")); 
		  return element;
	  }
	 
	 public static void ExportClick(WebDriver driver) {
		   element = Export(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
    
       
}



