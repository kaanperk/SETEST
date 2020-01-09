package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SearchPage {
 public static WebElement element = null;
  
 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		
		return element;
	}

 //Basic Search
  public static WebElement asgnefldr(WebDriver driver){
	  element = driver.findElement(By.xpath("//span[contains(.,'Assignee')]"));
	  return element;
  }
 
  public static WebElement lname(WebDriver driver){
	  element = driver.findElement(By.name("//input[@name='cust_lname']"));
	  return element;
  }
 
   
  public static Select status(WebDriver driver){
	   Select element = null;
	  WebElement element_dropdown =  driver.findElement(By.id("Select3"));
	    element = new Select(element_dropdown);  
       return element;
  }

  //Advanced Search 
  public static WebElement clientname(WebDriver driver){
	  element =  driver.findElement(By.name("cust_org_name"));
	  return element;
  }
  
  
  public static WebElement searchbutton(WebDriver driver){
	  element = driver.findElement(By.name("button1"));
	  return element;
  }
  
  
  public static  WebElement advancedsarchbutton(WebDriver driver) {
	  element =  driver.findElement(By.xpath("//a[contains(.,'Advanced Search')]"));
      return element;
}
   
 
  public static void AsgneFldrClick(WebDriver driver) {
	   element = asgnefldr(driver);
	   waitForElementToBeClickable(driver,element,3);
	   element.click();
}
  
  public static void statusINIT(WebDriver driver) {
	  Select element = status(driver);
	  element.selectByIndex(1);
  }
  
  public static void statusACTIVE(WebDriver driver) {
	  Select element = status(driver);
	  element.selectByVisibleText("Active");
  }
  
  public static void AdvancedSearchClick(WebDriver driver) {
	   element = advancedsarchbutton(driver);
	   element.click();
}
  
  public static void SearchClick(WebDriver driver) {
	   element = searchbutton(driver);
	   element.click();
}

} 