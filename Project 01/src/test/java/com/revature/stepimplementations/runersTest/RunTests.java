package com.revature.stepimplementations.runersTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


@CucumberOptions(features = "classpath:features", glue="com.revature.stepimplementations")

public class RunTests extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }

    @AfterMethod
    public static void quitDriver() throws InterruptedException {
        driver.quit();

    }


}
