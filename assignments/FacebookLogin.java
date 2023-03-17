package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException{
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	    option.addArguments("--disable-notifications");
	    ChromeDriver drive = new ChromeDriver(option);
		drive.get("https://en-gb.facebook.com/");
		drive.manage().window().maximize();
		//drive.findElement(By.xpath("//button[text()='Only allow essential cookies']")).click();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drive.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		drive.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		drive.findElement(By.xpath("//input[@name='lastname']")).sendKeys("User");
		drive.findElement(By.name("reg_email__")).sendKeys("1234567890");
		drive.findElement(By.id("password_step_input")).sendKeys("TestPassword");
		WebElement date = drive.findElement(By.id("day"));
		WebElement month = drive.findElement(By.id("month"));
		WebElement year = drive.findElement(By.id("year"));
		Select dateElement = new Select(date);
		dateElement.selectByValue("11");
		Select monthElement = new Select(month);
		monthElement.selectByVisibleText("Feb");
		Select yearElement = new Select(year);
		yearElement.selectByVisibleText("1991");
		drive.findElement(By.xpath("//input[@type='radio' and @value='1']")).click();
		//drive.findElement(By.name("websubmit")).click();
			

	}

}
