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
import page.classes.AssigneeDetailReport;

public class AssigneDetailReport3M{
	private WebDriver driver;
	public static Properties prop;

	public static WebElement waitForElementToBeVisible(WebDriver driver,WebElement webElement,int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
		
		return element;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		
		return element;
	}
	
	public void takeScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/AssigneeDetail3M/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
		}
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
						"C:\\Users\\avl7353\\eclipse-workspace\\alternateCHROME\\chromedriver.exe");

				driver = new ChromeDriver();
			} else if (browsername.contentEquals("ff")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\avl7353\\eclipse-workspace\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browsername.contentEquals("IE")) {
			//	System.setProperty("webdriver.ie.driver", "C:\\Users\\avl7353\\eclipse-workspace\\IEDriverServer.exe");
			//	driver = new InternetExplorerDriver();
				
				//USE IE 32 bit driver ---   ISSUES WITH IE 64BIT//
				System.setProperty("webdriver.ie.driver", "C:\\Users\\avl7353\\eclipse-workspace\\alternateIE\\IEDriverServer32.exe");
				driver = new InternetExplorerDriver();
			
			}  		
		    driver.manage().window().maximize();
		 //   driver.manage().deleteAllCookies();
//		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get(prop.getProperty("url"));
		    Thread.sleep(2000);
		    LoginPage.userid(driver).clear();
			LoginPage.passwd(driver).clear();
		 // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
 	  WebDriverWait wait = new WebDriverWait(driver,2);
 		 Thread.sleep(20000);
 		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		  if
		  (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		  driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 
		 
	     takeScreenshot(driver,"1.homepage");	
     driver.switchTo().parentFrame();
     driver.switchTo().parentFrame();
     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
     driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
       AssigneeDetailReport.ReportsFldr(driver).click();	 
       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
       driver.switchTo().parentFrame();
       driver.switchTo().parentFrame();
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
       AssigneeDetailReport.ClientSpecificClick(driver); 
       AssigneeDetailReport.Asgne3MDetailReptClick(driver);
       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
       driver.switchTo().defaultContent();
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rpt_criteria_fields"));
       AssigneeDetailReport.DateCriteria(driver).selectByValue("This Month");
       AssigneeDetailReport.DateType(driver).selectByValue("Date Received");
       takeScreenshot(driver,"2.Report Filter");	
       driver.switchTo().defaultContent();
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rpt_criteria_hdr"));
       AssigneeDetailReport.PreviewClick(driver);
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       driver.switchTo().defaultContent();
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
       Thread.sleep(5000);
       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_counter']")));
       WebElement tdcounterbot=driver.findElement(By.xpath("//td[@id='did_counter']"));
       String numberofrecords = tdcounterbot.getText();    
       String [] words = numberofrecords.split(" ",6);
       String resultset= words[4];  		   
       System.out.print("The number of records: "+ resultset);
       driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
       driver.switchTo().parentFrame();
       takeScreenshot(driver,"3.Preview");
      // wait.until(ExpectedConditions.titleContains("Report Preview"));
       AssigneeDetailReport.PreviewCloseClick(driver);
       driver.switchTo().defaultContent();
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rpt_criteria_hdr"));
       AssigneeDetailReport.ExportClick(driver);
       Thread.sleep(3000);
       takeScreenshot(driver,"4.Export");
   
     }
     
	
     @After
     public void teardown() throws Exception{
    	 //driver.quit(); 
     }
	
}


