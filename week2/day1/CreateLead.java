package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		Thread.sleep(3000);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tata Consultancy Services Limited");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Divya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Div");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("ECE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("I am a Manual Tester, learning Java-Selenium for Automated Testing");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test123@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sel = new Select(state);
		sel.selectByVisibleText("New York");
		Thread.sleep(5000);
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

}
