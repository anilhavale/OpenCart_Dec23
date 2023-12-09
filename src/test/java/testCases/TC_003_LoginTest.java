package testCases;

import org.testng.annotations.*;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import junit.framework.Assert;
import testBase.BaseClass;

public class TC_003_LoginTest extends BaseClass
{

	
	
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		
		try
		{
		
		logger.info("**  starting TC_003_Login **");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		
		hp.clickOnLogin();
		
		
		
		LoginPage lp = new LoginPage(driver);
		
		
		
		lp.setEmail(rb.getString("email"));
		
		 
		
		lp.setPassword(rb.getString("password"));
		
		lp.clickLogin();
		
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true);
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}
