package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static WebElement element;

	public static WebElement searchBox(WebDriver driver) {
		return driver.findElement(By.id("twotabsearchtextbox"));

	}

	public static WebElement searchButton(WebDriver driver) {
		return driver.findElement(By.id("nav-search-submit-button"));

	}

	public static WebElement productResult(WebDriver driver) {
		return driver
				.findElement(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div/div[1]/div[1]/div/div[1]/span"));

	}

	public static WebElement firstResult(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));

	}

	public static WebElement BrandOnePlus(WebDriver driver) {
		return driver.findElement(By.xpath(
				"//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='OnePlus']"));

	}

	public static WebElement verifyFilter(WebDriver driver) {
		return driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[2]/h2[1]/a[1]/span[1]"));

	}

}
