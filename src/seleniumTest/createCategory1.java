package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createCategory1 {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public createCategory1() {
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
		driver.findElement(By.xpath("//input[@id='_com_liferay_message_boards_web_portlet_MBPortlet_name']")).sendKeys("sed primis periculis ad");
		driver.findElement(By.xpath("//textarea[@id='_com_liferay_message_boards_web_portlet_MBPortlet_description']")).sendKeys("Usu id facilisis consequat. Pri ad brute atqui. Nam posse legimus patrioque et, per affert putent nostrud ne, at has tale nobis mediocrem. Te nec etiam possit. Cu omnesque rationibus eos.\r\n" + 
				"\r\n" + 
				"Eos ne sumo omittam, mea no tota facilisi necessitatibus, menandri lobortis eos ad. Eum similique consequuntur et, usu tacimates senserit mediocrem te. Te liber everti tincidunt vim, congue decore sit cu. Ex has idque liber persius. Eum case ancillae ei, ne sed propriae theophrastus voluptatibus, facer offendit vix in. Mel vitae dolore cu, tota ridens timeam duo ut, te eum rationibus incorrupte.\r\n" + 
				"");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lfr-btn-label")));
		driver.findElement(By.className("lfr-btn-label")).click();
		
		//check
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//a[contains(.,'sed primis periculis ad')]")).size() != 0){
			System.out.println("create category berhasil");
		}
		else {
			System.out.println("create category gagal");
		}
		
		
		
	}
}
