package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

   @FindBy(id="txtUsername")
    WebElement userName;
   @FindBy(id="txtPassword")
   WebElement password;
   @FindBy(id="btnLogin")
   WebElement loginButton;
   @FindBy(id="welcome")
   WebElement welcomeMessage;
    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement loginPanel;

    public LoginPage(){

        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String email){

        sendTextToElement(userName,email);

    }
    public void enterPassword(String myPassword){

        sendTextToElement(password,myPassword);
    }
    public void clickOnLoginButton(){

        clickOnElement(loginButton);
    }

    public String getWelcomeTest(){

        return getTextFromElement(welcomeMessage);
    }
    public String getTextFromLoginPanel(){

        return  getTextFromElement(loginPanel);
    }

}
