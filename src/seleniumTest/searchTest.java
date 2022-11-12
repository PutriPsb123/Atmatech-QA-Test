package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public searchTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8080/c/portal/login");
		wait = new WebDriverWait(driver, 5);
	}
	
	@Test
	public void program() throws Throwable{
				//login
				driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).clear();
				driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).sendKeys("ebensiagian99@gmail.com");
				driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password")).sendKeys("1122334455");
				driver.findElement(By.className("lfr-btn-label")).click();
				Thread.sleep(4000);
				
				//control panel
				driver.findElement(By.cssSelector("button.lfr-portal-tooltip")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@href = 'http://127.0.0.1:8080/group/test-site-20200810-140515']")).click();
				Thread.sleep(2000);
				
				//search
				driver.findElement(By.xpath("//input[@id='dkrk___q']")).sendKeys("Enim repudiandae");
				driver.findElement(By.xpath("//button[@class='btn btn-monospaced btn-unstyled']")).click();
				
				//check
				if(driver.findElements(By.xpath("//*[contains(@class, 'search-total-label')]")).size() != 0) {
					System.out.println("pencarian berhasil");
				}
				else {
					System.out.println("perncarian gagal");
				}
	}
}
