package org.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/login/");

		driver.manage().window().maximize();

		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign up for Facebook']"));

		signUp.click();
		
		Thread.sleep(3000);

		// 1) selectByValue() ---> Selecting based on the attribute value.

		WebElement day = driver.findElement(By.name("birthday_day"));

		Select s1 = new Select(day);
		s1.selectByValue("5");
		
		Thread.sleep(2000);

		// 2) selectByVisibleText() ---> Selecting based on the text visible outside.

		WebElement month = driver.findElement(By.name("birthday_month"));

		Select s2 = new Select(month);
		s2.selectByVisibleText("Aug");
		
		Thread.sleep(2000);

		// 3) selectByIndex() ---> Selecting based on the index value of the element.

		WebElement year = driver.findElement(By.name("birthday_year"));
		Select s3 = new Select(year);
		s3.selectByIndex(2);
		
		// 4) isMultiple()		    ---> To check whether the options can be selected multiply.
		
		System.out.println("To check whether the options can be selected multiply : \n");
		boolean multiple = s3.isMultiple();
		System.out.println(multiple);
		
		//5) getOptions()		    ---> To check all the options present in the drop-down.
		
		System.out.println("\n\nTo print all the options present in the drop-down\n\n");
		List<WebElement> allOpt = s2.getOptions();
		for (WebElement allOptions : allOpt) {
			String text = allOptions.getText();
			System.out.println(text);
		}
	}
}
