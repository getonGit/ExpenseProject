package testExpense;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import expenseMain.ConfigFileReader;
import expenseMain.ExpenseBase;
import expenseMain.ManageCategory;
import expenseMain.ManageExpenseList;
import expenseMain.NewUserRegistration;
import expenseMain.TestData;



public class BaseExpenseTest {

	// Create an object of all the classes implemented in Main 
	ExpenseBase homePage;
	ManageExpenseList ManageExpense;
	ManageCategory addCat;
	TestData testData;
	NewUserRegistration RegUser;
	ConfigFileReader configFileReader;
	
	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports report;

	public static String testExecutionStartTime;
	
	
	@BeforeSuite
	public void initialization() {
		try {

			//currentProjectDirectory = System.getProperty("user.dir");

			configFileReader= new ConfigFileReader();
			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
			String ReportPath = configFileReader.getExtentReportPath();
			report = new ExtentReports(ReportPath);
			System.out.println("report file path is : " + ReportPath);


		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@BeforeTest
	public void invokeBrowser() {


		test = report.startTest("Setup :: Invoke Browser");
		try {


			driver = new ChromeDriver();
			
						
			ManageExpense = new ManageExpenseList(driver);
			driver.manage().window().maximize();
			test.log(LogStatus.INFO, "browser maximizing... ");
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
			addCat = new ManageCategory(driver);
			System.out.println(configFileReader.getApplicationUrl());
			driver.get(configFileReader.getApplicationUrl());
			test.log(LogStatus.INFO, "website Invoked :: " );
			
					 
/* 		If need to test with registered user
			WebElement WE = driver.findElement(By.id("login"));
			WE.click();
			WE.sendKeys("madhuri");

			WebElement WE1 = driver.findElement(By.id("password"));
			WE1.click();
			WE1.sendKeys("madhuri");

			WebElement WE2 = driver.findElement(By.id("submit"));
			WE2.click();
*/

		} catch (Exception e) {
			test.log(LogStatus.ERROR, "error in invokeBrowser method");
			Assert.fail("Because an Exception occured..");
		}

	}

 /*As the username is getting deleted every couple of hours, have added below code to 
			register new user as the username created by me would not exist later during the review */
	
	@Test(dataProvider="RegUserNow", dataProviderClass=expenseMain.TestData.class)
		public void addAUser(String user, String password1, String password2) {	
			WebElement WE = driver.findElement(By.xpath("//a[contains(text(),'Register new user')]"));
	 		WE.click();
		RegUser = new NewUserRegistration(driver);
		RegUser.registerUser(user, password1, password2); 
		}
	
	
	@Test(dataProvider="InputCategory", dataProviderClass=expenseMain.TestData.class)
	public void addMyCategoryTypes(String data) {
	  System.out.println(driver.getCurrentUrl());
	  addCat = new ManageCategory(driver);
	  addCat.addingCategory(data);
	  
	  test.log(LogStatus.INFO, "successfully added category of:  " + data);
	}
	
	
	@Test(dataProvider="InputExpense", dataProviderClass=expenseMain.TestData.class)
	   public void addMyExpenses(String day, String month, String year, String cd, String amt, String rsn) {
		test = report.startTest("verify expense add");
	 	  try {
	 		
	 		ManageExpense.addExpenses(day, month, year, cd, amt, rsn);
	 		test.log(LogStatus.INFO, "successfully added expense");
	 	} catch (Exception e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 	  
	}
	
	/* deletes the first category if there is no corresponding expense entry for it */
	@Test
 	public void deleteMyCategory() throws Exception {
		test = report.startTest("verify deletion of first Category");
 		addCat.deleteCategory();
 		test.log(LogStatus.PASS, "successfully deleted Category");
 	}


 	  
   
	/* deletes the first expense in the listed expenses */
  @Test
	public void deleteMyExpense() throws Exception {
	  test = report.startTest("verify deletion of first expense");
	  ManageExpense.deleteExpenses();
	  test.log(LogStatus.PASS, "successfully deleted expense");
   }




	@AfterTest(enabled = true, alwaysRun = true)
	public void closeBrowser() {
		try {

			
			driver.close();
			test.log(LogStatus.INFO, "closed the expense website");
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void cleanup() {
		report.endTest(test);
		report.flush();
	}

}

