package com.revature.stepimplementations;

import com.revature.stepimplementations.runersTest.RunTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MethodCalls {

    public static void managerLogin() throws InterruptedException {
        RunTests.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=34");
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("g8tor");
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("chomp!");
        WebElement login_button = RunTests.driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login_button.click();
        Thread.sleep(2000);
        String actualUrl = RunTests.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");

    }
    public static void tester1Login() throws InterruptedException {
        RunTests.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=19");
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("ryeGuy");
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("coolbeans");
        WebElement login_button = RunTests.driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login_button.click();
        Thread.sleep(2000);
        String actualUrl = RunTests.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome");

    }

    public static void tester2Login() throws InterruptedException {
        RunTests.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=19");
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("cavalier89");
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("alucard");
        WebElement login_button = RunTests.driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login_button.click();
        Thread.sleep(2000);
        String actualUrl = RunTests.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome");
    }

    public static void matrices_call() throws InterruptedException {
        WebElement matrices_link = RunTests.driver.findElement(By.xpath("//a[contains(text(),'Matrices')]"));
        matrices_link.click();
        Thread.sleep(2000);
    }
}
