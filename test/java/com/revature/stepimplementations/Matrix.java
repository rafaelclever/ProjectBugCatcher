package com.revature.stepimplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import static com.revature.stepimplementations.runersTest.RunTests.driver;

public class Matrix {

    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() throws InterruptedException {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=34");
        WebElement user_name_input= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[1]"));
        user_name_input.sendKeys("g8tor");

        WebElement user_password_input= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/input[2]"));
        user_password_input.sendKeys("chomp!");

        WebElement login_button = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        login_button.click();

        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");

    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() throws InterruptedException {

        WebElement matrix_button = driver.findElement(By.xpath("//button[contains(text(),'Create A new Requirements Matrix')]"));
        matrix_button.click();
        Thread.sleep(2000);

    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() throws InterruptedException {
        WebElement title_input= driver.findElement(By.xpath("//body/div[@id='root']/input[1]"));
        title_input.sendKeys("Official Test 3");
        Thread.sleep(2000);
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix(){
        WebElement user_story_input= driver.findElement(By.xpath("//tbody/tr[last()]/td[1]/input[1]"));
        user_story_input.sendKeys("Requirement Official 3");

    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() throws InterruptedException {

        Select priority = new Select(driver.findElement(By.xpath("//tbody//tr//td//select")));
        priority.selectByVisibleText("High");

        WebElement user_note_input= driver.findElement(By.xpath("//tbody/tr[last()]/td[3]/input[1]"));
        user_note_input.sendKeys("Notes Added");

        WebElement add_requirement_button = driver.findElement(By.xpath("//button[contains(text(),'Add Requirement')]"));
        add_requirement_button.click();

        WebElement save_matrix_button = driver.findElement(By.xpath("//button[contains(text(),'Create Matrix')]"));
        save_matrix_button.click();


    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws InterruptedException {

        MethodCalls.managerLogin(); //using method to call manager

//        WebElement matrices_link_1 = RunTests.driver.findElement(By.xpath("//a[contains(text(),'Matrices')]"));
//        matrices_link_1.click();
//        Thread.sleep(2000);
//     old way
        MethodCalls.matrices_call();
        driver.findElement(By.xpath("//body/div[@id='root']/ul[1]/li[string-length(text()) >2]"));

        MethodCalls.tester1Login(); //using method to call tester 1
        MethodCalls.matrices_call();
        driver.findElement(By.xpath("//body/div[@id='root']/ul[1]/li[string-length(text()) >2]"));

        MethodCalls.tester2Login(); //using method to call tester 2
        MethodCalls.matrices_call();
        driver.findElement(By.xpath("//body/div[@id='root']/ul[1]/li[string-length(text()) >2]"));

        //  I NEED FINISH THIS METHOD

    }

    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() throws InterruptedException {
        MethodCalls.tester1Login();
        WebElement matrices_link_1 = driver.findElement(By.xpath("//a[contains(text(),'Matrices')]"));
        matrices_link_1.click();
        Thread.sleep(2000);

        WebElement matrix_select = driver.findElement(By.xpath("//body/div[@id='root']/ul[1]/li[1]/div[1]/span[1]/button[1]"));
        matrix_select.click();
        Thread.sleep(2000);

    }
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() throws InterruptedException {
        MethodCalls.tester2Login();
        WebElement link_defects_page = driver.findElement(By.xpath("//a[contains(text(),'Report a Defect')]"));
        link_defects_page.click();

        WebElement defect_date = driver.findElement(By.xpath("//body/div[@id='root']/form[@id='defectReport']/input[1]"));
        defect_date.click();
        defect_date.sendKeys(Keys.LEFT);
        defect_date.sendKeys(Keys.LEFT);

        defect_date.sendKeys("09252013");
        defect_date.click();

        WebElement description_input = driver.findElement(By.xpath("//body/div[@id='root']/form[@id='defectReport']/textarea[1]"));
        description_input.click();
        description_input.sendKeys("Defect being reported");

        WebElement reproduce_input = driver.findElement(By.xpath("//body/div[@id='root']/form[@id='defectReport']/textarea[2]"));
        reproduce_input.click();
        reproduce_input.sendKeys("Go to Home Page");


        WebElement severity_slide = driver.findElement(By.xpath("//body/div[@id='root']/form[@id='defectReport']/input[2]"));
        Actions action = new Actions (driver);
        action.dragAndDropBy (severity_slide, 1, 2).perform() ;

        WebElement priority_slide = driver.findElement(By.xpath("//body/div[@id='root']/form[@id='defectReport']/input[3]"));
        action.dragAndDropBy (priority_slide, 2, 1).perform() ;
        Thread.sleep(2000);

        WebElement submit_defect = driver.findElement(By.xpath("//button[contains(text(),'Report')]"));
        submit_defect.click();

    }
    @Then("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() throws InterruptedException {

        driver.switchTo().alert().accept();
        Thread.sleep(4000);


    }
    @Then("the matrix should saved")
    public void then_the_matrix_should_saved() {
        String defect_created = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]")).getText();

        String str = defect_created;
        String sub = defect_created.substring(12, 20); //using sub string text part

        if (sub.contains("created")){ //to make it fail, change text here;
            System.out.println("Defect Created");
        }
        else {
            System.out.println("Defect Not Created");
            // using Wrong Xpath to fail
            String wrong_xpath = String.valueOf(driver.findElement(By.xpath("/body[1]/div[0]")));
        }
    }

    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() throws InterruptedException {
        WebElement test_link = driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[1]/div[1]/span[1]/button[1]"));
        test_link.click();
        Thread.sleep(4000);

        WebElement show_button = driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[3]/div[1]/span[1]/button[1]"));
        show_button.click();
        Thread.sleep(2000);


        WebElement edit_button = driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]"));
        edit_button.click();
        Thread.sleep(4000);

        WebElement test_case_button = driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/input[1]"));
        test_case_button.click();
        test_case_button.sendKeys("801");
        Thread.sleep(4000);

        WebElement defect_id_button = driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/ul[2]/li[1]/input[1]"));
        defect_id_button.click();
        defect_id_button.sendKeys("89443");
        Thread.sleep(4000);
        WebElement save_req_button = driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/button[1]"));
        save_req_button.click();
        Thread.sleep(4000);
    }
}
