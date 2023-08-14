package Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.idealized.Javascript;

public class HomePage extends BasePage{
	
	public HomePage(){
		super();
	}
	
	By enterEmailYOP = By.xpath("//input[@id='login']");
	By location = By.xpath("(//div[@class='bwc__sc-ttnkwg-17 gvzyfS'])[3]");
	By signInBtn = By.xpath("//div[@class='bwc__sc-1nbn7v6-14 khhVFa']");
	By enterEmail  = By.xpath("//input[@id='emailId']");
	By continueWithEmail = By.xpath("(//div[@class='bwc__sc-dh558f-14 fPrBPf'])[2]");
	By continueBtn = By.xpath("//button[@class='bwc__sc-dh558f-37 hmbiuL']");
	By otp = By.xpath("/html[1]/body[1]/div[2]/div[2]/button[1]//div[2]");
	By OtpbBoxes = By.xpath("//input[@type='tel']");
	By otpContinueBtn = By.xpath("//button[@class='bwc__sc-dh558f-43 bIAzbS']");
	
	
	public void clickOnBanglore()
	{
		driver.findElement(location).click();
	}
	
	public void clickOnSignInBtn()
	{
		driver.findElement(signInBtn).click();
	}
	
	public void clickOnContinueWithEmail() throws InterruptedException
	{
		driver.findElement(continueWithEmail).click();
		
		Thread.sleep(3000);
	}
	
	
	public void enterEmail(String email)
	{
		driver.findElement(enterEmail).sendKeys(email);;
	}
	
	public void clickOnContinueBtn() throws InterruptedException
	{
		driver.findElement(continueBtn).click();
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB).get("https://yopmail.com/");;
		
		Set<String> win = driver.getWindowHandles();
		
		Iterator<String> iter = win.iterator();
		String ParWin = iter.next();
		String childWin = iter.next();
		driver.switchTo().window(childWin);
		enterEmailInYOP("selauto@yopmail.com");
		
		String no = getOtp();
		driver.switchTo().window(ParWin);
		
		List<WebElement> we = driver.findElements(OtpbBoxes);
		
		String [] arr = no.split("");
			int [] otp = {Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]),Integer.parseInt(arr[5])};
				int cnt=0;
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				for(WebElement ele : we)
				{
					if(cnt==0)
					{
						ele.sendKeys(String.valueOf(otp[0]));
					}else if(cnt==1)
					{
						ele.sendKeys(String.valueOf(otp[1]));
					}else if(cnt==2)
					{
						ele.sendKeys(String.valueOf(otp[2]));
					}else if(cnt==3)
					{
						ele.sendKeys(String.valueOf(otp[3]));
					}else if(cnt==4)
					{
						ele.sendKeys(String.valueOf(otp[4]));
					}else if(cnt==5)
					{
						ele.sendKeys(String.valueOf(otp[5]));
					}
						
					cnt++;
				}
				
				
	}
	
	public void enterEmailInYOP(String email)
	{
		driver.findElement(enterEmailYOP).sendKeys(email,Keys.ENTER);
		
	}
	
	public String getOtp() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='refresh']")).click();
		WebElement frame = driver.findElement(By.name("ifinbox"));
		driver.switchTo().frame(frame);
		String str = driver.findElement(otp).getText();
		String[] otp = str.split(" ");
			System.out.println(otp[0]);
		return otp[0];
		
	}
	
	public void clickOnOtpContinueBtn()
	{
		driver.findElement(otpContinueBtn).click();
	}
	
}
