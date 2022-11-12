package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createCategory2 {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public createCategory2() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:8080/c/portal/login");
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
		
		//go to forum widget page
		driver.get("http://127.0.0.1:8080/group/test-site-20200810-140515/forum");
		Thread.sleep(3000);;
		
		
		//add category
		driver.findElement(By.xpath("//*[contains(@class,'btn btn-secondary btn-sm')]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='_com_liferay_message_boards_web_portlet_MBPortlet_name']")));
		driver.findElement(By.xpath("//input[@id='_com_liferay_message_boards_web_portlet_MBPortlet_name']")).sendKeys("Ei reprimique intellegam eos");
		driver.findElement(By.xpath("//textarea[@id='_com_liferay_message_boards_web_portlet_MBPortlet_description']")).sendKeys("Id eum homero feugiat principes, id vel graeci hendrerit constituto. Nec in graeco eruditi ancillae. Vel te meis aeque, usu scripserit temporibus an. Ad nam apeirian scribentur, nec dico albucius adolescens ei. Ex graecis delicatissimi eum, ad vel fugit aliquando accommodare, inani ridens suscipit usu ea.\r\n" + 
				"\r\n" + 
				"Esse perpetua urbanitas an mel. Ei nec brute deterruisset. Scripta minimum voluptua nam ex. Usu eu vero consul, atqui interesset at pro.");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lfr-btn-label")));
		driver.findElement(By.className("lfr-btn-label")).click();
		
		//Check
		Thread.sleep(5000);
		
		if(driver.findElements(By.xpath("//a[contains(.,'Ei reprimique intellegam eos')]")).size() != 0){
			System.out.println("create category berhasil");
		}
		else {
			System.out.println("create category gagal");
		}
		
		
	}
}
