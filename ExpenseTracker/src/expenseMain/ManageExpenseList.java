package expenseMain;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageExpenseList extends ExpenseBase  {
	ExpenseBase homePage = new ExpenseBase(driver);
	@FindBy(id = "day")
	private static WebElement dayOfExpense;
	
	@FindBy(id = "month")
	private static WebElement monthOfExpense;
	
	@FindBy(id = "year")
	private static WebElement yearOfExpense;
	
	@FindBy(id = "category")
	private static WebElement typeCategory;
	
	@FindBy(id = "amount")
	private static WebElement expenseAmount;
	
//	@FindBy(xpath = "//option[contains(text(),\'books\')]")
//	private static WebElement booksCat;
	
	@FindBy(id = "submit")
	private static WebElement submitExpense;
	
	@FindBy(id = "reason")
	private static WebElement reasonOfExpense;
	
	@FindBy(xpath= "//*[@title='delete expense']")
	private static WebElement delExpense;
	
	public ManageExpenseList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Add expenses
	public void addExpenses(String day, String month, String year, String cd, String amt, String rsn) throws Exception {
		homePage.addExpense();
		dayOfExpense.clear();
		dayOfExpense.sendKeys(day);
		monthOfExpense.clear();
		monthOfExpense.sendKeys(month);
		yearOfExpense.clear();
		yearOfExpense.sendKeys(year);
		
		Select CatDrpdwn = new Select(typeCategory);
		CatDrpdwn.selectByVisibleText(cd); 
		
		expenseAmount.sendKeys(amt);
		reasonOfExpense.sendKeys(rsn);
		submitExpense.click();
	}
	
	
	
	//delete expenses
	public void deleteExpenses() {
			try {
				homePage.listExpense();
				delExpense.click();
			//	Thread.sleep(3000);
				Alert a1 = driver.switchTo().alert();
				   String alertText = a1.getText();
				   System.out.println("Alert text is " + alertText);
			//	   Thread.sleep(3000);
				   a1.accept();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	 
	
	}
	


