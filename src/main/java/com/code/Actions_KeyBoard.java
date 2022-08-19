package com.code;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_KeyBoard {
	
	 WebDriver driver;
	 
	 public WebElement getElement(By locator) {
		 return driver.findElement(locator);
	 }
	
	public Actions getActions() {
		return new Actions(driver);
	}
	
	
	//type using actions class
	public void actionsType(String value) {
		getActions().
	}
	
	public void copy(By locator) {
		getActions().click(getElement(locator))
		.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
		.build().perform();
	}
	
	public void cleartextByActions(By locator) {
		getActions().click(getElement(locator))
		.keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
		.build().perform();
	}
	
}
