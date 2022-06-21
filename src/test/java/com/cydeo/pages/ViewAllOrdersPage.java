package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOrdersPage extends BasePage{


    public ViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //we need to locate the first cell of the first row
    //LocateWebTableUsingSelenium getMe1st cel by index//-->//table[@class='table is-fullwidth']/tbody/tr[1]/td[1]
    //WeLocateTableGo2 TBody VerifyGet1stRoll onTheFirstCell verifyExpectedName->SherlockHolmesPastFromMyFeatureFile
    //And compare with the value is thats why WeSayGo2TheFirstRoll&GetMy1stCell.
    @FindBy(xpath = "//table[@class='table is-fullwidth']/tbody/tr[1]/td[1]")
    public WebElement newCustomerCell;


}