package expenseMain;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageCategory extends ExpenseBase  {
	ExpenseBase homePage = new ExpenseBase(driver);
	@FindBy(id = "name")
	private static WebElement InsertCategory;
	
	@FindBy(id = "submit")
	private static WebElement SubmitCategory;
	
	@FindBy(id = "reset")
	private static WebElement resetCategory;
	
	@FindBy(id = "go_add_category")
	private static WebElement insertCat;
	
	@FindBy(xpath="//img[contains(@title,'delete category')]")
	private static WebElement delCat;
	
	
	public ManageCategory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//@Test(dataProvider="inputs", dataProviderClass=AddExpenseData.class)
	public void addingCategory(String data) {
		
		try {
			homePage.listCategory();
			insertCat.click();
			InsertCategory.sendKeys(data);
			SubmitCategory.click();
			System.out.println("in base addin cat:" + data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void deleteCategory() {
		//This method deletes the first category present
		try {
			homePage.listCategory();
			delCat.click();
			//Thread.sleep(3000);
			Alert a1 = driver.switchTo().alert();
			   String alertText = a1.getText();
			   System.out.println("Alert text is " + alertText);
			   
			   a1.accept();
			   
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
	


