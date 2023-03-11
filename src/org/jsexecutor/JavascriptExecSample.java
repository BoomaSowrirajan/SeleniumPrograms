package org.jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecSample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/login/");

		driver.manage().window().maximize();

		// Object creation for JavaScriptExecutor:

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement uname = driver.findElement(By.name("email"));

		// 1) To insert the values in the text box (Replacement for sendKeys())

		js.executeScript("arguments[0].setAttribute('value','selenium@123')", uname);
		
		WebElement pwd = driver.findElement(By.id("pass"));
		
		js.executeScript("arguments[0].setAttribute('value','automation')", pwd);
		
		//2) To click a web Element (Replacement for click())
		
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		
		js.executeScript("arguments[0].click()", loginButton);
		
		
		//3) To retrieve the attribute value (Replacement for getAttribute("value"))
		
		
		Object attributeValue = js.executeScript("return arguments[0].getAttribute('value')", uname);
		System.out.println("Attribute Value : " +attributeValue);
		
		
		Thread.sleep(3000);
		
		//4) To scroll down a page
		
		WebElement scrollDown = driver.findElement(By.xpath("//span[text()=' Meta © 2023']"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		

		Thread.sleep(6000);
		
		
		//5) To scroll up a page
		
		WebElement scrollUp = driver.findElement(By.xpath("//div[text()='Log in to Facebook']"));
		
		js.executeScript("arguments[0].scrollIntoView(false)", scrollUp);
		
	}

}
