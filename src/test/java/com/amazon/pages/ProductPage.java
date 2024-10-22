package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	public static WebElement element;

	public static WebElement priceElement(WebDriver driver) {
		return driver.findElement(By.xpath("//span[normalize-space()='1,56,900']"));

	}

	public static WebElement addToCartButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[normalize-space()='1,56,900']"));

	}

}
