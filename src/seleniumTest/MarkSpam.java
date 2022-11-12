package seleniumTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MarkSpam {

public WebDriver driver;
	
	public MarkSpam() {
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
		driver.wait();
		
		// Locating the Main Menu (Parent element)
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"accordion\"]"));

		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(mainMenu);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"accordion\"]/div/div/header/div/button"));

		//To mouseover on sub menu
		actions.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/p[2]/button[1]")).click();
		
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
