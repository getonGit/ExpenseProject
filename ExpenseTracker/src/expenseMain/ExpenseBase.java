package expenseMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExpenseBase  {

	public WebDriver driver;
	
	
	public ExpenseBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	// Using page factory FindBy method to find all the elements in this page
	
	@FindBy(id = "go_add_expense")
	private static WebElement addExpenses;
	
	@FindBy(id = "go_list_expenses")
	private WebElement listExpenses;
	
	@FindBy(id = "go_list_categories")
	private WebElement listCategories;
	
	@FindBy(id = "go_show_statistics")
	public WebElement showStats;
	
	@FindBy(id = "editaccount")
	public WebElement editAccount;

	@FindBy(id = "logout")
	public WebElement logout;

	@FindBy(xpath = "//a[contains(text(),'Register new user')]")
	public WebElement regNewUser;

	
	// Defining all the user actions (Methods) that can be performed in this page
	
	public void addExpense() throws Exception {
		addExpenses.click();
		//ManageExpenseList.addExpenses();
//		driver.findElement(By.id("day")).clear();
//		  driver.findElement(By.id("day")).sendKeys("2");
//		  driver.findElement(By.id("month")).clear();
//		  driver.findElement(By.id("month")).sendKeys("5");
//		  driver.findElement(By.id("year")).clear();
//		  driver.findElement(By.id("year")).sendKeys("2019");
//			
//			Select CatDrpdwn = new Select(driver.findElement(By.id("category")));
//			CatDrpdwn.selectByValue("1002");
//			
//			driver.findElement(By.id("amount")).sendKeys("9");
//			driver.findElement(By.id("reason")).sendKeys("metaphysics");
//			driver.findElement(By.id("submit")).click();
	}
	
	public void listExpense() throws Exception {
		listExpenses.click();
				
	}
	
	public void listCategory() throws Exception {
		listCategories.click();
	}
	
	public void displayStats() throws Exception {
		showStats.click();
				
	}
	public void registerNewUser() throws Exception {
		
		regNewUser.click();
	}
	
    public void editAccount() throws Exception {
		
    	editAccount.click();
	}
    public void logoutUser() throws Exception {
		
    	logout.click();
	}
	
    public void loginUser() {
    
    }
	}


