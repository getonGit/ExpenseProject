package expenseMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegistration {
	WebDriver driver;
	@FindBy(id = "login")
	private static WebElement userName;
	
	@FindBy(id = "password1")
	private static WebElement pswrd;
	
	@FindBy(id = "password2")
	private static WebElement ConfPswrd;
	
	@FindBy(id = "reset")
	private static WebElement reset;
	
	@FindBy(id = "submit")
	private static WebElement submit;


public NewUserRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


public void registerUser(String user, String password1, String password2) {
	
	//userName
	userName.sendKeys(user);
		
	//password and confirm
	pswrd.sendKeys(password1);
	ConfPswrd.sendKeys(password2);
	
	submit.click();
	
}
}