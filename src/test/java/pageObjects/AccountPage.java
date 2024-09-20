package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountPage extends BasePage {
	public AccountPage(WebDriver driver){		
		super(driver);	
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement txtAccount;

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;

	public boolean accountText() {


		try {
			return (txtAccount.isDisplayed());
		}
		catch(Exception e) {
			
			return(false);
		}
	}
	
	public void clickLogout() {
		logout.click();
	}
}
