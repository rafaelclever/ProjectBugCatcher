package com.revature.stepimplementations;

import com.revature.stepimplementations.runersTest.RunTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssignDefect {

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        RunTests.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=19");
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("g8tor");

        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("chomp!");

        WebElement login_botton = RunTests.driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login_botton.click();

        Thread.sleep(2000);
        String actualUrl = RunTests.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");

    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() throws InterruptedException {
        Thread.sleep(2000);
        String actualUrl = RunTests.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");

    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {

    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {

    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {

    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {

    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {

    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {

    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {

    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {

    }

}
