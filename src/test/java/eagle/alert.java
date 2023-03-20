package eagle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert {
public static String url ="https://demoqa.com/alerts/";
WebDriver driver;
@BeforeTest
public void bt() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
}
@Test
public void click() {
	driver.findElement(By.id("alertButton")).click();
	Alert alt = driver.switchTo().alert();
	System.out.println(alt);
}

}
