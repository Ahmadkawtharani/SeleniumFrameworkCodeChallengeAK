package com.hybridFramework;

import com.hybridFramework.PageObject.CalculatorHomePage;
import com.hybridFramework.testBase.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorFunctionality extends TestBase {

    @Test()
    public void testCalculatorSubtraction() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);

        //Switching to canvas frame
        calculatorHomePage.switchToFrame(driver);

        calculatorHomePage.calculateSubtractionExpectedResult(driver);

        //Take a screenshot of canvas before entering any values
        String initialStateScreenshot = "var canvas = document.getElementById('canvas'); " +
                "var initialDataURL = canvas.toDataURL(); return initialDataURL;";
        String initialState = (String) js.executeScript(initialStateScreenshot);

        //clear expected result
        calculatorHomePage.clearResult(driver);

        //Entering first random input
        calculatorHomePage.fillFirstInput(driver, "subtraction");

        //Clicking subtract button
        calculatorHomePage.subtractValues(driver);

        //Entering second random input
        calculatorHomePage.fillSecondInput(driver, "subtraction");

        //Click Enter button
        calculatorHomePage.clickEnter(driver);

        //Take a screenshot of canvas after doing the calculations and comparing initialStateScreenshot base64 value to second screenshot
        String finalStateScreenshot = "var canvas = document.getElementById('canvas'); " +
                "var finalDataURL = canvas.toDataURL(); return finalDataURL;";
        String finalState = (String) js.executeScript(finalStateScreenshot);

        String compareScreenshots = "if('" + initialState + "'== '" + finalState + "'){ return true;} else{ return false;}";

        Boolean finalResult = (Boolean) js.executeScript(compareScreenshots);

        Assert.assertTrue(finalResult,"Initial and final screenshots match");

        //Test is successful if initial screenshot = final screenshot else fail
        if (finalResult) {
            log.info("Success!! Initial and Final calculator match");
        } else {
            log.info("Fail!! Initial and Final calculator state do not match");
        }

        calculatorHomePage.switchToDefault(driver);
        driver.close();
    }

    @Test()
    public void testCalculatorDivision() throws InterruptedException {

        CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);

        //Switching to canvas frame
        calculatorHomePage.switchToFrame(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        calculatorHomePage.calculateDivisionExpectedResult(driver);

        //Take a screenshot of canvas before entering any values
        String initialStateScreenshot = "var canvas = document.getElementById('canvas'); " +
                "var initialDataURL = canvas.toDataURL(); return initialDataURL;";
        String initialState = (String) js.executeScript(initialStateScreenshot);

        //clear expected result
        calculatorHomePage.clearResult(driver);

        //Entering first random input
        calculatorHomePage.fillFirstInput(driver, "division");

        //Clicking divide button
        calculatorHomePage.divideValues(driver);

        //Entering second random input
        calculatorHomePage.fillSecondInput(driver, "division");

        //Click Enter button
        calculatorHomePage.clickEnter(driver);

        //Take a screenshot of canvas after doing the calculations and comparing initialStateScreenshot base64 value to second screenshot
        String finalStateScreenshot = "var canvas = document.getElementById('canvas'); " +
                "var finalDataURL = canvas.toDataURL(); return finalDataURL;";
        String finalState = (String) js.executeScript(finalStateScreenshot);

        String compareScreenshots = "if('" + initialState + "'== '" + finalState + "'){ return true;} else{ return false;}";

        Boolean finalResult = (Boolean) js.executeScript(compareScreenshots);

        Assert.assertTrue(finalResult,"Initial and final screenshots match");

        //Test is successful if initial screenshot = final screenshot else fail
        if (finalResult) {
            log.info("Success!! Initial and Final calculator match");
        } else {
            log.info("Fail!! Initial and Final calculator state do not match");
        }

        calculatorHomePage.switchToDefault(driver);
        driver.close();
    }


    @Test()
    public void testCalculatorClear() throws InterruptedException {

        CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);

        //Switching to canvas frame
        calculatorHomePage.switchToFrame(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Take a screenshot of canvas before entering any values
        String initialStateScreenshot = "var canvas=document.getElementById('canvas'); " +
                "var initialDataURL = canvas.toDataURL(); return initialDataURL;";
        String initialState = (String) js.executeScript(initialStateScreenshot);

        //Entering first random input
        calculatorHomePage.fillFirstInput(driver, "subtraction");
        //Clicking clear button
        calculatorHomePage.clearResult(driver);

        //Take a screenshot of canvas after doing the calculations and comparing initialStateScreenshot base64 value to second screenshot
        String finalStateScreenshot = "var canvas = document.getElementById('canvas'); " +
                "var finalDataURL = canvas.toDataURL(); return finalDataURL;";
        String finalState = (String) js.executeScript(finalStateScreenshot);

        String compareScreenshots = "if('" + initialState + "'== '" + finalState + "'){ return true;} else{ return false;}";

        Boolean finalResult = (Boolean) js.executeScript(compareScreenshots);

        Assert.assertTrue(finalResult,"Initial and final screenshots match");

        //Test is successful if initial screenshot = final screenshot else fail
        if (finalResult) {
            log.info("Success!! Initial and Final calculator match");
        } else {
            log.info("Fail!! Initial and Final calculator state do not match");
        }

        calculatorHomePage.switchToDefault(driver);
        driver.close();

    }
}

