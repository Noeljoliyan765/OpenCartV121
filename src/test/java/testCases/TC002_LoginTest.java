package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("***starting tc_002***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.username("noeljoliyan765@gmail.com");
		lp.password("#Ry(z75dGnWT");
		lp.loginbtn();
		
		AccountPage ap=new AccountPage(driver);
		boolean state=ap.accountText();
		Assert.assertEquals(state, true);
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("***finishing tc_002***");
	}

}
