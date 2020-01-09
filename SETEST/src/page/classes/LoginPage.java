package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {
 public static WebElement element = null;
 
  public static WebElement userid(WebDriver driver){
	  element = driver.findElement(By.name("cont_sys_id"));
	  return element;
  }
 
  public static WebElement passwd(WebDriver driver){
	  element = driver.findElement(By.name("cont_password"));
	  return element;
  }
 
  public static WebElement loginbutton(WebDriver driver){
	  element =  driver.findElement(By.name("B1"));
	  return element;
  }

  public static void login(WebDriver driver) {
      element = loginbutton(driver);
      element.click();
  
  
}

}
  







