package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.ExistingAssignee;
import page.classes.PayablesWorksheet;
import page.classes.LoginPage;
import page.classes.SearchPage;

public class AddPayment {
	private WebDriver driver;
	private String baseUrl;

	public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));

		return element;
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

		return element;
	}

	public void takeScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/Add-Payment/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
			
			
		}
	}

	@Before
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://setstgen.sirvarelocation.com";
		driver.manage().window().maximize();

	}
	
	
	  public boolean isAlertPresent() {
			 try {
			 driver.switchTo().alert();
			 return true;
			 }// try
			 catch (Exception e) {
			 return false;
			 }// catch
			 }

	@Test	
 public void test() throws Exception {	
	driver.get(baseUrl);
	Thread.sleep(2000);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	/**LOGIN **/
	LoginPage.userid(driver).sendKeys("kaan.perk@sirva.com");
	LoginPage.passwd(driver).sendKeys("Dec321@@");
	LoginPage.login(driver);
 WebDriverWait wait = new WebDriverWait(driver,3);
 Thread.sleep(25000);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		/*
		 * if
		 * (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		 * driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 */
		 
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"did_appframe\"]")));
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
		  takeScreenshot(driver,"1.Homepage");
		  SearchPage.AsgneFldrClick(driver); 
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame(); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
	 /**SEARCH ASSIGNEE**/	  
		  SearchPage.statusACTIVE(driver); 
		  SearchPage.AdvancedSearchClick(driver);
		  SearchPage.clientname(driver).sendKeys("20");
		  takeScreenshot(driver,"2.Search by client");	
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns")); 
		  SearchPage.SearchClick(driver);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		  driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_bottom")); 
		  Thread.sleep(1500);
		  takeScreenshot(driver,"3.Search results");	
		  driver.findElement(By.xpath("//*[@id=\"did_results\"]/form/table/tbody/tr[2]/td[1]/a")).click();
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	/**ASSIGNEE PROFILE**/	  
		
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
          if (isAlertPresent()) {
 			 driver.switchTo().alert().accept();
 			 }
          Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	      driver.switchTo().defaultContent();
	  	(new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));
		Thread.sleep(1500);
		  takeScreenshot(driver,"4.Assignee Profile");		
          ExistingAssignee.ProgramTitleClick(driver);
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_task_gadget_iframe"));
          ExistingAssignee.PaymentsClick(driver);
          driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("criteria_frame")); 
          PayablesWorksheet.AddNewPaymentClick(driver);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          PayablesWorksheet.payeetype(driver).selectByVisibleText("Individual");
          Thread.sleep(3000);
          PayablesWorksheet.payto(driver).selectByIndex(2);
          Thread.sleep(1500);
          PayablesWorksheet.remitmethod(driver).selectByVisibleText("Check");
          PayablesWorksheet.service(driver).selectByIndex(1);
          (new WebDriverWait(driver, 2))
          .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
          			"//input[@name='debit_acct_uid_1_ppd_ufd']"))); 
         driver.findElement(By.xpath("//input[@name='debit_acct_uid_1_ppd_ufd']")).clear();
         driver.findElement(By.xpath("//input[@name='debit_acct_uid_1_ppd_ufd']")).sendKeys("1010 - Lump Sum");
         PayablesWorksheet.AuthDateClick(driver);
         PayablesWorksheet.authdate(driver).sendKeys(Keys.ESCAPE);
         PayablesWorksheet.authrefnbr(driver).sendKeys("test authref nbr");
          Thread.sleep(1000);
          PayablesWorksheet.authamount(driver).isEnabled();
          PayablesWorksheet.authamount(driver).clear();
          Thread.sleep(1000);
          PayablesWorksheet.authamount(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"100");
          PayablesWorksheet.authprogamount(driver).click();
          PayablesWorksheet.authfinal(driver).click();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
	         PayablesWorksheet.SaveClick(driver);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	         driver.switchTo().defaultContent();
	         if (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
	        	Thread.sleep(1500);
	        	 takeScreenshot(driver,"5.PO Authorized-Confirm");
	       	  driver.findElement(By.xpath("//input[@value='Yes']")).click(); 
	       	  }
	         Thread.sleep(3500);
	         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		  takeScreenshot(driver,"6.PO Authorized");
		  driver.switchTo().defaultContent();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          PayablesWorksheet.SubmitDateClick(driver);
          PayablesWorksheet.submitfinancialdate(driver).sendKeys("11/10/2019");
          PayablesWorksheet.submitrefnbr(driver).sendKeys("test submitref nbr");
          Thread.sleep(2000);
          PayablesWorksheet.submitamount(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"100");
          PayablesWorksheet.submitprogamount(driver).click();
          PayablesWorksheet.submithfinal(driver).click();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
	         PayablesWorksheet.SaveClick(driver);
	         driver.switchTo().defaultContent();
	         driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	         if (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
	        	 Thread.sleep(1500);
                 takeScreenshot(driver,"7.PO Invoiced-Confirm");
	       	  driver.findElement(By.xpath("//input[@value='Yes']")).click(); 
	       	  } 
	         Thread.sleep(3500);
	         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
	         takeScreenshot(driver,"8.PO INVOICED");
		  driver.switchTo().defaultContent();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          PayablesWorksheet.PaidDateClick(driver);
          PayablesWorksheet.paiddate(driver).sendKeys("11/10/2019");
          PayablesWorksheet.PaidFinancialDateClick(driver);
          PayablesWorksheet.paidfinancialdate(driver).sendKeys("11/10/2019");
          Thread.sleep(2000);
          PayablesWorksheet.paidamount(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"100");
          PayablesWorksheet.paidprogamount(driver).click();
          PayablesWorksheet.bankamount(driver).click();
          PayablesWorksheet.bankamount(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"100");
          PayablesWorksheet.paidfinal(driver).click();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
	         PayablesWorksheet.SaveClick(driver);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	         driver.switchTo().defaultContent();
	         if (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
	        	 Thread.sleep(1500);
                 takeScreenshot(driver,"9.PO Paid-Confirm");
		       	  driver.findElement(By.xpath("//input[@value='Yes']")).click(); 
		       	  }
	         Thread.sleep(3000);
	         driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
	          Thread.sleep(2000);
		  takeScreenshot(driver,"10.PO PAID");
		  
		 
	}
 

	@After
	public void teardown() throws Exception {
		// driver.quit();
	}

}
