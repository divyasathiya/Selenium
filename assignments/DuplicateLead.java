package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");;
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//div")).getText());
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//div//a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String text = driver.findElement(By.xpath("//div[@class='x-panel-header sectionHeaderTitle']")).getText();
		if (text.contains("Duplicate Lead")) {
			System.out.println("Yes! Title is printed as Duplicate Lead");
		} else {
			System.out.println("No! Title is not printed as Duplicate Lead");
		}
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String text2 = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		if (text2.contains("Kumaran")) {
			System.out.println("Yes! duplicated lead name is same as captured name");
		} else {
			System.out.println("No! duplicated lead name is not same as captured name");
		}
		Thread.sleep(2000);
		driver.close();
	}

}
