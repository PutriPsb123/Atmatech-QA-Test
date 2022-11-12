package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class landingPage {
	public WebDriver driver;
	
	public landingPage() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8080");
	}
	
	@Test
	public void programs() throws Throwable {
		driver.get("http://127.0.0.1:8080");
		
		if(driver.findElements(By.xpath("//*[contains(@id, 'fragment-0-typw')]")).size() != 0) {
			System.out.println("View Landing Page berhasil");
		}
		else {
			System.out.println("View Landing Page gagal");
		}
		}
}