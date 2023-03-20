package eagle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class guru {
	public static  String url="https://demo.guru99.com/test/newtours/index.php";
	WebDriver driver;
	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
@Test
public void login() throws InterruptedException {
	String beforelogin=driver.getTitle();
	System.out.println(driver.getTitle());
	WebElement a = driver.findElement(By.name("userName"));
	a.sendKeys("user");
	WebElement b = driver.findElement(By.name("password"));
	b.sendKeys("user");
	WebElement c = driver.findElement(By.name("submit"));
    c.click();
    Thread.sleep(3000);
    System.out.println("login successfull");
    String afterlogin=driver.getTitle();
	System.out.println(driver.getTitle());
	if(beforelogin.equals(afterlogin)) {
		System.out.println("Titles are same");
	}
	else
	{
		System.out.println("Titles are different");
	}
	WebElement d = driver.findElement(By.xpath("//*[@href='register.php']"));
	d.click();
	driver.findElement(By.name("firstName")).sendKeys("kaveri");
	driver.findElement(By.name("lastName")).sendKeys("anamala");
	driver.findElement(By.name("phone")).sendKeys("987654321");
	driver.findElement(By.name("userName")).sendKeys("kaveri.a@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.name("address1")).sendKeys("AECS");
    driver.findElement(By.name("city")).sendKeys("banglore");
    driver.findElement(By.name("state")).sendKeys("karnataka");
    driver.findElement(By.name("postalCode")).sendKeys("517305");
   // Actions act = new Actions(driver);
    WebElement e = driver.findElement(By.name("country"));
    //act.contextClick(e).build().perform();
    Select s= new Select(e);
    s.selectByVisibleText("INDIA");
    Thread.sleep(2000);
    driver.findElement(By.name("email")).sendKeys("kaveri.a@gmail.com");
    driver.findElement(By.name("password")).sendKeys("kavya");
    driver.findElement(By.name("confirmPassword")).sendKeys("kavya");
    Thread.sleep(2000);
    driver.findElement(By.name("submit")).click();
    System.out.println("Thank you for Regestering");
    
    List<WebElement> k = driver.findElements(By.tagName("a"));
	System.out.println(k.size());
    for(int i =0;i<k.size();i++) {
	//System.out.println(k.get(i).getText());
	//System.out.println(k.get(i).getAttribute("href"));
	String workinglink = k.get(i).getAttribute("href");
	String notworking = "https://demo.guru99.com/test/newtours/support.php";
	if(workinglink.equals(notworking)) {
		System.out.println("links are under construction" + k.get(i).getText());
	}
	else {
		System.out.println("links are working" + k.get(i).getText());
	}
    }
}
    @Test
    public void signoff() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement i= driver.findElement(By.xpath("//*[@href='index.php']"));
    	i.click();
    	System.out.println("signoff");
    }
@AfterTest
public void at() {
	driver.close();
}

}

