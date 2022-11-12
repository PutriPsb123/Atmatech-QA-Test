package seleniumTest;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class createSite {
	public WebDriver driver;
	public WebDriverWait wait;
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    
	private final String sitename = "test-site-"+strDate;
	
	public createSite() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8080/c/portal/login");
		wait = new WebDriverWait(driver, 7);
	}
	
	@Test
	public void programs() throws Throwable {
		driver.get("http://127.0.0.1:8080/c/portal/login");
		driver.manage().window().maximize();
		System.out.println("Sitename sebelum login"+sitename);
		
		//login
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).clear();
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).sendKeys("ebensiagian99@gmail.com");
		driver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password")).sendKeys("1122334455");
		driver.findElement(By.className("lfr-btn-label")).click();
		Thread.sleep(4000);
		
		//control panel
		driver.findElement(By.cssSelector("button.lfr-portal-tooltip")).click();
		driver.get("http://127.0.0.1:8080/group/control_panel/manage/-/sites/sites?p_v_l_s_g_id=20122&p_p_auth=FY3f34XP");
		driver.findElement(By.cssSelector(".lexicon-icon-plus > path:nth-child(1)")).click();
		Thread.sleep(3000);
		
		//creating site
		driver.findElement(By.xpath("//*[contains(@class,'card-body')][contains(., 'Intranet Site')]/parent::*")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'card-body')][contains(., 'Intranet Site')]/parent::*")));
		
		//site name has to be unique,change site name below
		driver.findElement(By.id("_com_liferay_site_admin_web_portlet_SiteAdminPortlet_name")).sendKeys(sitename);
		driver.findElement(By.xpath("//*[contains(@type, 'checkbox')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(5000);
		System.out.println("Sitename sebelum go to"+sitename);
		
		//go to
		
		if(driver.findElements(By.xpath("//*[contains(@class, 'fade modal d-block')]")).size() == 0) {
			driver.findElement(By.cssSelector("button.lfr-portal-tooltip")).click();
		}
		driver.get("http://127.0.0.1:8080/group/control_panel/manage/-/sites/sites?p_v_l_s_g_id=20122&p_p_auth=FY3f34XP");
		driver.navigate().refresh();
		Thread.sleep(10000);
		if(driver.findElements(By.xpath("//a[contains(., '"+sitename+"')]")).size() != 0) {
			
			System.out.println("Create Site berhasil");
		}
		
		else {
			System.out.println("Create Site gagal");
		}
		
	}
}
