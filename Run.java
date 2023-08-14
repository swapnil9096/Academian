package Runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.HomePage;

public class Run extends BasePage{
	
	Run()
	{
		super();
	}
	
	HomePage hp;
	@BeforeMethod
	
	public void setUp()
	{
		init();
		hp = new HomePage();
	}

	@Test
	public void TestCode() throws InterruptedException
	{
		hp.clickOnBanglore();
		Thread.sleep(3000);
		hp.clickOnSignInBtn();
		Thread.sleep(3000);
		hp.clickOnContinueWithEmail();
		Thread.sleep(3000);
		hp.enterEmail("selauto@yopmail.com");
		Thread.sleep(3000);
		hp.clickOnContinueBtn();
		Thread.sleep(3000);
		hp.clickOnOtpContinueBtn();
		
	}
}
