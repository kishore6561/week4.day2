package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DRaggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		action.clickAndHold(draggable).perform();
		action.moveByOffset(100, 100).perform();
		action.release().perform();
		
		

	}

}
