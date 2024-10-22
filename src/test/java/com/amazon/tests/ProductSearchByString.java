package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.base.Base;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.utils.Action;

public class ProductSearchByString extends Base {

	@Test
	public void searchAndAddToCart() throws Throwable {

		logger.info("Test started: searchAndAddToCart");
		logger.info("Step 1: Go to amazon.com");

		HomePage.searchBox(driver).sendKeys("Iphone");
		logger.info("Step 2: Entered search term: Iphone");

        HomePage.productResult(driver).click();
		logger.info("Step 3: Clicked on the first product result");

		HomePage.firstResult(driver).click();
		logger.info("Step 4: Clicked on the specific product: iPhone 15 Pro (128 GB) - Natural Titanium");

		driver.navigate().forward();
		logger.info("Step 5: Navigate to next Page");

		String expectedPrice = "1,56,900";
		String actualPrice = Action.getText(ProductPage.priceElement(driver), "1,56,900");
		Assert.assertEquals(actualPrice, expectedPrice, "Verification Failed: Price does not match");
		logger.info("Step 6: Price verification successful. Expected Price: {1,56,900}, Actual Price: {1,56,900}");

		ProductPage.addToCartButton(driver).click();
		logger.info("Step 7: Clicked on 'Add to Cart' button");

		logger.info("Test completed: searchAndAddToCart");

	}

}
