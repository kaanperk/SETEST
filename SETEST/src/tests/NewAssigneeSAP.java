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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.NewAssignee;


public class NewAssigneeSAP {
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
			FileUtils.copyFile(source, new File("./Screenshots/SAP-PROFILE-Screenshots/" + screenshotname + ".png"));
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
	    Thread.sleep(35000);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
		   takeScreenshot(driver,"1.Homepage");	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
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
			       NewAssignee.orgname(driver).sendKeys("SAP Africa");
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
			       NewAssignee.OrgresultSAPClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.programdropdown(driver).selectByIndex(3);
			       Thread.sleep(2500);
			       takeScreenshot(driver,"2.SAP New Assignee");	    
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
			         takeScreenshot(driver,"3.SAP New Assignee");	 
		
		/*
		 * NewAssignee.AsgneTypeClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1"));
		 */
		
		/*
		 * NewAssignee.AsgneSel1Click(driver); NewAssignee.OKClick(driver);
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 */
		  
		  
		  NewAssignee.asgmttypeselect(driver).selectByVisibleText("Long Term");
		/* NewAssignee.assignedpolicy(driver).sendKeys("Assigned Policy Test"); */
		 
		/*
		 * NewAssignee.custminame(driver).sendKeys("middle");
		 * NewAssignee.custsalutation(driver).selectByVisibleText("Mr.");
		 * NewAssignee.custsuffix(driver).selectByIndex(2);
		 */
		  NewAssignee.custprefsalutation(driver).selectByIndex(3);
		  NewAssignee.custpreffname(driver).sendKeys("kaan");
		  NewAssignee.custprefminame(driver).sendKeys("prefmi");
		  NewAssignee.custpreflname(driver).sendKeys("test");
		  NewAssignee.custprefsalutation(driver).selectByIndex(2);
		  NewAssignee.custprefsuffix(driver).selectByIndex(3);
		  NewAssignee.phnetype1dropdown(driver).selectByIndex(1);
		  NewAssignee.phne1country(driver).sendKeys("+1");
		  NewAssignee.phne1areacode(driver).sendKeys("312");
		  NewAssignee.phne1nbr(driver).sendKeys("4567890");
		 
		/* NewAssignee.phnetype2dropdown(driver).selectByIndex(2); */
		
		/*
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
		  NewAssignee.custemail(driver).sendKeys("test@sirva.com");
		  
		/*
		 * NewAssignee.pfdcm(driver).selectByVisibleText("Email");
		 * NewAssignee.cust2email(driver).sendKeys("test2@sirva.com");
		 */
		 
		/*
		 * NewAssignee.custssn(driver).sendKeys("123456789");
		 * NewAssignee.custpassportnbr(driver).sendKeys("258465");
		 * NewAssignee.custpassportnbr(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.pasprtissuedate(driver).sendKeys("1/1/2015");
		 * NewAssignee.pasprtissuedate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.pasprtexpiredate(driver).sendKeys("1/1/2020");
		 * NewAssignee.pasprtexpiredate(driver).sendKeys(Keys.ESCAPE);
		 * Thread.sleep(1500); NewAssignee.ChkgrencardholdY(driver);
		 */
		/*
		 * NewAssignee.citizenshipcountry(driver).selectByVisibleText("United States");
		 * NewAssignee.dualcitizenshipcountry(driver).selectByVisibleText("Germany");
		 */
		 
		/*
		 * NewAssignee.gender(driver).selectByVisibleText("Male");
		 * NewAssignee.maritalstatus(driver).selectByVisibleText("Married");
		 * NewAssignee.birthdate(driver).sendKeys("7/15/1976");
		 * NewAssignee.birthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.birthcountry(driver).selectByVisibleText("United States");
		 * NewAssignee.birthstate(driver).selectByVisibleText("Illinois");
		 * NewAssignee.birthcity(driver).sendKeys("Chicago");
		 * 
		 * 
		 * NewAssignee.familysizeonasgnmt(driver).sendKeys("4");
		 * NewAssignee.familysize(driver).sendKeys("5");
		 * NewAssignee.accompdependents(driver).sendKeys("2");
		 * NewAssignee.SplitfamilyN(driver);
		 * NewAssignee.visatype(driver).sendKeys("visa type");
		 * NewAssignee.visastatus(driver).sendKeys("visa stat");
		 * NewAssignee.visaissuedate(driver).sendKeys("1/1/2019");
		 * NewAssignee.visaissuedate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.visaexpiredate(driver).sendKeys("1/15/2021");
		 * NewAssignee.visaexpiredate(driver).sendKeys(Keys.ESCAPE);
		 */
		 
		  
		  
		
		/*
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
		 */
		 

		
		  NewAssignee.custaddr1(driver).sendKeys("321 test ave");
		  NewAssignee.custaddr2(driver).sendKeys("addr2 test");
		  NewAssignee.custprefcity(driver).sendKeys("Chicago");
		  NewAssignee.zip(driver).sendKeys("60601"); 
		  Thread.sleep(2500);
		    takeScreenshot(driver,"4.SAP New Assignee");	 	 
		  
		 // NewAssignee.custtitle(driver).sendKeys("old title");
		
		/*
		 * NewAssignee.homehrmgrname(driver).sendKeys("home hr mgr");
		 * NewAssignee.homehrmgremail(driver).sendKeys("home hr email");
		 * NewAssignee.mgrname(driver).sendKeys("Bob Smith");
		 * NewAssignee.mgremail(driver).sendKeys("bob@sirva.com");
		 */
		  NewAssignee.curasgmtcountry(driver).selectByVisibleText("United States");
		  NewAssignee.curasgmtstate(driver).selectByVisibleText("Illinois");
		  NewAssignee.curcity(driver).sendKeys("Chicago");
		/*
		 * NewAssignee.custcostcenter(driver).sendKeys("102030");
		 * NewAssignee.MISC1(driver).sendKeys("MISC1");
		 * NewAssignee.MISC2(driver).sendKeys("MISC2");
		 * NewAssignee.wrksitelocation(driver).sendKeys("wrksite1");
		 */
		  
		  
		  
		  
		  
		/*
		 * NewAssignee.businessunit(driver).sendKeys("businessunit");
		 * NewAssignee.billingcenter(driver).selectByIndex(1);
		 * NewAssignee.sendinglegal(driver).sendKeys("sending legal");
		 * 
		 * NewAssignee.hosthrmgrname(driver).sendKeys("Karen Williams");
		 * NewAssignee.hosthrmgremail(driver).sendKeys("kare@sirva.com");
		 * NewAssignee.financemgrname(driver).sendKeys("James Hopkins");
		 * NewAssignee.financemgremail(driver).sendKeys("james@sirva.com");
		 * NewAssignee.newtitle(driver).sendKeys("New Title");
		 */
		 
		  NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
		  NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
		  NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
		  NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
		  NewAssignee.dtextstartdate(driver).sendKeys("5/1/2020");
		  NewAssignee.dtextstartdate(driver).sendKeys(Keys.ESCAPE);
		  
		/*
		 * NewAssignee.dtextstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dtextenddate(driver).sendKeys("12/30/2020");
		 * NewAssignee.dtextenddate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualstartdate(driver).sendKeys("4/15/2019");
		 * NewAssignee.actualstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualenddate(driver).sendKeys("5/15/2021");
		 * NewAssignee.actualenddate(driver).sendKeys(Keys.ESCAPE);
		 */
		//  NewAssignee.newmanager(driver).sendKeys("Sam Adams");
		//  NewAssignee.newmanageremail(driver).sendKeys("sam@sirva.com");
		  NewAssignee.newasgmtcountry(driver).selectByVisibleText("United States");
		  NewAssignee.newcity(driver).sendKeys("Boston");
		  NewAssignee.custzip2(driver).sendKeys("NA");
		//  NewAssignee.newwrksitelocation(driver).sendKeys("newwrksite");
		
		//  NewAssignee.divisionlevel(driver).selectByIndex(1);
		 // NewAssignee.extid(driver).sendKeys("ext123");
		  Thread.sleep(2500);
		   takeScreenshot(driver,"5.SAP New Assignee");	 
		/*
		 * NewAssignee.newcostcenter(driver).sendKeys("432123");
		 * NewAssignee.newcostcenter2(driver).sendKeys("5555555");
		 * NewAssignee.employeeid(driver).sendKeys("112233");
		 * NewAssignee.grade(driver).selectByIndex(1);
		 * NewAssignee.policy(driver).selectByIndex(1);
		 * NewAssignee.auditcode(driver).sendKeys("audtcode");
		 * NewAssignee.joboffertype(driver).selectByIndex(1);
		 * NewAssignee.joboffracceptedY(driver);
		 * NewAssignee.jobofferaccepteddate(driver).sendKeys("2/15/2019");
		 * NewAssignee.jobofferaccepteddate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.receivinglegal(driver).sendKeys("receiving legal");
		 */
		 
		
		/*
		 * NewAssignee.homefilingstatus(driver).selectByIndex(1);
		 * NewAssignee.homefilingcountry(driver).selectByIndex(1); Thread.sleep(1500);
		 * NewAssignee.homefilingstate(driver).selectByIndex(1);
		 * NewAssignee.homefilingcity(driver).sendKeys("Chicago");
		 * NewAssignee.homesalary(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.
		 * END),"245000");
		 * NewAssignee.homesalarycurrency(driver).selectByVisibleText("US Dollar");
		 * NewAssignee.payfreq(driver).sendKeys("bi weekly");
		 * NewAssignee.homebasesalarypercentage(driver).sendKeys("15");
		 * NewAssignee.perdiemmoney(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,
		 * Keys.END),"3500"); NewAssignee.perdiemcurrency(driver).selectByIndex(1);
		 * NewAssignee.retireplanpercent(driver).sendKeys("2");
		 * NewAssignee.RetireeligibleYES(driver);
		 * 
		 * NewAssignee.taxequalcity(driver).sendKeys("New York");
		 * NewAssignee.taxequalstate(driver).sendKeys("New York");
		 * 
		 * NewAssignee.TaxequalbonusYES(driver);
		 * 
		 * NewAssignee.bonuspercent(driver).sendKeys("10");
		 * NewAssignee.annualbonus(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys
		 * .END),"15000.00");
		 * 
		 * NewAssignee.bonusrange(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.
		 * END),"25,000.00");
		 * 
		 * 
		 * NewAssignee.overallbudget(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT,Keys.END),"35000.00");
		 * NewAssignee.overallbudgetcurrency(driver).selectByIndex(2);
		 * NewAssignee.housingallowance(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT,Keys.END),"10000.00");
		 * NewAssignee.housingallowancecurrency(driver).selectByIndex(3);
		 * NewAssignee.utilityallowance(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT
		 * ,Keys.END),"8000.00");
		 * NewAssignee.utilityallowancecurrency(driver).selectByIndex(4);
		 * NewAssignee.miscallowance(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,
		 * Keys.END),"7500.00");
		 * NewAssignee.miscallowancecurrency(driver).selectByIndex(5);
		 * NewAssignee.miscexptype(driver).selectByIndex(1);
		 * NewAssignee.homeownerorselling(driver).selectByIndex(2);
		 * NewAssignee.delegauthcecurrency(driver).selectByIndex(8);
		 * NewAssignee.delegofauthority(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT,Keys.END),"5500.00");
		 * NewAssignee.DeleggrantedYES(driver);
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys("3/1/2019");
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveindate(driver).sendKeys("3/15/2019");
		 * NewAssignee.permhousingmoveindate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys("9/15/2020");
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.specialneeds(driver).sendKeys("Special Needs");
		 * 
		 * 
		 * NewAssignee.LOUsentdate(driver).sendKeys("10/21/2018");
		 * NewAssignee.LOUsentdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.LOUsigneddate(driver).sendKeys("11/15/2018");
		 * NewAssignee.LOUsigneddate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.LOUcomments(driver).sendKeys("LOU Comments");
		 * NewAssignee.CEsentdate(driver).sendKeys("11/21/2018");
		 * NewAssignee.CEsentdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.CEapproveddate(driver).sendKeys("11/25/2018");
		 * NewAssignee.CEapproveddate(driver).sendKeys(Keys.ESCAPE);
		 * 
		 * 
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
		 * NewAssignee.dependentssn(driver).sendKeys("1230456");
		 * NewAssignee.dependentpassptnbr(driver).sendKeys("5487960");
		 * NewAssignee.dependentpassptissuedate(driver).sendKeys("6/1/2018");
		 * NewAssignee.dependentpassptissuedate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentpassptexpiredate(driver).sendKeys("7/1/2023");
		 * NewAssignee.dependentpassptexpiredate(driver).sendKeys(Keys.ESCAPE);
		 * Thread.sleep(1500); NewAssignee.DependentgcholderYES(driver);
		 * 
		 * NewAssignee.dependentcitizenship(driver).selectByVisibleText("United States"
		 * );
		 * NewAssignee.dependentdualcitizenship(driver).selectByVisibleText("Germany");
		 * NewAssignee.dependentgender(driver).selectByVisibleText("Female");
		 * NewAssignee.dependentbirthdate(driver).sendKeys("3/21/1985");
		 * NewAssignee.dependentbirthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentbirthcountry(driver).selectByVisibleText("United States"
		 * ); NewAssignee.dependentemail(driver).sendKeys("dep1@sirva.com");
		 * 
		 * 
		 * NewAssignee.DependentfulltimestudentNO(driver);
		 * NewAssignee.dependentoccup(driver).sendKeys("dep occup");
		 * NewAssignee.DependentLanguagesClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1")); NewAssignee.LanguageGermanClick(driver);
		 * NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * NewAssignee.dependentlocated(driver).selectByIndex(1);
		 * NewAssignee.dependentfrom(driver).sendKeys("1/1/2000");
		 * NewAssignee.dependentfrom(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependenttill(driver).sendKeys("1/15/2020");
		 * NewAssignee.dependenttill(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentneeds(driver).sendKeys("dependent needs");
		 * 
		 * NewAssignee.PetsaccompYES(driver);
		 * NewAssignee.petnbr(driver).selectByVisibleText("3");
		 * NewAssignee.pettypes(driver).sendKeys("dogs, cat, bird");
		 * NewAssignee.petweights(driver).sendKeys("dog 15lbs, cat 10lbs, bird 8lbs");
		 * NewAssignee.petcomments(driver).sendKeys("pet comments");
		 */
		  NewAssignee.custreferuid(driver) .selectByIndex(2);
		/*
		 * NewAssignee.othercontact(driver).sendKeys("other contact");
		 * NewAssignee.hiredate(driver).sendKeys("3/15/2015");
		 * NewAssignee.hiredate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.execofficer(driver).selectByVisibleText("No");
		 * NewAssignee.hirestatus(driver).selectByVisibleText("Transfer");
		 * NewAssignee.hirecountry(driver).selectByVisibleText("United States");
		 * 
		 * NewAssignee.PreviousassignmentYES(driver);
		 * NewAssignee.CountriesVisitedClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1"));
		 * waitForElementToBeVisible(driver,NewAssignee.countryARG(driver),3);
		 * NewAssignee.CountryARGselected(driver); NewAssignee.OKClick(driver);
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		 */
			       
			
		        
		 NewAssignee.gac(driver).selectByVisibleText("Perk, Kaan");
		//  NewAssignee.previousgac(driver).selectByIndex(1);
		  NewAssignee.centerofexcellence(driver).selectByIndex(1);
		  Thread.sleep(2500);
		  takeScreenshot(driver,"6.SAP New Assignee");	 	
		/*
		 * NewAssignee.initialcontactdate(driver).sendKeys("10/15/2019");
		 * NewAssignee.initialcontactdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.initialcontacttime(driver).sendKeys("8:45");
		 * NewAssignee.initiationcalldate(driver).sendKeys("11/5/2018");
		 * NewAssignee.initiationcalldate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.ccid(driver).sendKeys("111222");
		 * NewAssignee.wtid(driver).sendKeys("222333");
		 * NewAssignee.payrollcode(driver).sendKeys("159753");
		 * NewAssignee.primarypayrollid(driver).sendKeys("555666");
		 * NewAssignee.secondarypayrollid(driver).sendKeys("777888");
		 * NewAssignee.surveydate(driver).sendKeys("02/15/2019");
		 * NewAssignee.surveydate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.archiveboxnbr(driver).sendKeys("1990");
		 * NewAssignee.clientsystemid(driver).sendKeys("55440");
		 */
		 

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
		  Thread.sleep(3000);
		  takeScreenshot(driver,"7.SAP Profile Completed");	 
		  } else {
			     driver.switchTo().defaultContent();
	        	 driver.findElement(By.xpath("//input[@value='Yes']")).click();
	        	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	   	       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));  	
	   		  Thread.sleep(8000);
	   		  (new WebDriverWait(driver, 2))
	   		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_program_title_1']")));
	   		  Thread.sleep(3000);
	   		takeScreenshot(driver,"7.SAP Profile Completed");	
		  }
		  driver.switchTo().defaultContent();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          
	         WebElement element =   driver.findElement(By.xpath("//a[contains(.,'Languages Spoken')][1]"));
	         Actions actions = new Actions(driver);
	         actions.moveToElement(element);
	         actions.perform();
	         takeScreenshot(driver,"8.SAP Profile Completed");	
	         Thread.sleep(1500);
		  
	         WebElement  element1 =     driver.findElement(By.xpath("//input[@name='dt_offer_acceptance_date']"));
	         Actions actions1 = new Actions(driver);
	         actions1.moveToElement(element1);
	         actions1.perform();
	         takeScreenshot(driver,"9.SAP Profile Completed");	
		     Thread.sleep(1500);
		 
	         WebElement    element2 =     driver.findElement(By.xpath("//textarea[@name='special_needs']"));
	         Actions actions2 = new Actions(driver);
	         actions2.moveToElement(element2);
	         actions2.perform();
	         takeScreenshot(driver,"10.SAP Profile Completed");
	         Thread.sleep(1500);


	         WebElement    element3 =   driver.findElement((By.xpath("//textarea[@name = 'cust_oth_special_needs_1']")));
	         Actions actions3 = new Actions(driver);
	         actions3.moveToElement(element3);
	         actions3.perform();
	         takeScreenshot(driver,"11.SAP Profile Completed");
	         Thread.sleep(1500);
	         
	         WebElement    element4 =    driver.findElement(By.xpath("//input[@name='cust_authorized_date']"));
	         Actions actions4 = new Actions(driver);
	         actions4.moveToElement(element4);
	         actions4.perform();
	         takeScreenshot(driver,"12.SAP Profile Completed");
	         Thread.sleep(1500);
	         
	         WebElement    element5 =     driver.findElement(By.xpath("//input[@name='cust_box_number']"));
	         Actions actions5 = new Actions(driver);
	         actions5.moveToElement(element5);
	         actions5.perform();
	         takeScreenshot(driver,"13.SAP Profile Completed");
	         Thread.sleep(1500);
	       
	         
	         
	         
		}
		  
	   
			

				@After
			     public void teardown() throws Exception{
			    	// driver.quit(); 
			     }
				
			}
			 
		
	