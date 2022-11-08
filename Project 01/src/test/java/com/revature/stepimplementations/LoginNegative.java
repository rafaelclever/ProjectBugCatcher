package com.revature.stepimplementations;

import com.revature.stepimplementations.runersTest.RunTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginNegative {
   @Given("The employee is on the login page")
   public void the_employee_is_on_the_login_page(){
      RunTests.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=19");


   }
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("g8tor");

    }
    @When("The employee types in chopchop! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("chopchop");

    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        WebElement login_botton = RunTests.driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login_botton.click();
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() throws InterruptedException {
        Thread.sleep(2000);
        String wrong_password = RunTests.driver.switchTo().alert().getText();
        String  actualPrint = RunTests.driver.switchTo().alert().getText();

        String expected_message ="Wrong password for User";
        if(expected_message.equalsIgnoreCase(wrong_password))
            System.out.println("Test Wrong_password its working");

        else
            Assert.assertEquals(actualPrint, "Wrong password for User");
    }
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("sicEmDawgs");
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("natchamps");
    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() throws InterruptedException {
        Thread.sleep(2000);
        String wrong_Username= RunTests.driver.switchTo().alert().getText();
        String  actualPrint = RunTests.driver.switchTo().alert().getText();

        String expected_message ="Username not found";
        if(expected_message.equalsIgnoreCase(wrong_Username))
            System.out.println("Test Wrong_Username its working");

        else
            Assert.assertEquals(actualPrint, "Username not found");
    }
}
