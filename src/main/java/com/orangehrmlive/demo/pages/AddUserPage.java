package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
enter Employee Name "Ananya Dash"
enter Username
Select status "Disable"
enter password
enter Confirm Password
click On "Save" Button
verify message "Successfully Saved"
 */

public class AddUserPage extends Utility {

    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUserText;

    @FindBy(id="systemUser_userType")
    WebElement userRole;

    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeName;

    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;

    @FindBy(id="systemUser_status")
    WebElement statusDropDown;

    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPassword;

    @FindBy(id="btnSave")
    WebElement saveButton;


    public String getAddUserText(){
        return getTextFromElement(addUserText);
    }

    public void selectUserRoleFromDropDown(String role){
        selectByVisibleTextFromDropDown(userRole,role);
    }

    public void enterEmployeeName(String name){
        sendTextToElement(employeeName,name);
    }

    public void enterUsername(String name){
        sendTextToElement(userName,name);
    }

    public void selectStatus(String myStatus){

        selectByVisibleTextFromDropDown(statusDropDown,myStatus);

    }
    public void enterPassword(String myPassword){
        sendTextToElement(password,myPassword);
    }

    public void enterConfirmPassword(String confirmMyPassword){
        sendTextToElement(confirmPassword,confirmMyPassword);
    }

    public void clickOnSaveButton()
    { clickOnElement(saveButton);}

    public String getSuccessfullySavedMessage(){
        //System.out.println(getTextFromAlert());
        String alertMessage = getTextFromAlert();

      return  alertMessage;
    }





}
