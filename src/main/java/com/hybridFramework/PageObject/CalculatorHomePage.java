package com.hybridFramework.PageObject;

import com.hybridFramework.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class CalculatorHomePage extends TestBase {

    Integer firstInputSubtraction = new Random().nextInt(11) + 20;
    Integer secondInputSubtraction = new Random().nextInt(11);
    Double firstInputDivision = Double.valueOf(new Random().nextInt(10) + 1);
    Double secondInputDivision = Double.valueOf(new Random().nextInt(10) + 1);

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

    public void fillFirstInput(WebDriver driver, String operation) throws InterruptedException {

        if(operation == "subtraction"){
            log.info("Filling first subtraction input: " + firstInputSubtraction);
            new Actions(driver).sendKeys(String.valueOf(firstInputSubtraction)).perform();
            Thread.sleep(1000);
        }
        else if (operation == "division"){
            log.info("Filling first division input: " + firstInputDivision);
            new Actions(driver).sendKeys(String.valueOf(firstInputDivision)).perform();
            Thread.sleep(1000);
        }
    }

    public void fillSecondInput(WebDriver driver, String operation) throws InterruptedException {

        if(operation == "subtraction"){
            log.info("Filling second subtraction input: " + secondInputSubtraction);
            new Actions(driver).sendKeys(String.valueOf(secondInputSubtraction)).perform();
            Thread.sleep(1000);
        }
        else if (operation == "division"){
            log.info("Filling second division input: " + secondInputDivision);
            new Actions(driver).sendKeys(String.valueOf(secondInputDivision)).perform();
            Thread.sleep(1000);
        }
    }

    public void calculateSubtractionExpectedResult(WebDriver driver) throws InterruptedException {

        Integer finalResultSubtraction = firstInputSubtraction - secondInputSubtraction;
        log.info("Subtraction expected result is: " + finalResultSubtraction);
        new Actions(driver).sendKeys(String.valueOf(finalResultSubtraction)).perform();
        Thread.sleep(1000);
    }

    public void calculateDivisionExpectedResult(WebDriver driver) throws InterruptedException {

        Double finalResultDivision = Double.valueOf(firstInputDivision / secondInputDivision);
        log.info("Division expected result is: " + finalResultDivision);
        new Actions(driver).sendKeys(String.valueOf(finalResultDivision)).perform();
        Thread.sleep(1000);
    }

    public void subtractValues(WebDriver driver){

        log.info("Subtracting first input by second input");
        new Actions(driver).sendKeys(Keys.SUBTRACT).perform();
    }

    public void divideValues(WebDriver driver){

        log.info("Dividing first input by second input");
        new Actions(driver).sendKeys(Keys.DIVIDE).perform();
    }

    public void clearResult(WebDriver driver) throws InterruptedException {

        log.info("Click C to clear result");
        new Actions(driver).sendKeys("c").perform();
        Thread.sleep(1000);

    }

    public void clickEnter(WebDriver driver) throws InterruptedException {

        log.info("Click 'equal' button");
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
    }

}
