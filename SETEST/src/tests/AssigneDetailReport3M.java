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
import page.classes.AssigneeDetailReport;

public class AssigneDetailReport3M{
	WebDriver driver; 
	String baseURL = "http://setstgen.sirvarelocation.com/";;
	

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

	
    @Before
	public  void setup() throws Exception{
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
    	driver = new ChromeDriver();	
		driver.manage().window().maximize();
	}

     @Test	
	public void test() throws Exception {
	     driver.get(baseURL);
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
       driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_counter']")));
       WebElement tdcounterbot=driver.findElement(By.xpath("//td[@id='did_counter']"));
       String numberofrecords = tdcounterbot.getText();    
       String [] words = numberofrecords.split(" ",6);
       String resultset= words[4];  		   
       System.out.print("The number of records: "+ resultset);
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       driver.switchTo().parentFrame();
       takeScreenshot(driver,"3.Preview");
      // wait.until(ExpectedConditions.titleContains("Report Preview"));
       AssigneeDetailReport.PreviewCloseClick(driver);
       driver.switchTo().defaultContent();
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rpt_criteria_hdr"));
       AssigneeDetailReport.ExportClick(driver);
       takeScreenshot(driver,"4.Export");
   
     }
     
	
     @After
     public void teardown() throws Exception{
    	 //driver.quit(); 
     }
	
}


