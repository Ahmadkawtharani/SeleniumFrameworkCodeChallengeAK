package com.hybridFramework.PageObject;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class CalculatorHomePage extends TestBase {

    Logger log = LoggerHelper.getLogger(LoggerHelper.class);
    Double firstInput = Double.valueOf(new Random().nextInt(11) + 20);
    Double secondInput = Double.valueOf(new Random().nextInt(11) + 20);
    public CalculatorHomePage(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullframe")));
        driver.manage().window().maximize();
        WebElement gotIt = driver.findElement(By.className("cc-dismiss"));
        gotIt.click();
    }

    public void switchToFrame(WebDriver driver){

        log.info("Switching to iFrame");
        WebElement iFrame = driver.findElement(By.id("fullframe"));
        driver.switchTo().frame(iFrame);
    }

    public void switchToDefault(WebDriver driver){

        log.info("Switching to default frame");
        driver.switchTo().defaultContent();
    }

    public void fillFirstInput(WebDriver driver){

        log.info("Filling first input: " + firstInput);
        new Actions(driver).sendKeys(String.valueOf(firstInput)).perform();
    }

    public void fillSecondInput(WebDriver driver){

        log.info("Filling first input: " + secondInput);
        new Actions(driver).sendKeys(String.valueOf(secondInput)).perform();
    }

    public void calculateSubtractionExpectedResult(WebDriver driver){

        Double finalResultSubtraction = firstInput - secondInput;
        log.info("Expected result is: " + finalResultSubtraction);
        new Actions(driver).sendKeys(String.valueOf(finalResultSubtraction)).perform();
    }

    public void calculateDivisionExpectedResult(WebDriver driver){

        Double finalResultDivision = Double.valueOf(firstInput / secondInput);
        log.info("Expected result is: " + finalResultDivision);
        new Actions(driver).sendKeys(String.valueOf(finalResultDivision)).perform();
    }

    public void subtractValues(WebDriver driver){

        log.info("Subtracting first input by second input");
        new Actions(driver).sendKeys(Keys.SUBTRACT).perform();
    }

    public void divideValues(WebDriver driver){

        log.info("Dividing first input by second input");
        new Actions(driver).sendKeys(Keys.DIVIDE).perform();
    }

    public void clearResult(WebDriver driver){

        log.info("Click C to clear result");
        new Actions(driver).sendKeys("c").perform();
    }

    public void clickEnter(WebDriver driver){

        log.info("Click 'equal' button");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }

}
