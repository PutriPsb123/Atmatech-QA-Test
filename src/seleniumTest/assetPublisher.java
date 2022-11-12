package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class assetPublisher {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public assetPublisher() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://brand.netray.id/");
		wait = new WebDriverWait(driver, 5);
	}
	
	@Test
	
	public void program() throws Throwable {
		driver.get("http://127.0.0.1:8080/c/portal/login");
		driver.manage().window().maximize();
		
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
		
		//go to home page
		driver.get("http://127.0.0.1:8080/group/test-site-20200810-140515/home");
		Thread.sleep(3000);
		
		//
		driver.findElement(By.xpath("//*[contains(@class, 'control-menu-nav-item')]//*[contains(@class,'lexicon-icon lexicon-icon-plus')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'collapse-icon collapse-icon-middle panel-toggler')][contains(., 'Widgets')]")));
		driver.findElement(By.xpath("//a[contains(@class, 'collapse-icon collapse-icon-middle panel-toggler')][contains(., 'Widgets')]")).click();
		driver.findElement(By.xpath("//*[contains(@class, 'input-group search-bar')]//*[contains(@id,'_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_searchContent')]")).click();
		driver.switchTo().activeElement().sendKeys("Asset Publisher");
		
		Actions actions = new Actions(driver);
		WebElement  target = driver.findElement(By.xpath("//*[contains(@id, '_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_portletCategory0')]//span[@class = 'taglib-icon-label'][contains(., 'Asset Publisher')]"));
		Thread.sleep(3000);
		actions.moveToElement(target).perform();
		WebElement click = driver.findElement(By.xpath("//*[contains(@id, '_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_portletCategory0')]//a[@class = 'add-content-item  sr-only sr-only-focusable']//span[@class = 'sr-only'][contains(., 'Asset Publisher')]"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, '_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_portletCategory0')]//a[@class = 'add-content-item  sr-only sr-only-focusable']//span[@class = 'sr-only'][contains(., 'Asset Publisher')]")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", click);
		
		//check 
		Thread.sleep(10000);
		if(driver.findElements(By.xpath("//div[contains(@class,'autofit-float autofit-row portlet-header')]//h2[contains(., 'Asset Publisher')]")).size() != 0) {
			System.out.println("Asset Publisher berhasil dibuat");
		}
		else {
			System.out.println("Asset Publisher gagal dibuat");
		}
	}
}

