package org.windowshandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlingExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.name("keyword"));
		searchBox.sendKeys("sanitizer");

		WebElement searchBtn = driver.findElement(By.xpath("//span[text()='Search']"));
		searchBtn.click();
		
		Thread.sleep(2000);

		WebElement product = driver.findElement(By.xpath(
				"//p[text()='Lass Naturals Sanitize Hand Rub Gel 120ml 70% Alcohol Based Sanitizer Sanitizers 480 mL Pack of 4']"));
		
		Thread.sleep(2000);
		
		product.click();
		
		Thread.sleep(1000);
		
		String parentWindowID = driver.getWindowHandle();
		System.out.println("Parent Window ID : " +parentWindowID);
		
		Set<String> allWindowsID = driver.getWindowHandles();
		System.out.println("All Windows ID : " +allWindowsID);
		
		for (String x : allWindowsID) {
			
			if (parentWindowID != x) {
				driver.switchTo().window(x);				//Switching to another window 
			}
			
		}
		
		//Switching to multiple windows.   1st method
		
		//We need to convert from Set to List
		
		List<String> li = new ArrayList<String>();    //---> Upcasting
		
		li.addAll(allWindowsID);
		
		driver.switchTo().window(li.get(1));
		
		
		//Switching to multiple windows.  2nd method
		
		//No need to convert from Set to List. Directly we can use Set<String> allWindowsID = driver.getWindowHandles();
		
		
		int count = 0;
		for (String x : allWindowsID) {
			if (count == 1) {
				driver.switchTo().window(x);
			}
			count++;
		}
		
		
		Thread.sleep(1000);	
		WebElement addToCart = driver.findElement(By.xpath("//span[text()='add to cart']"));
		addToCart.click();
	}
}
