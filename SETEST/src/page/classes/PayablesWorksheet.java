package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayablesWorksheet {
	public static WebElement element = null;
	
	
	 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	 
	 public static WebElement addnew(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Add New']")); 
		  return element;
	  }
	  
	 public static void AddNewPaymentClick(WebDriver driver){
		  element = addnew(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static Select payeetype(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='payee_type']"));
		    element = new Select(element_dropdown);  
	        return element;     
	  }
	 
	 public static Select payto(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='payee_uid']"));
		    element = new Select(element_dropdown);  
	        return element;     
	  }
	 
	 public static Select remitmethod(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='remit_method']"));
		    element = new Select(element_dropdown);  
	        return element;     
	  }
	 
	 public static Select service(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='serv_uid']"));
		    element = new Select(element_dropdown);  
	        return element ;
	  }

	  public static Select debitaccount(WebDriver driver)  { 
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@id='debit_acct_uid_1_ppd']"));
		    element = new Select(element_dropdown);  
	        return element ;
	  }
	 
	 
	
	 
	
	 public static WebElement authdate(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='authorized_date_1_ppd']")); 
		  return element;
	  }
	  	 
	 public static void AuthDateClick(WebDriver driver) {
		   element = authdate(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static WebElement authrefnbr(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='auth_reference_nbr_1_ppd']")); 
		  return element;
	  }
	  	 
	 public static WebElement authamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='orig_authorized_amount_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement authprogamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='authorized_amount_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement authfinal(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='authorized_amount_final_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement submitdate(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='invoice_date_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement submitfinancialdate(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='invoice_financial_date_1_ppd']")); 
		  return element;
	  }
	  	 
	 public static void SubmitDateClick(WebDriver driver) {
		   element = submitdate(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
 	 
	 public static void SubmitFinancialDateClick(WebDriver driver) {
		   element = submitfinancialdate(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static WebElement submitrefnbr(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='invoice_nbr_1_ppd']")); 
		  return element;
	  }
	  	 
	 public static WebElement submitamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='orig_invoice_amount_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement submitprogamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='invoice_amount_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement submithfinal(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='invoice_amount_final_1_ppd']")); 
		  return element;
	  }
	
	 public static WebElement paiddate(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='paid_date_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement paidfinancialdate(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='paid_financial_date_1_ppd']")); 
		  return element;
	  }
	  	 
	 public static void PaidDateClick(WebDriver driver) {
		   element = paiddate(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	 public static void PaidFinancialDateClick(WebDriver driver) {
		   element = paidfinancialdate(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	  	 
	 public static WebElement paidamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='orig_paid_amount_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement paidprogamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='paid_amount_1_ppd']")); 
		  return element;
	  }
	 
	
	 public static WebElement bankamount(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='bank_amount_1_ppd']")); 
		  return element;
	  }
	 
	 public static WebElement paidfinal(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='paid_amount_final_1_ppd']")); 
		  return element;
	  }
	 
	 
	 public static WebElement save(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[@id=\"did_scp_save\"]")); 
		  return element;
	  }
	
	
	 public static void SaveClick(WebDriver driver) {
		   element = save(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}

}
