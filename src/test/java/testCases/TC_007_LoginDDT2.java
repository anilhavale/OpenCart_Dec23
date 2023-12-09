package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataProviders;
import testBase.BaseClass;
 

public class TC_007_LoginDDT2 extends BaseClass
{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email, String password, String exp)
	{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage mac = new MyAccountPage(driver);
		boolean targetPage = mac.isMyAccountPageExists();
		
		
		if(exp.equals("Valid"))
		{
			if(targetPage== true)
			{
				mac.clickLogout();
				Assert.assertTrue(true);
			}
			
			else
			{
				Assert.assertTrue(false);
			}
		}
		

		if(exp.equals("Invalid"))
		{
			if(targetPage== true)
			{
				mac.clickLogout();
				Assert.assertTrue(true);
			}
			
			else
			{
				Assert.assertTrue(false);
			}
		}
		
	}
	
}
