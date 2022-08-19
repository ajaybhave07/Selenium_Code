package com.code;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		// the moment we click on element we get a pop-up(alert)
		driver.findElement(By.name("proceed")).click();

		// Switching our driver from webpage to alert
		Alert alert = driver.switchTo().alert();

		// to get text displayed on alert
		String alertText = alert.getText();
		if (alertText.equals("Please enter a valid user name")) {
			System.out.println("alert message is correct");
		}
		// alert.sendKeys(alertText);
		Thread.sleep(3000);
		// to accept the alert(similar to press ok/yes button on alert)
		alert.accept();

		// to reject alert(similar to press escape button or press on No/cancel button)
		 alert.dismiss();

		driver.quit();
	}
	
	//switching to alert after waiting 
	public static Alert safeSwitchToAlert(int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());      // statement switches to Alert and returns Alert type refrence
	}
	
	//get Alert Text after waiting for it
	public static String safeGetAlertText() {
		return safeSwitchToAlert(10).getText();
	}
	
	//accepting the alert after waiting for it
	public static void safeAcceptAlert() {
		 safeSwitchToAlert(10).accept();
	}
	
	//rejecting the alert after waiting for it
	public static void safeRejectAlert() {
		 safeSwitchToAlert(10).dismiss();

	}
	
	//type in alert , given text
	public static void safeTypeAlert(String value) {
		 safeSwitchToAlert(10).sendKeys(value);
	}
	

}
