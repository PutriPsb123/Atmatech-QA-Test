package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createArticle {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public createArticle() {
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
		
		//go to article page
		driver.get("http://127.0.0.1:8080/group/test-site-20200810-140515/article");
		Thread.sleep(3000);
		
		//go to new entry
		driver.findElement(By.xpath("//*[contains(@class,'btn btn-primary btn-sm')][contains(.,'New Entry')]")).click();
		Thread.sleep(5000);
		
		//create article
		driver.findElement(By.xpath("//textarea[@id='_com_liferay_blogs_web_portlet_BlogsAdminPortlet_title']")).sendKeys("Eu has elit put�nt postul�nt");
		driver.findElement(By.xpath("//textarea[@id='_com_liferay_blogs_web_portlet_BlogsAdminPortlet_subtitle']")).sendKeys("I have elit put�nt postul�nt");
		driver.findElement(By.xpath("//*[@name = '_com_liferay_blogs_web_portlet_BlogsAdminPortlet_contentEditor']")).click();
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys(" Eam u� f�cer v�cibus voluptatum, mei �d pr�esent scrib�ntur, n�squam rationibus ne s�t. Vivendum c�nc�ptam pr� ad, "
				+ "eos v�rear �ccus�m�s temporibus e�. N� qui euripi�is v�tuperatoribus. �d q�i m�do postulant.\r\n" + 
				"\r\n" + 
				"Ferri p�p�lo civibus �u� n�, �t �icat facilisi �nt�llegam mel, vix cu �ebet vider�r impedi�. Sit laudem l�ber�visse no, per �t �etraxit cotidieque deterru�sset, "
				+ "c� mediocrem sadipscing se�. �� impe�it perpetua vulputate �os. Op�rt�re urb�nitas expetendis vim ne, vel cibo verear accusam an. His ex ullum �ltera postea. "
				+ "Accusamus a��lescens n� eum, his te error alt�rum voluptat�b�s, nam �u m�is civibus.");
		driver.findElement(By.xpath("//button[@id='_com_liferay_blogs_web_portlet_BlogsAdminPortlet_publishButton']")).click();
		
		//check
		Thread.sleep(10000);
		if(driver.findElements(By.xpath("//a[contains(., 'Eu has elit put�nt postul�nt')]")).size() != 0) {
			System.out.println("Blog berhasil dibuat");
		}
		else {
			System.out.println("Blog gagal dibuat");
		}
	}
}
