package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.LoginPage;
import page.classes.ClientSearch;
import page.classes.ClientInvoice;


public class ClientAddInvoice {
	private WebDriver driver;
	public static Properties prop;

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
	
		public boolean isAlertPresent() {
			try {
				driver.switchTo().alert();
				return true;
			} // try
			catch (Exception e) {
				return false;
			} // catch
		}

	
	

	
	public void initialization() throws InterruptedException {
		try {
			prop = new Properties();
			FileInputStream ip=new FileInputStream("/Users/avl7353/eclipse-workspace/Automation/src/page/classes/config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String browsername = prop.getProperty("browser");
		if (browsername.contentEquals("chrome")) {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver",
					prop.getProperty("chromedriverpath"));

			driver = new ChromeDriver();
		} else if (browsername.contentEquals("ff")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
			driver = new FirefoxDriver();
		} else if (browsername.contentEquals("IE")) {
		//	System.setProperty("webdriver.ie.driver", "C:\\Users\\avl7353\\eclipse-workspace\\IEDriverServer.exe");
		//	driver = new InternetExplorerDriver();
			
			//USE IE 32 bit driver ---   ISSUES WITH IE 64BIT//
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEdriverpath"));
			driver = new InternetExplorerDriver();
		
		}  		
		
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
//		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		LoginPage.userid(driver).clear();
		LoginPage.passwd(driver).clear();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test	
 public void test() throws Exception {	
		initialization();

		LoginPage.userid(driver).sendKeys(prop.getProperty("username"));
		LoginPage.userid(driver).sendKeys(Keys.TAB);
		LoginPage.passwd(driver).clear();
		LoginPage.passwd(driver).sendKeys(prop.getProperty("password"));
		LoginPage.passwd(driver).sendKeys(Keys.TAB);
		LoginPage.loginbutton(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
        Thread.sleep(20000);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		  if
		  (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		  driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 
		 
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
         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
         
         
         
	}
      

	@After
	public void teardown() throws Exception {
		 //driver.quit();
	}

}
         
         
         
     