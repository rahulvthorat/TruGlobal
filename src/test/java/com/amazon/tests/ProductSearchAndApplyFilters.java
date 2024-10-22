package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pages.HomePage;

public class ProductSearchAndApplyFilters extends Base {

	@Test

	public void searchAndApplyFilter() throws Throwable {

		logger.info("Test started: Product search and apply filters");
		logger.info("Step 1: Go to amazon.com");

		logger.info("Step 2: Enter 'Phone' in the search box");
		HomePage.searchBox(driver).sendKeys("Phone");

		logger.info("Step 3: Click on the search button");
		HomePage.searchButton(driver).click();

		logger.info("Step 4: Click on the OnePlus brand filter");
		HomePage.BrandOnePlus(driver).click();

		logger.info("Step 5: Filter verification successful.");
		String actualResults = HomePage.verifyFilter(driver).getText();
		String expectedResults = "OnePlus 10R 5G (Sierra Black, 8GB RAM, 128GB Storage, 80W SuperVOOC)";
		Assert.assertEquals(actualResults, expectedResults, "Verification Failed: Filter tag does not match");

		logger.info("Test completed: Product search and apply filters");

	}

}
