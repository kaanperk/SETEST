
package tests.AssigneeProfileSIRVACONNECT;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.NewAssignee;


public class AssigneeProfile3MSIRVACONNECT{
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
			FileUtils.copyFile(source, new File("./Screenshots/SIRVACONNECT-3M/" + screenshotname + ".png"));
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
		
		
		  if
		  (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		  driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 
		 
		(new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='cp_display']")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
	    SearchPage.AsgneFldrClick(driver); 
	    Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
        NewAssignee.AddNewAsgneClick(driver);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.custfname(driver).sendKeys("kaan");
			       NewAssignee.custlname(driver).sendKeys("test");
			       NewAssignee.OrgClick(driver);
			       Thread.sleep(2000);
			       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.orgname(driver).sendKeys("3m");
			       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
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
			       NewAssignee.OrgResult3mClick(driver);
			       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.programdropdown(driver).selectByIndex(1);
			       NewAssignee.NextButtonClick(driver);
			       Thread.sleep(2000);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			      
			       
			       NewAssignee.AsgneTypeClick(driver);
			       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
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
			        NewAssignee.custhomecompany(driver).sendKeys("company name");
				       NewAssignee.custhostcompanycode(driver).sendKeys("cust host company code");
				       NewAssignee.custhomebusiness(driver).sendKeys("cust home business");
				       NewAssignee.custhostdivision(driver).sendKeys("host division");
				       NewAssignee.custhostdepartmentname(driver).sendKeys("dept name");			      
				       NewAssignee.custhostdepartmentnbr(driver).sendKeys("host dept nbr");
				      Thread.sleep(1500);
			       NewAssignee.custaddr1(driver).sendKeys("321 test ave");
			       NewAssignee.custprefcity(driver).sendKeys("Chicago");
			       NewAssignee.zip(driver).sendKeys("NA");
			       Thread.sleep(1500);
			 
			       NewAssignee.curasgmtcountry(driver).selectByIndex(1);
			       NewAssignee.curasgmtstate(driver).selectByIndex(1);
			       NewAssignee.curcity(driver).sendKeys("New York");
			       NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
			       NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
			       NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
			       NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
			       NewAssignee.newasgmtcountry(driver).selectByIndex(2);
			       NewAssignee.newcity(driver).sendKeys("test");
			       Thread.sleep(1500);
			   
			       NewAssignee.custreferuid(driver).selectByIndex(2);
			       NewAssignee.gac(driver).selectByIndex(1);
			       NewAssignee.centerofexcellence(driver).selectByIndex(1);
			        
					
					 Select s = new Select(driver.findElement(By.xpath("//select[@id='ddlb_Authorizefor']")));
					 List<WebElement> dd_options= s.getOptions();
					 int i =1;
					 System.out.println("3M Profile");
					 for (WebElement e:dd_options) {
						 System.out.println(i+ " - "+e.getText());
						 i++;
					 }
					 System.out.println("");
					
					
					driver.switchTo().parentFrame();
					driver.switchTo().parentFrame();
					driver.switchTo().parentFrame();
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
					Thread.sleep(1500);
					NewAssignee.SaveClick(driver);

					driver.switchTo().parentFrame();
					driver.switchTo().parentFrame();
					if (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
						driver.findElement(By.xpath("//input[@value='Yes']")).click();
					}
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));
					Thread.sleep(8000);
					(new WebDriverWait(driver, 3))
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_program_title_1']")));
					Thread.sleep(3000);
					takeScreenshot(driver, "1.3M Profile Completed");

					  
					  driver.switchTo().defaultContent();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
					 
					  WebElement element7 = driver.findElement(By.xpath("//select[@id='ddlb_Authorizefor']"));
					  Actions actions7 = new Actions(driver); 
					  actions7.moveToElement(element7);
					  actions7.perform(); 

					  NewAssignee.authorizefor(driver).selectByIndex(3);
					  
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
					  NewAssignee.SaveClick(driver); 
					  Thread.sleep(2000);
					  
					  Alert alert = driver.switchTo().alert();
					  alert.accept();
					  	    
					  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					  
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
					  
					  WebElement element8 = driver.findElement(By.xpath("//a[contains(.,'Employee Portal Info')]"));
					  Actions actions8 = new Actions(driver); 
					  actions8.moveToElement(element8);
					  actions8.perform(); 
					  
					  takeScreenshot(driver,"2. Authorize For selected");
					  Thread.sleep(1500);
					  
					  
					  NewAssignee.EmployeePortalClick(driver);
					  Thread.sleep(2000);
					  takeScreenshot(driver,"3. Employee Portal Info");
					  Thread.sleep(2000);
					  driver.switchTo().defaultContent();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
					 
					  System.out.println("AFTER SIRVA Connect Employee Portal AUTHORIZED");
				      System.out.println(driver.findElement(By.xpath("//*[@id=\"form1\"]/div/table[1]/tbody/tr/td")).getText());
					  
					// Get all the table row elements from the table 
					  List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"form1\"]/div/table[2]/tbody/tr")); 

					  // And iterate over them and get all the cells 
					  for (WebElement row : allRows) { 
					      List<WebElement> cells = row.findElements(By.tagName("td")); 

					      // Print the contents of each cell
					      for (WebElement cell : cells) {         

					      System.out.println(cell.getText());
					      }
					    }
					  
					  Thread.sleep(2000);
					  driver.switchTo().defaultContent();
					  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
						(new WebDriverWait(driver, 2))
						  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_modbox_title_1']")));
			           NewAssignee.DmodcloseClick(driver);   

					    Thread.sleep(1500);
					    
					    driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
					    
					    NewAssignee.authorizefor(driver).selectByIndex(2);
					    driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
						  
						  NewAssignee.SaveClick(driver); 
						  Thread.sleep(1000);  
						  
						  alert.accept();
						  Thread.sleep(1500);
						  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
						  
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
						  WebElement element9 = driver.findElement(By.xpath("//a[contains(.,'Employee Portal Info')]"));
						  Actions actions9 = new Actions(driver); 
						  actions9.moveToElement(element9);
						  actions9.perform(); 
						  takeScreenshot(driver,"4. Authorize For selected2");
					  
						  
						   driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
						  
						  NewAssignee.EmployeePortalClick(driver);
						  Thread.sleep(2000);
						  takeScreenshot(driver,"5. Employee Portal Info2");
						  Thread.sleep(1000);
						  driver.switchTo().defaultContent();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
						 
						  System.out.println("AFTER IMOVE Portal AUTHORIZED");
					      System.out.println(driver.findElement(By.xpath("//*[@id=\"form1\"]/div/table[1]/tbody/tr/td")).getText());
						  
						// Get all the table row elements from the table 
						  List<WebElement> allRows2 = driver.findElements(By.xpath("//*[@id=\"form1\"]/div/table[2]/tbody/tr")); 

						  // And iterate over them and get all the cells 
						  for (WebElement row : allRows2) { 
						      List<WebElement> cells = row.findElements(By.tagName("td")); 

						      // Print the contents of each cell
						      for (WebElement cell : cells) {         

						      System.out.println(cell.getText());
						     
						  }
						      
						  }
						  
						  Thread.sleep(2000);
						  driver.switchTo().defaultContent();
						  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
							(new WebDriverWait(driver, 2))
							  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_modbox_title_1']")));
				           NewAssignee.DmodcloseClick(driver);   

						    Thread.sleep(1500);
						    
						    driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
						    
						    NewAssignee.authorizefor(driver).selectByIndex(1);
						    driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
							  
							  NewAssignee.SaveClick(driver); 
							  Thread.sleep(1500);  
							  
							  alert.accept();
							  Thread.sleep(1500);
							  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
							  
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
							  
							  WebElement element10 = driver.findElement(By.xpath("//a[contains(.,'Employee Portal Info')]"));
							  Actions actions10 = new Actions(driver); 
							  actions10.moveToElement(element10);
							  actions10.perform(); 
							  takeScreenshot(driver,"6. Authorize For selected3");
						  
							  
							   driver.switchTo().parentFrame();
								  driver.switchTo().parentFrame();
								  driver.switchTo().parentFrame();
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
							  
							  NewAssignee.EmployeePortalClick(driver);
							  Thread.sleep(2000);
							  takeScreenshot(driver,"7. Employee Portal Info3");
							  Thread.sleep(1000);
							  driver.switchTo().defaultContent();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
							 
							  System.out.println("AFTER IMOVE Portal + LUMPSUM AUTHORIZED");
						      System.out.println(driver.findElement(By.xpath("//*[@id=\"form1\"]/div/table[1]/tbody/tr/td")).getText());
							  
							// Get all the table row elements from the table 
							  List<WebElement> allRows3 = driver.findElements(By.xpath("//*[@id=\"form1\"]/div/table[2]/tbody/tr")); 

							  // And iterate over them and get all the cells 
							  for (WebElement row : allRows3) { 
							      List<WebElement> cells = row.findElements(By.tagName("td")); 

							      // Print the contents of each cell
							      for (WebElement cell : cells) {         

							      System.out.println(cell.getText());
							     
							  }
							      
							  }


				}

				@After
				public void teardown() throws Exception {
					// driver.quit();
				}

			}
			

			       
			   