package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.NewAssignee;


public class NewAssigneeBKC {
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


	  public boolean isAlertPresent() {
			 try {
			 driver.switchTo().alert();
			 return true;
			 }// try
			 catch (Exception e) {
			 return false;
			 }// catch
			 }
	
	public void takeScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/BKCProfile-Screenshots/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
		}
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
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		  Thread.sleep(35000);
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
	    takeScreenshot(driver,"1. Homepage");	
	    SearchPage.AsgneFldrClick(driver); 
	    Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
        NewAssignee.AddNewAsgneClick(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.custfname(driver).sendKeys("kaan");
			       NewAssignee.custlname(driver).sendKeys("test");
			       NewAssignee.OrgClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			         NewAssignee.orgnumber(driver).sendKeys("21850");
			       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns"));
			       NewAssignee.OrgSrchBtnClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@name,'work_bottom')]")));
			       NewAssignee.OrgresultBKCClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.programdropdown(driver).selectByVisibleText("SIRVAlytics - Burger King (BKC) (SIRVAlytics Testing)");
			      Thread.sleep(1500);
			      takeScreenshot(driver,"2.BKC New Profile");
			       NewAssignee.NextButtonClick(driver);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			      
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 	
			       NewAssignee.AsgneTypeClick(driver);
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
			       NewAssignee.AsgneSel1Click(driver); 
			       NewAssignee.OKClick(driver);
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			        NewAssignee.asgmttypeselect(driver).selectByVisibleText("Long Term");
			        NewAssignee.custpreffname(driver).sendKeys("kaan");
			        NewAssignee.custpreflname(driver).sendKeys("test");
			        NewAssignee.phnetype1dropdown(driver).selectByIndex(1);
			        NewAssignee.phne1country(driver).sendKeys("+44");
			        NewAssignee.phne1areacode(driver).sendKeys("312");
			        NewAssignee.phne1nbr(driver).sendKeys("4567890");
			        NewAssignee.custemail(driver).sendKeys("test@sirva.com"); 
			       NewAssignee.custaddr1(driver).sendKeys("321 test ave");
			       NewAssignee.custprefcity(driver).sendKeys("Chicago");
			       NewAssignee.custprefstate(driver).selectByVisibleText("Illinois");
			       NewAssignee.zip(driver).sendKeys("60601");
			       Thread.sleep(1500);
			       takeScreenshot(driver,"3.BKC New Profile");
			       NewAssignee.curasgmtcountry(driver).selectByVisibleText("United States");
			       NewAssignee.curasgmtstate(driver).selectByVisibleText("Illinois");
			       NewAssignee.curcity(driver).sendKeys("New York");
			       NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
			       NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
			       NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
			       NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
			       NewAssignee.newasgmtcountry(driver).selectByVisibleText("Germany");
			       NewAssignee.newcity(driver).sendKeys("Berlin");
			       Thread.sleep(1500);
			       takeScreenshot(driver,"4.BKC New Profile");	
			       NewAssignee.gac(driver).selectByIndex(1);
			       NewAssignee.custreferuid(driver) .selectByIndex(2);
			       NewAssignee.centerofexcellence(driver).selectByIndex(1);
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
			         Thread.sleep(1500);
			         takeScreenshot(driver,"5.BKC New Profile");	
			         NewAssignee.SaveClick(driver);
			         Thread.sleep(2000);
					  if (isAlertPresent()) {
					  driver.switchTo().alert().accept(); 
					  driver.switchTo().parentFrame(); 
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
					  Thread.sleep(2000);
					  driver.switchTo().parentFrame(); 
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame(); 
					  driver.findElement(By.xpath("//input[@value='Yes']")).click(); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
				       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));  	
					  Thread.sleep(8000);
					  (new WebDriverWait(driver, 2))
					  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_program_title_1']")));
					  driver.switchTo().defaultContent();
				   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
				   		  Thread.sleep(8000);
				   		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Assignee Types')]")));
				   		Thread.sleep(1500);
				   		takeScreenshot(driver,"6.BKC Profile Completed");
					  } else {
						     driver.switchTo().defaultContent();
				        	 driver.findElement(By.xpath("//input[@value='Yes']")).click();
				        	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
				   	       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));  	
				   		  Thread.sleep(8000);
				   		  (new WebDriverWait(driver, 2))
				   		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_program_title_1']")));
				   		  driver.switchTo().defaultContent();
				   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
				   		  Thread.sleep(8000);
				   		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Assignee Types')]")));
				   		Thread.sleep(1500);
				   		takeScreenshot(driver,"6.BKC Profile Completed");
					  }
			         Thread.sleep(300);
					  driver.switchTo().defaultContent();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			          Thread.sleep(10000);
			          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			          WebElement element =   driver.findElement(By.xpath("//input[@name='cust_ref_nbr']"));
				         Actions actions = new Actions(driver);
				         actions.moveToElement(element);
				         actions.perform();
				         takeScreenshot(driver,"7.BKC Profile Completed");
				         Thread.sleep(1500);
					  						 
				         WebElement    element1 =     driver.findElement(By.xpath("//textarea[@name='special_needs']"));
				         Actions actions1 = new Actions(driver);
				         actions1.moveToElement(element1);
				         actions1.perform();
				         takeScreenshot(driver,"8.BKC Profile Completed");
				         Thread.sleep(1500);


				         WebElement    element2 =   driver.findElement((By.xpath("//textarea[@name = 'cust_oth_special_needs_1']")));
				         Actions actions2 = new Actions(driver);
				         actions2.moveToElement(element2);
				         actions2.perform();
				         takeScreenshot(driver,"9.BKC Profile Completed");
				         Thread.sleep(1500);
				         
				         WebElement    element3 =    driver.findElement(By.xpath("//input[@name='cust_authorized_date']"));
				         Actions actions3 = new Actions(driver);
				         actions3.moveToElement(element3);
				         actions3.perform();
				         takeScreenshot(driver,"10.BKC Profile Completed");
				         Thread.sleep(1500);
				         
				         WebElement    element4 =      driver.findElement(By.xpath("//input[@name='cust_box_number']"));
				         Actions actions4 = new Actions(driver);
				         actions4.moveToElement(element4);
				         actions4.perform();
				         takeScreenshot(driver,"11.BKC Profile Completed");
				         Thread.sleep(1500);
							  
		}					  
							  
			     
			     @AfterMethod
			     public void teardown() throws Exception{
			    	 //driver.quit(); 
			     }
				
			}