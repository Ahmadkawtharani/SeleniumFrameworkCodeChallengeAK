package com.hybridFramework;

import com.hybridFramework.PageObject.CalculatorHomePage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class CalculatorFunctionality extends TestBase {

    Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    @Test()
    public void testCalculatorSubtraction() {

        //Launching chrome and redirecting to URL
        driver.get("https://www.online-calculator.com/full-screen-calculator/");
        CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);

        //Switching to canvas frame
        calculatorHomePage.switchToFrame(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        calculatorHomePage.calculateSubtractionExpectedResult(driver);

        //Take a screenshot of canvas before entering any values
        String initialStateScreenshot = "var canvas=document.getElementById('canvas'); " +
                "var initialDataURL = canvas.toDataURL(); return initialDataURL;";
        String initialState = (String) js.executeScript(initialStateScreenshot);

        //clear expected result
        calculatorHomePage.clearResult(driver);
        //Entering first random input
        calculatorHomePage.fillFirstInput(driver);
        //Clicking subtract button
        calculatorHomePage.subtractValues(driver);
        //Entering second random input
        calculatorHomePage.fillSecondInput(driver);
        //Click Enter button
        calculatorHomePage.clickEnter(driver);

        //Take a screenshot of canvas after doing the calculations and comparing initialStateScreenshot base64 value to second screenshot
        String finalStateScreenshot = "  var finalDataURL = canvas.toDataURL(); " +
                "if('" + initialState + "'!=finalDataURL.toString()) return true; else return false;";
        Boolean finalResult = (Boolean) js.executeScript(finalStateScreenshot);

        //Test is successful if initial screenshot != final screenshot else pass
        if (finalResult) {
            log.info("Success!! Initial and Final calculator state does not match");
        } else {
            log.info("Fail!! Initial and Final calculator state still match");
        }

        calculatorHomePage.switchToDefault(driver);

        endTest();
    }

    @Test()
    public void testCalculatorDivision() {

        //Launching chrome and redirecting to URL
        driver.get("https://www.online-calculator.com/full-screen-calculator/");
        CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);

        //Switching to canvas frame
        calculatorHomePage.switchToFrame(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        calculatorHomePage.calculateDivisionExpectedResult(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Take a screenshot of canvas before entering any values
        String initialStateScreenshot = "var canvas=document.getElementById('canvas'); " +
                "var initialDataURL = canvas.toDataURL(); return initialDataURL;";
        String initialState = (String) js.executeScript(initialStateScreenshot);

        //clear expected result
        calculatorHomePage.clearResult(driver);
        //Entering first random input
        calculatorHomePage.fillFirstInput(driver);
        //Clicking divide button
        calculatorHomePage.divideValues(driver);
        //Entering second random input
        calculatorHomePage.fillSecondInput(driver);
        //Click Enter button
        calculatorHomePage.clickEnter(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Take a screenshot of canvas after doing the calculations and comparing initialStateScreenshot base64 value to second screenshot
        String finalStateScreenshot = "  var finalDataURL = canvas.toDataURL(); " +
                "if('" + initialState + "'!=finalDataURL.toString()) return true; else return false;";
        Boolean finalResult = (Boolean) js.executeScript(finalStateScreenshot);

        //Test is successful if initial screenshot != final screenshot else pass
        if (finalResult) {
            log.info("Success!! Initial and Final calculator state does not match");
        } else {
            log.info("Fail!! Initial and Final calculator state still match");
        }

        calculatorHomePage.switchToDefault(driver);
        endTest();
    }


    @Test()
    public void testCalculatorClear() {

        //Launching chrome and redirecting to URL
        driver.get("https://www.online-calculator.com/full-screen-calculator/");
        CalculatorHomePage calculatorHomePage = new CalculatorHomePage(driver);

        //Switching to canvas frame
        calculatorHomePage.switchToFrame(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Take a screenshot of canvas before entering any values
        String initialStateScreenshot = "var canvas=document.getElementById('canvas'); " +
                "var initialDataURL = canvas.toDataURL(); return initialDataURL;";
        String initialState = (String) js.executeScript(initialStateScreenshot);

        //Entering first random input
        calculatorHomePage.fillFirstInput(driver);
        //Clicking clear button
        calculatorHomePage.clearResult(driver);

        //Take a screenshot of canvas after doing the calculations and comparing initialStateScreenshot base64 value to second screenshot
        String finalStateScreenshot = "  var finalDataURL = canvas.toDataURL(); " +
                "if('" + initialState + "'!=finalDataURL.toString()) return true; else return false;";
        Boolean finalResult = (Boolean) js.executeScript(finalStateScreenshot);

        //Test is successful if initial screenshot != final screenshot else pass
        if (finalResult) {
            log.info("Success!! Initial and Final calculator state does not match");
        } else {
            log.info("Fail!! Initial and Final calculator state still match");
        }

        calculatorHomePage.switchToDefault(driver);
        endTest();
    }
}

