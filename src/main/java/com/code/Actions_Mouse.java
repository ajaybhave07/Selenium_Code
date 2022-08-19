package com.code;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions_Mouse {
	WebDriver driver;

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	//mouse over element
	public void moveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).build().perform();
	}
	
	//right click on element
	public void contextClick(By locator) {
		getActions().contextClick(getElement(locator)).build().perform();
	}
	
	//get instance of actions class
	public Actions getActions() {
		Actions action = new Actions(driver);
		return action;
	}
	
	//perform drag and drop
	public void dragAndDrop(By draggable, By droppable) {
		getActions().dragAndDrop(getElement(draggable), getElement(droppable)).build().perform();
	}

	//double click
	public void doubleClick(By locator) {
		getActions().doubleClick(getElement(locator)).build().perform();
	}
		
	// Clicks in the middle of the given element.
	public void actionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}
	
	//actions click for given WebElement
	public void actionsClick(WebElement target) {
		getActions().click(target).build().perform();
	}
	
	//safe click the element using actions class.
	public void safeClickActions(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		actionsClick(ele);
	}
	
	//click and hold
	public void clickAndHold(By locator) {
		getActions().clickAndHold(getElement(locator)).build().perform();
	}
	
}
