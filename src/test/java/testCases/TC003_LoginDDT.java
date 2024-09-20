package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String exp) {
		try{
		HomePage hp = new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.username(email);
		lp.password(pwd);
		lp.loginbtn();
		
		AccountPage ap=new AccountPage(driver);
		boolean state=ap.accountText();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(state==true) {
				ap.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
			if(exp.equalsIgnoreCase("Invalid")) {
				if(state==true) {
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
		}
		}
		catch(Exception e) {
			Assert.fail();	}
	}

	}

