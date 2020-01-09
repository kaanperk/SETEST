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


public class AssigneeProfileHONEYWELLSIRVACONNECT {
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
			FileUtils.copyFile(source, new File("./Screenshots/SIRVACONNECT-HONEYWELL/" + screenshotname + ".png"));
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		/**LOGIN **/
		LoginPage.userid(driver).sendKeys("kaan.perk@sirva.com");
		LoginPage.passwd(driver).sendKeys("Dec321@@");
		LoginPage.login(driver);
	    WebDriverWait wait = new WebDriverWait(driver,3);
	    Thread.sleep(23000);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    
		  if
		  (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		  driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 
		
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
	    takeScreenshot(driver,"1.Homepage");	
	    SearchPage.AsgneFldrClick(driver); 
	    Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
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
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.orgname(driver).sendKeys("Honeywell - ACS");
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
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
			       NewAssignee.OrgresultHONClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.programdropdown(driver).selectByIndex(1);
			       Thread.sleep(1000);
			       takeScreenshot(driver,"2.Honeywell New Assignee Profile");
			       NewAssignee.NextButtonClick(driver);
			       Thread.sleep(1000);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			    
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			     
			         takeScreenshot(driver,"3.Honeywell New Assignee Profile");
		
			         NewAssignee.employeeid(driver).sendKeys("1234567");
			         NewAssignee.asgmttypeselect(driver).selectByVisibleText("Long Term");
			         NewAssignee.relostatus(driver).selectByIndex(1);
			         NewAssignee.RC(driver).selectByIndex(1);
			         NewAssignee.MC(driver).selectByIndex(1);
			         NewAssignee.opsmgr(driver).selectByIndex(1);
			         Thread.sleep(1500);
			         NewAssignee.AssigneetypeHONClick(driver);
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame(); 
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
					  NewAssignee.AsgneSel1Click(driver);
					  NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
			         
		
		  NewAssignee.custminame(driver).sendKeys("middle");
		  NewAssignee.custsalutation(driver).selectByVisibleText("Mr.");
		  NewAssignee.custsuffix(driver).selectByIndex(2);
		  NewAssignee.custprefsalutation(driver).selectByIndex(3);
		  NewAssignee.custpreffname(driver).sendKeys("kaan");
		  NewAssignee.custprefminame(driver).sendKeys("prefmi");
		  NewAssignee.custpreflname(driver).sendKeys("test");
		  NewAssignee.custprefsalutation(driver).selectByIndex(2);
		  NewAssignee.custprefsuffix(driver).selectByIndex(3);
		  
		/*
		 * NewAssignee.maritalstatus(driver).selectByVisibleText("Married");
		 * NewAssignee.citizenshipcountry(driver).selectByVisibleText("United States");
		 * 
		 * NewAssignee.dualcitizenshipcountry(driver).selectByVisibleText("Germany");
		 * NewAssignee.custpassportnbr(driver).sendKeys("258465");
		 * NewAssignee.custpassportnbr(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.pasprtissuedate(driver).sendKeys("1/1/2015");
		 * NewAssignee.pasprtissuedate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.pasprtexpiredate(driver).sendKeys("1/1/2020");
		 * NewAssignee.pasprtexpiredate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.visatype(driver).sendKeys("visa type");
		 * NewAssignee.visastatus(driver).sendKeys("visa stat");
		 * NewAssignee.visaissuedate(driver).sendKeys("1/1/2019");
		 * NewAssignee.visaissuedate(driver).sendKeys(Keys.ESCAPE); Thread.sleep(1500);
		 * NewAssignee.visaexpdateHON(driver).sendKeys("1/15/2021");
		 * NewAssignee.visaexpdateHON(driver).sendKeys(Keys.ESCAPE);
		 * 
		 * NewAssignee.CustLanguagesClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1"));
		 * waitForElementToBeVisible(driver,NewAssignee.English(driver),3);
		 * NewAssignee.LanguageEnglishClick(driver); NewAssignee.OKClick(driver);
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * Thread.sleep(2000);
		 * 
		 * NewAssignee.birthdate(driver).sendKeys("7/15/1976");
		 * NewAssignee.birthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.birthcountry(driver).selectByVisibleText("United States");
		 * NewAssignee.birthstate(driver).selectByVisibleText("Illinois");
		 * NewAssignee.birthcity(driver).sendKeys("Chicago");
		 * NewAssignee.familysizeonasgnmt(driver).sendKeys("4");
		 * NewAssignee.familysize(driver).sendKeys("5");
		 */
		  
		  NewAssignee.custemail(driver).sendKeys("test@sirva.com");
		  NewAssignee.pfdcm(driver).selectByVisibleText("Email");
		//  NewAssignee.cust2email(driver).sendKeys("test2@sirva.com");
		  
		  NewAssignee.phnetype1dropdown(driver).selectByIndex(1);
		  NewAssignee.phne1country(driver).sendKeys("+1");
		  NewAssignee.phne1areacode(driver).sendKeys("312");
		  NewAssignee.phne1nbr(driver).sendKeys("4567890");
		/*
		 * NewAssignee.phnetype2dropdown(driver).selectByIndex(2);
		 * NewAssignee.phne2country(driver).sendKeys("+44");
		 * NewAssignee.phne2areacode(driver).sendKeys("55");
		 * NewAssignee.phne2nbr(driver).sendKeys("123456789");
		 * NewAssignee.phnetype3dropdown(driver).selectByIndex(3);
		 * NewAssignee.phne3country(driver).sendKeys("+23");
		 * NewAssignee.phne3areacode(driver).sendKeys("67");
		 * NewAssignee.phne3nbr(driver).sendKeys("35790863");
		 * NewAssignee.phnetype4dropdown(driver).selectByIndex(4);
		 * NewAssignee.phne4country(driver).sendKeys("+67");
		 * NewAssignee.phne4areacode(driver).sendKeys("3");
		 * NewAssignee.phne4nbr(driver).sendKeys("56709342");
		 */
		//  NewAssignee.newtitle(driver).sendKeys("New Title");
		  NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
		  NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
		  NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
		  NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
		/*
		 * NewAssignee.dtextstartdate(driver).sendKeys("5/1/2020");
		 * NewAssignee.dtextstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dtextenddate(driver).sendKeys("12/30/2020");
		 * NewAssignee.dtextenddate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualstartdate(driver).sendKeys("4/15/2019");
		 * NewAssignee.actualstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualenddate(driver).sendKeys("5/15/2021");
		 * NewAssignee.actualenddate(driver).sendKeys(Keys.ESCAPE);
		 */
		  NewAssignee.custreferuid(driver) .selectByIndex(2);
		 
		  NewAssignee.SBU(driver).selectByIndex(1);
		  NewAssignee.SBE(driver).selectByIndex(1);
		  NewAssignee.hyperioncode(driver).selectByIndex(1);
		  NewAssignee.curasgmtcountry(driver).selectByVisibleText("United States");
			 NewAssignee.curcity(driver).sendKeys("Chicago");
			  NewAssignee.newasgmtcountry(driver).selectByVisibleText("United States");
			  NewAssignee.newcity(driver).sendKeys("Boston");
			  
			  
			  NewAssignee.custaddr1(driver).sendKeys("321 test ave");
			  NewAssignee.custaddr2(driver).sendKeys("addr2 test");
			  NewAssignee.custprefcity(driver).sendKeys("Chicago");
			  NewAssignee.zip(driver).sendKeys("60601"); 
			  takeScreenshot(driver,"4.Honeywell New Assignee Profile");
			  

		//	  NewAssignee.specialneeds(driver).sendKeys("Special Needs");
		
	
			  

		/*
		 * NewAssignee.DependentaccompYES(driver);
		 * NewAssignee.dependentrelation(driver).selectByVisibleText("Spouse");
		 * NewAssignee.dependentprefix(driver).selectByVisibleText("Mrs.");
		 * NewAssignee.dependentfirstname(driver).sendKeys("Spouse first");
		 * NewAssignee.dependentmidname(driver).sendKeys("midname");
		 * NewAssignee.dependentlastname(driver).sendKeys("lastname");
		 * NewAssignee.dependentsuffix(driver).selectByVisibleText("Sr.");
		 * NewAssignee.dependentprefprefix(driver).selectByVisibleText("Dr.");
		 * NewAssignee.dependentpreffname(driver).sendKeys("pref fname");
		 * NewAssignee.dependentprefmidname(driver).sendKeys("pmid");
		 * NewAssignee.dependentpreflname(driver).sendKeys("preflast");
		 * NewAssignee.dependentprefsuffix(driver).selectByVisibleText("V");
		 * 
		 * 
		 * 
		 * NewAssignee.dependentphonetype1(driver).selectByVisibleText("Other");
		 * NewAssignee.dependentphone1country(driver).sendKeys("1");
		 * NewAssignee.dependentphone1areacode(driver).sendKeys("657");
		 * NewAssignee.dependentphone1nbr(driver).sendKeys("35674125");
		 * NewAssignee.dependentphonetype2(driver).selectByVisibleText("Dest Home");
		 * NewAssignee.dependentphone2country(driver).sendKeys("1");
		 * NewAssignee.dependentphone2areacode(driver).sendKeys("657");
		 * NewAssignee.dependentphone2nbr(driver).sendKeys("35674125");
		 * 
		 * 
		 * 
		 * NewAssignee.dependentbirthdate(driver).sendKeys("3/21/1985");
		 * NewAssignee.dependentbirthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentemail(driver).sendKeys("dep1@sirva.com");
		 * NewAssignee.dependentcitizenship(driver).selectByVisibleText("United States"
		 * );
		 * NewAssignee.dependentdualcitizenship(driver).selectByVisibleText("Germany");
		 * NewAssignee.dependentgender(driver).selectByVisibleText("Female");
		 * Thread.sleep(1500); NewAssignee.DependentLanguagesClick(driver);
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1")); NewAssignee.LanguageGermanClick(driver);
		 * NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * 
		 * NewAssignee.depspecialneedsHON(driver).sendKeys("Dependent special needs");
		 * 
		 * 
		 * NewAssignee.PetsaccompYES(driver);
		 * NewAssignee.petnbr(driver).selectByVisibleText("2");
		 * NewAssignee.pettypes(driver).sendKeys("dogs, cat, bird");
		 * NewAssignee.petweights(driver).sendKeys("dog 15lbs, cat 10lbs, bird 8lbs");
		 * NewAssignee.petcomments(driver).sendKeys("pet comments");
		 * 
		 * NewAssignee.homesalary(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.
		 * END),"245000");
		 * NewAssignee.homesalarycurrency(driver).selectByVisibleText("US Dollar");
		 * NewAssignee.miscallowance(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,
		 * Keys.END),"7500.00");
		 * NewAssignee.miscallowancecurrency(driver).selectByIndex(5);
		 * NewAssignee.housingallowance(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT,Keys.END),"10000.00");
		 * NewAssignee.housingallowancecurrency(driver).selectByIndex(3);
		 * NewAssignee.utilityallowance(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT
		 * ,Keys.END),"8000.00");
		 * NewAssignee.utilityallowancecurrency(driver).selectByIndex(4);
		 * 
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys("3/1/2019");
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveindate(driver).sendKeys("3/15/2019");
		 * NewAssignee.permhousingmoveindate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys("9/15/2020");
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys(Keys.ESCAPE);
		 */

			
		        
		 NewAssignee.gac(driver).selectByVisibleText("Perk, Kaan");
	//	  NewAssignee.previousgac(driver).selectByIndex(1);
		  NewAssignee.centerofexcellence(driver).selectByIndex(1);
		  
		  
			 Select s = new Select(driver.findElement(By.xpath("//select[@id='ddlb_Authorizefor']")));
			 List<WebElement> dd_options= s.getOptions();
			 int i =1;
			 System.out.println("Generic Profile");
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
	   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'javascript:popup_custom_SIRVA')]")));
	   		Thread.sleep(1500);
	   	 takeScreenshot(driver,"5.Honeywell Profile Completed");
		  } else {
			     driver.switchTo().defaultContent();
	        //	 driver.findElement(By.xpath("//input[@value='Yes']")).click();
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
	   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'javascript:popup_custom_SIRVA')]")));
	   		Thread.sleep(1500);
	   		takeScreenshot(driver,"5.Honeywell Profile Completed");
		  }  
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
			     public void teardown() throws Exception{
			  //  driver.quit(); 
			     }
				
			}