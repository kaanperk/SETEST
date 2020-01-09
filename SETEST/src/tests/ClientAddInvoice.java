package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.LoginPage;
import page.classes.ClientSearch;
import page.classes.ClientInvoice;


public class ClientAddInvoice {
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
			FileUtils.copyFile(source, new File("./Screenshots/Add-Invoice/" + screenshotname + ".png"));
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
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		/*
		 * if
		 * (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		 * driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 */
		 
	(new WebDriverWait(driver, 2))
	  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
	(new WebDriverWait(driver, 2))
  .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='cp_display']")));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
		  takeScreenshot(driver,"1.Homepage");
		  Thread.sleep(1500);
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		  ClientSearch.ClientFldrClick(driver);
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame(); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
	 /**SEARCH Client**/	  
		  ClientSearch.clientname(driver).sendKeys("20th");
		  ClientSearch.clientnbr(driver).sendKeys("5014");
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns")); 
		  ClientSearch.SrchClick(driver);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		  driver.switchTo().parentFrame(); 
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='select_sort.aspx']")));
		  Thread.sleep(1500);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  ClientSearch.ClientresultClick20th(driver);
		  Thread.sleep(1500);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	/**Client PROFILE**/	  
	      driver.switchTo().defaultContent();
	  	(new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryDetails"));
		  takeScreenshot(driver,"2.Client Profile");
	     ClientInvoice.FinanceClick(driver);
	     Thread.sleep(1500);
	     driver.switchTo().defaultContent();	   
	     (new WebDriverWait(driver, 2))
		    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_task_gadget_iframe"));
         driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
         ClientInvoice.AddinvoiceClick(driver);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          Thread.sleep(1000);
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("criteria_frame")); 
          ClientInvoice.AddNewInvoiceClick(driver);
          Thread.sleep(1000);
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("criteria_frame")); 
         ClientInvoice.NewInvoiceSrchClick(driver);
         driver.switchTo().defaultContent();
         Thread.sleep(3000);
         driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("result_frame")); 
         takeScreenshot(driver,"3.Client New Invoices");
         ClientInvoice.NewInvoiceResultClick(driver); 
         ClientInvoice.OKClick(driver);
         Thread.sleep(3000);
	     driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	     driver.switchTo().defaultContent();
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
         Thread.sleep(1500);
         takeScreenshot(driver,"4.Invoice Worksheet");
         ClientInvoice.comments(driver).sendKeys("Invoice test comments");
         driver.switchTo().defaultContent();
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
         takeScreenshot(driver,"5.Invoice Worksheet Update");
         ClientInvoice.SaveClick(driver);
         Thread.sleep(3000);
         driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
         driver.switchTo().defaultContent();
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("menuBar"));
        
         
         
         
         ClientInvoice.SendClick(driver);
         Thread.sleep(1500);
         driver.switchTo().defaultContent();
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
         ClientInvoice.Send2Click(driver);
         Thread.sleep(1500);
         if (isAlertPresent()) {
        	 driver.switchTo().alert().dismiss();
         }
         Thread.sleep(4000);
         driver.switchTo().defaultContent();
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
         takeScreenshot(driver,"6.Invoice Billed");
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
         Thread.sleep(3000);
         ClientInvoice.comments(driver).sendKeys("Invoice test comments");
         
         
         
	}
      

	@After
	public void teardown() throws Exception {
		 //driver.quit();
	}

}
         
         
         
         
         
         
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * ClientInvoice.SendClick(driver); Thread.sleep(2000);
 * driver.switchTo().defaultContent();
 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
 * "did_dmode_frame_1"));
 * driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
 * ClientInvoice.Send2Click(driver); Thread.sleep(2000);
 * ClientInvoice.OKClick(driver); Thread.sleep(2000);
 * driver.switchTo().defaultContent();
 * 
 * takeScreenshot(driver,"6.Invoice Billed");
 * 
 * 
 * driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
 * 
 * 
 * 
 * }
 * 
 * 
 * @After public void teardown() throws Exception { //driver.quit(); }
 * 
 * }
 */