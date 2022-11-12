package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class thread2Category2 {
	public WebDriver driver;
	public WebDriverWait wait;

	public thread2Category2() {
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
		
		//add Thread 1 to Category 2
		driver.findElement(By.xpath("//a[contains(.,'sed primis periculis ad')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'btn btn-primary btn-sm')]")));
		driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary btn-sm')]")).click();
		Thread.sleep(2000);
		
		//create Subject of Thread
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='_com_liferay_message_boards_web_portlet_MBPortlet_subject']")));
		driver.findElement(By.xpath("//input[@id='_com_liferay_message_boards_web_portlet_MBPortlet_subject']")).sendKeys("Est n� poste� perpetu�");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='_com_liferay_message_boards_web_portlet_MBPortlet_subject']")));
		
		//create Body of Thread
		driver.findElement(By.xpath("//*[@class = 'cke_wysiwyg_frame cke_reset']")).click();
			driver.switchTo().activeElement().sendKeys("Dolore delenit ea me�, sit p�sse nullam ad. M�zim saperet �d eam. In nec erroribus consequ�t definitionem. "
					+ "Quo doctus iracundi� ut, viris oblique definitiones at n�m, an vis saepe corrumpit.\r\n" + 
					"\r\n" + 
					"Est n� poste� perpetu�, cum e� consul dignissim, feugiat verterem postulant pro ne. Nec rebum libris copiosae �d. N� cum augue moder�tius �ccommod�re, "
					+ "ne meis offendit ref�rmidans pro, iudico libris ut me�. Vim molestie pericul� et. Et hinc m�gn� interesset per, eos eu noster suscipit. Ius �ntiopam m�lesti�e �d, scripta nomin�vi vis te.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lfr-btn-label")));
		driver.findElement(By.className("lfr-btn-label")).click();
		
		//check
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'sed primis periculis ad')]")).click();
		if(driver.findElements(By.xpath("//a[contains(.,'Est n� poste� perpetu�')]")).size() != 0){
			System.out.println("create thread berhasil");
		}
		else {
			System.out.println("create thread gagal");
		}
	}
}
