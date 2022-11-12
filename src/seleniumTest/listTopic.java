package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class listTopic {

	public WebDriver driver;
	
	public listTopic() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://brand.netray.id");
	}
	
	@Test
	public void programs() throws Throwable {
		driver.get("https://brand.netray.id/login");
		driver.manage().window().maximize();
		
		//login
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("putri88");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("loginButton")).click();
		
		Thread.sleep(6000);
		
		//validasi
		Thread.sleep(5000);
		if(driver.findElements(By.id("title")).size() != 0){
			System.out.println("test berhasil");
		}
		else {
			System.out.println("test gagal");
		}
		 
		driver.close();
		}
}
