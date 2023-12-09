package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(name = "firstname")
	WebElement txt_first_name;
	
	
	@FindBy(name="lastname")
	WebElement txt_last_name;
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(name="confirm")
	WebElement confirm_pwd;
	
	@FindBy(name="agree")
	WebElement checkedPolicy;
	
	@FindBy(xpath ="//input[@class='btn btn-primary']")
	WebElement button;
	
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
		
	
	// Action Methods
	
	public void setFirstName(String fname)
	{
		txt_first_name.sendKeys(fname);
	}
	
	public void setlastName(String lname)
	{
		txt_last_name.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		 txt_email.sendKeys(email);
	}
	
	public void setTelephoneNumber(String tel)
	{
		txt_telephone.sendKeys(tel);
	}
	
	public void setpassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
	confirm_pwd.sendKeys(pwd);	
	}
	
	
	public void setPrivacyPolicy()
	{
		checkedPolicy.click();
	}
	
	public void ClickOnContinue()
	{
		button.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
		return msgConfirmation.getText();
		}
		
		catch (Exception e) 
		{
			return (e.getMessage());
		
		}
	}
	
}
