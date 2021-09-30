package week4.day2;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder = new Actions(driver);
		
		driver.get("https://www.nykaa.com/");
		WebElement brandsTab =	driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brandsTab).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris"+Keys.ENTER);
		driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")).click();
		//Title Verification
		if(driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("Title Verification Succesful!");
		}else {
			System.out.println("Title Verification Unsuccessful!");
			driver.quit();
		}
		//Applying Filters
		driver.findElement(By.xpath("//span[@title='POPULARITY']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		WebElement filterElement1 = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		String filterText1 = filterElement1.getText();
		filterElement1.click();
		driver.findElement(By.xpath("//div[text()='Concern']")).click();
		WebElement filterElement2 = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		String filterText2 = filterElement2.getText();
		filterElement2.click();
		String firstFilter = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li[1]")).getText();
		String secondFilter = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li[2]")).getText();
		//Filters Verification
		if((firstFilter.contains(filterText1)) && (secondFilter.contains(filterText2))) {
			System.out.println("Filters are matched!");
		} else {
			System.out.println("Filters not matched!");
			driver.quit();
		}				
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//h2[@title=\"L'Oreal Paris Colour Protect Shampoo\"])[1]")).click();
		Set<String>totalWindows = driver.getWindowHandles();
		for(String eachWindow:totalWindows) {
			driver.switchTo().window(eachWindow);
		} 
		//Adding the Product to Cart
		 driver.findElement(By.xpath("//span[text()='175ml']")).click();
		 driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
		 driver.findElement(By.xpath("(//button[text()='ADD TO BAG'])[1]")).click();
		 driver.findElement(By.xpath("//div[@class='cursor-hand arrowup-tooltip']//div[1]")).click();
		 driver.findElement(By.xpath("//*[@id=\'headerWpr\']/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/div[2]/button")).click();
		String grandTotalStr = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='vernacular-string'])[13]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String grandTotalCheckOutStr =driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		//GrandTotal Check
		if(grandTotalStr.equals(grandTotalCheckOutStr)) {
			System.out.println("Costs are same!");
		}
		System.out.println("completed");
		driver.quit();
	}
	

}
