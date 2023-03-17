package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Input {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='j_idt88:name']")).sendKeys("Divya Sathiyanarayanan");
		String str = driver.findElement(By.xpath("//input[@value='Chennai']")).getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys(str + " India");
		boolean b = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt93']")).isDisplayed();
		if (b == true) {
			System.out.println("Text box is disabled");
		} else {
			System.out.println("Text box is enabled");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		Thread.sleep(2000);
		String str1 = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']")).getAttribute("value");
		System.out.println(str1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("abc@gmail.com" + Keys.TAB);
		WebElement elementA = driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']"));
		Actions action = new Actions(driver);
		action.moveToElement(elementA).click();
		if (action.moveToElement(elementA) != null) {
			System.out.println("Confirmed control moved to next element");
		} else {
			System.out.println("No control moved");
		}
		elementA.sendKeys("Selenium-Java webdriver learning is super interesting!");
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("I like to learn a lot about Selenium automation. Quite interesting");
		driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		String str2 = driver.findElement(By.xpath("//span[@class='ui-message-error-detail']")).getText();
		if (str2.contains("Age is mandatory")) {
			System.out.println("Yes, Error message is displayed");
		} else {
			System.out.println("Error message is not displayed");
		}
		Thread.sleep(2000);
		Point po1 = driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
		Point po2 = driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
		if (po1.equals(po2)) {
		   System.out.println("Label position is same." + po1);
		} else {
			System.out.println("Label position is different" + po1 + po2);
		}
		
		driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']")).sendKeys("Divya Sathiyanarayanan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='2']")).click();
		
		driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).sendKeys("02/11/1991");
		String date = driver.findElement(By.xpath("//a[@class=' ui-state-default ui-state-active']")).getText();
		System.out.println(date);
		driver.findElement(By.linkText(date)).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='j_idt106:j_idt118_input']")).sendKeys("35");
		driver.findElement(By.xpath("//a[contains(@class,'ui-spinner-button ui-spinner-up')]")).click();
		
		driver.findElement(By.xpath("//input[@id='j_idt106:slider']")).sendKeys("55");
		String value = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")).getAttribute("style");
		System.out.println(value);
		
		driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']")).click();
		boolean key = driver.findElement(By.xpath("//div[contains(@class,'ui-shadow keypad-popup ui-input-overlay')]")).isEnabled();
		
		if (key == true) {
			System.out.println("Keyboard is displayed");
		} else {
			System.out.println("Keyboard is not displayed");
		}
		
		driver.findElement(By.xpath("//div[@data-placeholder='Enter your content']")).sendKeys("Name of center:");
		driver.findElement(By.xpath("//button[@class='ql-italic']//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-placeholder='Enter your content']")).sendKeys(" TestLeaf");
		
	}

}
