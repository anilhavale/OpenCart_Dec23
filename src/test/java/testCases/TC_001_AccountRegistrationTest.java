package testCases;

import testBase.BaseClass;
import org.testng.annotations.*;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import junit.framework.Assert;

public class TC_001_AccountRegistrationTest  extends BaseClass
{

	
	@Test(groups= {"Sanity","Regression"})
	public void test_account_registration()
	{
		
		logger.debug(" Appliation Logs");
		logger.info("**** Starting TC_001_AccountRegistrationTest  ****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("**** Clicked On My Account  ****");
		
		hp.clickRegister();
		logger.info("**** Clicked On Register Link  ****");
		
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.setFirstName("asdfas1212");
		regPage.setlastName("zxcvas1221");
		regPage.setEmail("asdfzxcva2s112@gmail.com");
		regPage.setTelephoneNumber("123145959121");
		regPage.setpassword("Password@1234");
		regPage.setConfirmPassword("Password@1234");
		
		regPage.setPrivacyPolicy();
		
		Thread.sleep(5000);
		
		regPage.ClickOnContinue();
		
		Thread.sleep(5000);
		
		String confMSG = regPage.getConfirmationMsg();
		
		//Assert.assertEquals(confMSG,"Your Account Has Been Created!", " not Getting Expected Message ");
		Assert.assertEquals(confMSG,"Your Account Has Been Created!");
		}
		
		catch (Exception e) 
		{
			logger.error("Test Failed");
			
			Assert.fail();
		}
		
	}
	
	

}
