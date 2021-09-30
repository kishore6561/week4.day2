package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTable
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		WebElement from = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement to= driver.findElement(By.xpath("//ol[@id='selectable']/li[7]"));
		action.clickAndHold(from).perform();
		action.moveToElement(to);
		action.click().perform();
		System.out.println("Selected");
	}

}