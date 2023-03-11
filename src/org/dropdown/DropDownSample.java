package org.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Booma\\SeleniumTraining\\workspace\\Selenium\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://output.jsbin.com/osebed/2");

		driver.manage().window().maximize();

		// 4) isMultiple() ---> To check whether the options can be selected multiply.

		WebElement fruits = driver.findElement(By.id("fruits"));

		Select s = new Select(fruits);

		System.out.println("To check whether the options can be selected multiply : \n");
		boolean multiple = s.isMultiple();
		System.out.println(multiple);

		s.selectByIndex(2);
		s.selectByValue("banana");
		s.selectByVisibleText("Grape");

		// 6) getAllSelectedOptions() ---> To print all the selected options only from the drop-down.

		System.out.println("\n\nTo print all the selected options only from the drop-down : \n\n");
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement allSelected : allSelectedOptions) {
			String text = allSelected.getText();
			System.out.println(text);
		}

		// 7) getFirstSelectedOption() ---> To print the first selected option only from
		// the drop-down.

		System.out.println("\n\nTo print the first selected option only from the drop-down : \n\n");
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);

		Thread.sleep(2000);

		// 8) deSelectByValue() ---> To deselect based on the attribute value.

		s.deselectByValue("orange");

		Thread.sleep(2000);

		// 9) deSelectByVisibleText() ---> To deselect based on the text visible  outside.

		s.deselectByVisibleText("Banana");

		Thread.sleep(2000);

		// 10) deSelectByIndex() ---> To deselect based on the index value of the element.

		s.deselectByIndex(3);
		Thread.sleep(3000);

		// Selecting the options again to use the method deslectAll()

		s.selectByIndex(2);
		s.selectByValue("banana");
		s.selectByVisibleText("Grape");
		Thread.sleep(3000);
		
		// 11) deSelectAll()	    ---> To deselect all the selected options.
		
		s.deselectAll();
	}
}
