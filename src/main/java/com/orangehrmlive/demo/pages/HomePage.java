package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text
locatores
and create appropriate methods for it.
 */

public class HomePage extends Utility {

    public HomePage() {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
    WebElement logo;
    @FindBy(id = "welcome")
    WebElement welcomeText;
    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement admin;

@FindBy(xpath = "//b[contains(text(),'PIM')]")
WebElement pIM;

@FindBy(xpath ="//b[contains(text(),'Leave')]")
WebElement leave;

@FindBy(xpath = "//b[contains(text(),'Dashboard')]")
WebElement dashBoard;



    public void isLogoDisplayed() {
        System.out.println(getTextFromElement(logo));

    }

    public void mouseHoverAndClickOnWelcomeText(){

        mouseHoverToElementAndClick(welcomeText);
    }
    public void mouseHoverAndClickLogOutButton(){

        mouseHoverToElementAndClick(logoutButton);
    }

    public void mouseHoverAndClickOnAdmin(){
        mouseHoverToElementAndClick(admin);
    }


}
