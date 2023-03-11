package org.frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesExample {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//1st example with HDFC banking

//		driver.get("https://netbanking.hdfcbank.com/netbanking/");
//
//		driver.manage().window().maximize();
//		
//		driver.switchTo().frame("login_page");
//		
//		WebElement uname = driver.findElement(By.name("fldLoginUserId"));
//		uname.sendKeys("Booma");
		
		//2nd Example with Demoguru
		
		driver.get("https://demo.guru99.com/test/guru99home/");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(3000);
		
		WebElement scrollDownTillFrames = driver.findElement(By.xpath("//h3[contains(text(),'iFrame will')]"));
//		
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDownTillFrames);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);

		//To check number of frames present in web page
		
//		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
//		int count = totalFrames.size();
//		System.out.println("Total number of frames: " +count);
		
//		driver.switchTo().frame("a077aa5e");   //Switching by using id
//		
//		driver.switchTo().frame("a077aa5e");    //Switching by using name
//		
//		WebElement frameSwitching = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
//		
//		driver.switchTo().frame(frameSwitching);    //Switching by using webelement reference name
		
		driver.switchTo().frame(1);   //Switching by using index value
		
		
//
//	    for(int i=0; i<=size; i++){
//		driver.switchTo().frame(i);
//		int total=driver.findElements(By.xpath("html/body/a/img")).size();
//		System.out.println(total);
//	    }
					
//		Thread.sleep(3000);
		
		WebElement img = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		
		Thread.sleep(2000);
		
		img.click();
		
		//To get out of the frame
		
//		driver.switchTo().defaultContent();
		
//		Thread.sleep(3000);
		
//		WebElement scrollUp = driver.findElement(By.xpath("//font[text()='THIS IS A DEMO PAGE FOR TESTING']"));
//		js.executeScript("arguments[0].scrollIntoView(false)", scrollUp);
//		
//		WebElement text = driver.findElement(By.xpath("//h3[text()='All provided FREE!!!']"));
//		String text2 = text.getText();
//		System.out.println(text2);
	}
}
