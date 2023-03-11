package org.frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFCFrames {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");

		driver.manage().window().maximize();
		
		List<WebElement> totalFrames = driver.findElements(By.tagName("frame"));
		int size = totalFrames.size();
		System.out.println(size);
		
		driver.switchTo().frame(0); 	 //-->Switch to Frame by using index value
		
		WebElement uname = driver.findElement(By.name("fldLoginUserId"));
		uname.sendKeys("Booma");
		
	}
}
