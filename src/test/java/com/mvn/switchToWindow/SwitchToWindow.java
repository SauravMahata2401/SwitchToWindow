package com.mvn.switchToWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SwitchToWindow {
	
	WebDriver driver;

	
	@Test
	public void testSwitchToWindow() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Saurav%20Mahata/EclipseOxygenWS/com.mvn.switchToWindow/HTML/PageToSwitch1.html");

		System.out.println("Window Title: "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Navigate to Page 2']")).click();
		
		Set<String> allwindow = driver.getWindowHandles();
		
		Iterator<String> allwins = allwindow.iterator();
		
		String first_window = allwins.next();
		String second_window = allwins.next();
		String last_window;
		
		driver.switchTo().window(second_window);
		System.out.println("Second window Title: "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Navigate to Page 3']")).click();
		
		allwindow = driver.getWindowHandles();
		allwins = allwindow.iterator();
		
		while(allwins.hasNext()) {
			
			last_window = allwins.next();
			driver.switchTo().window(last_window);
		}
		
		System.out.println("Third Window title: "+driver.getTitle());
		
		
		driver.findElement(By.id("firstname")).sendKeys("Saurav");
		
		driver.findElement(By.xpath("//*[text()='Information Section']//following-sibling::textarea")).sendKeys("135/13");
		
		Thread.sleep(2000);
		driver.close();
		
		driver.switchTo().window(second_window);
		
		Thread.sleep(2000);
		driver.close();
		
		
		
		driver.switchTo().window(first_window);
		System.out.println("Window Title is: "+driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
}
