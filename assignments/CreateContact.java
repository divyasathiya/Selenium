package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Divya_Test");
		driver.findElement(By.id("lastNameField")).sendKeys("Sathiyanarayanan_Test");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Div_Test");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Sathiya_Test");
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("ECE");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is to check create Contact scenario is automated");
		driver.findElement(By.xpath("(//input[@name='primaryEmail'])[4]")).sendKeys("Test@1234.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select option1 = new Select(state);
		option1.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Create Contact is working");
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
	}

}
