package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void accReg() {

		logger.info("*****Starting TC001_AccountRegistration****** ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			hp.clickRegister();
			logger.info("*****Providing customer details****** ");
			RegistrationPage reg = new RegistrationPage(driver);
			reg.fname(randomString().toUpperCase());
			reg.lname(randomString().toUpperCase());
			reg.email(randomString() + "@gmail.com");
			reg.tel(randomNo());

			String psswd = randomAlphanumeric();
			reg.pwd(psswd);
			reg.confpwd(psswd);
			reg.privacy();
			reg.submit();

			Assert.assertEquals(reg.message(), "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("***debug logs****");
			Assert.fail();
		}
		logger.info("*****Finished****** ");

	}

}
