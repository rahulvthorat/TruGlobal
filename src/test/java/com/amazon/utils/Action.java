package com.amazon.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Action {

	@SuppressWarnings("deprecation")
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebDriver driver, WebElement element, Duration timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static boolean fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean selectByIndex(WebElement element, int index) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	public static boolean selectByValue(WebElement element, String value) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	public static boolean selectByVisibleText(String visibletext, WebElement ele) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	public static boolean selectBySendkeys(String value, WebElement ele) throws Throwable {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}
	
	public static boolean click(WebElement locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \"" + locatorName + "\"");
			} else {
				System.out.println("Click Unable to click on \"" + locatorName + "\"");
			}
		}

	}
	
	public static boolean type(WebElement ele, String text) throws Throwable {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}
	
	public static String getText(WebElement element, String elementName) throws Throwable {
	    String text = null;
	    boolean flag = false;
	    
	    try {
	        text = element.getText();
	        flag = true;
	        return text;
	    } catch (Exception e) {
	        return null;
	    } finally {
	        if (flag) {
	            System.out.println("Able to get text from \"" + elementName + "\": " + text);
	        } else {
	            System.out.println("Unable to get text from \"" + elementName + "\"");
	        }
	    }
	}

	public static boolean isPageLoaded() {
       
        try {
            Thread.sleep(5000); // 5 seconds wait (Replace with proper page load verification)
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
	

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		
		return destination;
	}
	

	public static boolean slider(WebDriver driver, WebElement sliderElement, int xOffset, int yOffset) {
        boolean flag = false;
        try {
            Actions sliderAction = new Actions(driver);
            sliderAction.dragAndDropBy(sliderElement, xOffset, yOffset).build().perform();
            Thread.sleep(5000); // You might want to replace this with an explicit wait for the desired state
            flag = true;
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception as needed
        } finally {
            printSliderActionStatus(flag);
        }
        return flag;
    }

    private static void printSliderActionStatus(boolean flag) {
        if (flag) {
            System.out.println("Slider action performed successfully");
        } else {
            System.out.println("Slider action failed");
        }
    }
}
