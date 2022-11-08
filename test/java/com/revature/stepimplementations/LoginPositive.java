package com.revature.stepimplementations;

import com.revature.stepimplementations.runersTest.RunTests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPositive {

    @When("The employee types g8tor into username input")
    public void the_employee_types_g8tor_into_username_input() {
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("g8tor");
    }
    @When("The employee types chomp! into password input")
    public void the_employee_types_chomp_into_password_input() {
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("chomp!");
    }



   @Then("the employee should be on the Manager page")
    public void the_employee_should_be_on_the_manager_page() throws InterruptedException {

       Thread.sleep(1000);
       String actualUrl = RunTests.driver.getCurrentUrl();
       Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");

    }
    @Then("The employee should see their name Patty Pastiche on the home page")
    public void the_employee_should_see_their_name_patty_pastiche_on_the_home_page() {
        String  actualPrint = RunTests.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();

        String correct_name = RunTests.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();

        String expected_name ="Welcome Patty Pastiche";
        if(expected_name.equalsIgnoreCase(correct_name))
            System.out.println("Patty Pastiche its on the Home Page ");

            else
        Assert.assertEquals(actualPrint, "Welcome Patty Pastiche");
//                done
        }

    @When("The employee types ryeGuy into username input")
    public void the_employee_types_rye_guy_into_username_input() {
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("ryeGuy");

    }
    @When("The employee types coolbeans into password input")
    public void the_employee_types_coolbeans_into_password_input() {
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("coolbeans");//"/html[1]/body[1]/div[1]/fieldset[1]/input[1]"
    }
    @Then("the employee should be on the Tester page")
    public void the_employee_should_be_on_the_tester_page() throws InterruptedException {

        Thread.sleep(2000);
        String actualUrl = RunTests.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome");

    }
    @Then("The employee should see their name Fakey McFakeFace on the home page")
    public void the_employee_should_see_their_name_fakey_mc_fake_face_on_the_home_page() {
        String  actualPrint = RunTests.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();

        String correct_name = RunTests.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();

        String expected_name ="Welcome Fakey McFakeFace";
        if(expected_name.equalsIgnoreCase(correct_name))
            System.out.println("Fakey McFakeFace its on the Home Page ");

        else
            Assert.assertEquals(actualPrint, "Welcome Fakey McFakeFace");

    }

    @When("The employee types cavalier89 into username input")
    public void the_employee_types_cavalier89_into_username_input() {
        WebElement user_name_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("cavalier89");

    }
    @When("The employee types alucard into password input")
    public void the_employee_types_alucard_into_password_input() {
        WebElement user_password_input= RunTests.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("alucard");

    }
    @Then("The employee should see their name Dracula Fangs on the home page")
    public void the_employee_should_see_their_name_dracula_fangs_on_the_home_page() {
        String  actualPrint = RunTests.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();

        String correct_name = RunTests.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/p[1]")).getText();

        String expected_name ="Welcome Dracula Fangs";

        if(expected_name.equalsIgnoreCase(correct_name))
            System.out.println("Dracula Fangs its on the Home Page ");

        else

            Assert.assertEquals(actualPrint, "Welcome Dracula Fangs");
    }
}
