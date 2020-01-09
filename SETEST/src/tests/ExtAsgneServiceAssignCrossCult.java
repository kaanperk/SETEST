package tests;

import java.io.File;

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
import java.util.concurrent.TimeUnit;

import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.ExistingAssignee;

public class ExtAsgneServiceAssignCrossCult {
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
			FileUtils.copyFile(source, new File("./Screenshots/AssignCrossCultService/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
		}
	}

	@Before
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://setstgen.sirvarelocation.com";
		;
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
	Thread.sleep(1000);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	/**LOGIN **/
	LoginPage.userid(driver).sendKeys("kaan.perk@sirva.com");
	LoginPage.passwd(driver).sendKeys("Dec321@@");
	LoginPage.login(driver);
	 WebDriverWait wait = new WebDriverWait(driver,2);
	  Thread.sleep(35000);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		/*
		 * if
		 * (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		 * driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 */
 //    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='id_appframe']")));

	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	//  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='cp_display']")));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
		    takeScreenshot(driver,"1.homepage");
		  SearchPage.AsgneFldrClick(driver); 
		  Thread.sleep(1500);
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	 /**SEARCH ASSIGNEE**/	  
		  SearchPage.statusINIT(driver); 
		  SearchPage.AdvancedSearchClick(driver);
		  Thread.sleep(1500);
		  SearchPage.clientname(driver).sendKeys("20");
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns")); 
		  SearchPage.SearchClick(driver);
		  Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		  takeScreenshot(driver,"2.SearchResults");	
		  Thread.sleep(1500);	
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		  driver.switchTo().parentFrame(); 
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_bottom")); 
		  driver.findElement(By.xpath("//*[@id=\"did_results\"]/form/table/tbody/tr[2]/td[1]/a")).click();
		  Thread.sleep(1500);
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	/**ASSIGNEE PROFILE**/	  
		  	
          if (isAlertPresent()) {
 			 driver.switchTo().alert().accept();
 			 driver.switchTo().defaultContent();
 			 }
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));
          takeScreenshot(driver,"3.Assigneeprofile");	
     /**START SERVICE**/    
        //  ExistingAssignee.AppleTaxClick(driver);
          ExistingAssignee.CrossCultServiceClick(driver);
          driver.switchTo().defaultContent();
          ExistingAssignee.StartServiceClick(driver);
          Thread.sleep(4000);
          driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));          
          ExistingAssignee.CrossCultServiceClick(driver);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          ExistingAssignee.CrossCultAuthClick(driver);
          ExistingAssignee.CrossCultInitFormOpen(driver);
          Thread.sleep(4000);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
         
     /**ASSIGN FORM TO SUPPLIER**/     
          ExistingAssignee.PlusClick(driver);
          Thread.sleep(1500);
          takeScreenshot(driver,"4.Assign1");	
          ExistingAssignee.RecipientClick(driver);
          Thread.sleep(1500);
          takeScreenshot(driver,"5.Assign2");	
          ExistingAssignee.ToClick(driver);
          Thread.sleep(3000);

          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
          ExistingAssignee.SuppSrchClick(driver);
          Thread.sleep(5000);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
     //**SUPPLIER CONTACT SEARCH**/
         ExistingAssignee.RolesetSupplContct(driver);
         driver.switchTo().parentFrame();
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns")); 
         Thread.sleep(2500);
        ExistingAssignee.SuppCntctSrchClick(driver); 
        Thread.sleep(3500);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_bottom"));
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Authorizations, New')]")));
        takeScreenshot(driver,"6.SeearchSupplier2");	
        ExistingAssignee.SuppCntctResultClick(driver);
        Thread.sleep(2500);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));     
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
        //Update Contact email
        ExistingAssignee.Acttoemail(driver).clear();
        ExistingAssignee.Acttoemail(driver).sendKeys("kaan.perk@sirva.com");
        ExistingAssignee.ActStartbtn(driver).click();
        takeScreenshot(driver,"7.Action");	
        //Start Action
        driver.switchTo().defaultContent();
        ExistingAssignee.ActConfirmNO(driver).click();
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        takeScreenshot(driver,"8.FormAssigned");	
        Thread.sleep(1000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
        ExistingAssignee.PlusClick(driver);
        takeScreenshot(driver,"9.FormAssigned2");	
	}
 

	@After
	public void teardown() throws Exception {
		 //driver.quit();
	}

}
