package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {

    @FindBy(xpath="//b[contains(text(),'Dashboard')]")
    WebElement dashBoardText;

    public String getTextFromDashboard(){

       return getTextFromElement(dashBoardText);
    }
}
