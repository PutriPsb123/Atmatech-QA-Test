package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TopComplaints {



	public WebDriver driver;
	
	public TopComplaints() {
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
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div/div/div[1]/div/div[2]/div/div")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div/div[2]/div/div/div[4]/div[7]/div/div/div/div[1]/div[1]/p")).click();
		
		//validasi
		Thread.sleep(5000);
		if(driver.findElements(By.className("text-truncate")).size() != 0){
			System.out.println("test berhasil");
		}
		else {
			System.out.println("test gagal");
		}
		 
		driver.close();
		}
}
