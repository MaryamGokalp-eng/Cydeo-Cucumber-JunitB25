package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;

public class DataTable_StepDefinitions {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));
    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }
    DropdownsPage dropdownsPage = new DropdownsPage();       //<--PassObject
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        //This method will return us the List of String of given dropDown's options of webElement
        List<String> actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths);
        //Assert will check the size of the lists first. If it is matching it will check content 1 by 1.
        
        }

    @Given("User is on the page")
    public void user_is_on_the_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceCydeo"));
    }


    }
        /*
        OR U can do month this way
        @Then("User should see below info in month dropdown")
        public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        Select select = new Select(dropdownsPage.monthDropdown);

        //List of all month <option> as web element
        List<String> actualOptionsAsString = new ArrayList<>();

        for (ErbElement each : actualOptionsAsWebElement) {
        actualOptionsAsString.add.getText());
        }
        Assert.assertEquals(expectedMonths, actualOptionsAsString);
        //Assert will check the size of the lists first. If it is matching it will check content 1 by 1.

        Or Can reUse by moving to utility.util class
         */

/*
My table snipers can covert the dataTable.features into same argument we can store the feature table into
AList of stringGineNameFruit--> public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths){
We can pass Multiple string under one step if we want

How to handle DropDowns? ICanUse my selected classComes From the Selenium Library We canCall
-->Select select = new Select(); then I need to pass the object create a new line on the topOfMyClass
DropdownsPage dropdownsPage = new DropdownsPage();
 */