package testCases;

import testBase.BaseClass;
import org.testng.annotations.*;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import junit.framework.Assert;

public class TC_002_AccountRegistrationTest2  extends BaseClass
{

	
	@Test(groups= {"Master","Regression"})
	public void test_account_registration()
	{
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setlastName(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+"@gmail.com");
		regPage.setTelephoneNumber(randomeNumber());
		
		String passWord = randomAlphaNumeric();
		
		
		regPage.setpassword(passWord);
		regPage.setConfirmPassword(passWord);
		
		regPage.setPrivacyPolicy();
		
		regPage.ClickOnContinue();
		
		
		String confMSG = regPage.getConfirmationMsg();
		
		Assert.assertEquals(confMSG,"Your Account Has Been Created!");
		
		}
		
		catch (Exception e) 
		{
			
			Assert.fail();
		}
		
	}
	
	

}
