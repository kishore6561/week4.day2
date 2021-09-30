package week4.day2;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeel {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder = new Actions(driver); 
		
		driver.get("https://www.snapdeal.com/");
		WebElement mensFashion = driver.findElement(By.xpath("(//li[@class='navlink lnHeight']/a)[1]"));
		builder.moveToElement(mensFashion).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		WebElement sportsShoesElmnt = driver.findElement(By.xpath("//div[text()='Sports Shoes']//following::div"));
		sportsShoesElmnt.click();
		WebElement trainingShoesElmnt = driver.findElement(By.xpath("//div[text()='Training Shoes']/parent::a"));
		String trainingShoesString = trainingShoesElmnt.getText();
		trainingShoesElmnt.click();
		String sportsShoesString1 = driver.findElement(By.xpath("//div[text()='Sports Shoes']")).getText();
		String sportsShoesString2 = driver.findElement(By.xpath("(//span[@itemprop='title'])[5]")).getText();
		String trainingShoesString2 = driver.findElement(By.xpath("(//span[@class='active-bread'])")).getText();
		if((sportsShoesString1.contains(sportsShoesString2)) && trainingShoesString.contains(trainingShoesString2)) {
			System.out.println("Filters Verified!");
		}else {
			System.out.println("Filters don't match!");
			driver.quit();
		}
		driver.findElement(By.xpath("//div[@class='sort-selected']/following-sibling::i[1]")).click();
		WebElement priceSort = driver.findElement(By.xpath("//li[@data-sorttype='plth']"));
		builder.moveToElement(priceSort).perform();
		builder.click().perform();
		//Seek bar
		WebElement seekZero =driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll left-handle')]"));
		builder.clickAndHold(seekZero).perform();
		Thread.sleep(2000);
		builder.moveByOffset(60, 0).perform();
		builder.release().perform();
		Thread.sleep(2000);
		WebElement seekEnd = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll right-handle')]"));
		builder.clickAndHold(seekEnd).perform();
		builder.moveByOffset(-118,0).perform();
		builder.release().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Red']")).click();
		
		WebElement mouseHover =driver.findElement(By.xpath("//source[@class='product-image']/following-sibling::img[1]"));
		builder.moveToElement(mouseHover).perform();
		Thread.sleep(2000);
		WebElement quickSelect = driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
		builder.moveToElement(quickSelect).perform();
		builder.click().perform();
		builder.release().perform();
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Price of the product: Rs. "+price);
		System.out.println("Discount Applied for the product: "+discount);
		System.out.println("completed");
		driver.quit();
		
	}

}