package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	Properties prop;
	static public WebDriver driver;
	protected BasePage()
	{
		String fileName = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties"; 
		try {
			FileInputStream fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error in file Path...!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in file Loading...!!");
		}
	}
	
	public void init()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("EDGE"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else
			
			throw new RuntimeException("Invalid Browser");
		
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
}
