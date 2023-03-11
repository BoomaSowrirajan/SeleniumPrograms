package org.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/login/");

		driver.manage().window().maximize();
		
		// 1) Create and object for TakesScreenshot interface.
		
		TakesScreenshot ts = (TakesScreenshot)driver; 
		
		//2) Call the getScreenshotAs() method to take a screenshot.
		
		File temp = ts.getScreenshotAs(OutputType.FILE);    //3) getScreenshotAs() will store the screenshot in a temp folder initially.
		
		//4) Create a new File (destination path) where you wish to save the screenshot.
		
		File destination = new File("D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\screenshots\\fb.png");  //give name with file extension
		
		//5) Copy the screenshot from temp folder to your destination folder by using (FileUtils.CopyFile()) method.
		
		FileUtils.copyFile(temp, destination);
		
		
		driver.findElement(By.name("email")).sendKeys("Booma");
		driver.findElement(By.id("pass")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		Thread.sleep(3000);
		
		File temp1 = ts.getScreenshotAs(OutputType.FILE);
	
		File destination1 = new File("D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\screenshots\\fbLogin.png");
		FileUtils.copyFile(temp1, destination1);
		System.out.println("Screen shot taken successfully");
		System.out.println("Screen shot taken successfully added by Booma");
		
	}

}
