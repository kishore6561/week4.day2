package week4.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable 
{
 
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		WebElement from = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement to = driver.findElement(By.xpath("//ul[@id='sortable']/li[4]"));
		Point toLocation = to.getLocation();
		int xaxis = toLocation.getX();
		int yaxis = toLocation.getY();
		Actions action = new Actions(driver);
		action.clickAndHold(from).perform();
		action.moveByOffset(xaxis, yaxis);
		action.click().perform();
		System.out.println("sorteda");
	}

}