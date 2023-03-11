package org.visiblitycheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisibilityCheckMethods {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/login/");

		driver.manage().window().maximize();

		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign up for Facebook']"));

		signUp.click();

		WebElement gender = driver.findElement(By.xpath("//input[@type='radio'][1]"));

		// 1) isDisplayed() ---> To check whether the webelement is displayed or not.

		System.out.println("To check whether the webelement is displayed or not : \n");
		boolean displayed = gender.isDisplayed();
		System.out.println(displayed);

		// 2) isSelected() ---> To check whether the webelement is selected or not.

		System.out.println("\nTo check whether the webelement is selected or not Before clicking the Gender: \n");
		boolean selected = gender.isSelected();
		System.out.println(selected);

		// 3) isEnabled() ---> To check whether the webelement is enabled or not.

		System.out.println("\nTo check whether the webelement is enabled or not : \n");
		boolean enabled = gender.isEnabled();
		System.out.println(enabled);

		// Selecting the Gender Female

		gender.click();

		// 2) isSelected() ---> To check whether the webelement is selected or not.

		System.out.println("\nTo check whether the webelement is selected or not after Clicking the Gender: \n");
		boolean select = gender.isSelected();
		System.out.println(select);
	}
}
