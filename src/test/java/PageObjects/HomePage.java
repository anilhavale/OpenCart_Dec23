package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		
		super(driver);
		
	}
	
	
	// Elements
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement link_MyAccount;
	
	
	@FindBy(linkText = "Register")
	WebElement linkRegister;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement txt_login;
	
	
	// Action Methods
	public void clickMyAccount()
	{
		link_MyAccount.click();
	}
	
	
	public void clickRegister()
	{
		linkRegister.click();
	}
	
	
	public void clickOnLogin()
	{
		txt_login.click();
	}
	
	
}
