package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
/*
5.ViewSystemUsersPage - System Users Text, Username Field, User Roll dropDown,
Employee Name Field,
Status Drop Down, Search Button, Reset Button, Add Button and Delete Button locators and
it's actions
 */

public class ViewSystemUsersPage extends Utility {

    @FindBy(xpath = "//div[@class='head']")
    WebElement systemUserText;

    @FindBy(xpath="//input[@id='searchSystemUser_userName']")
    WebElement userNameField;

    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRollDropdown;

    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employeeNameField;






    // buttons - dropdown
    @FindBy(xpath= "//input[@id='searchBtn']")
    WebElement search;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;
    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;
    @FindBy(xpath = "//input[@id='resetBtn']")
    WebElement resetButton;
    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement statusDropDown;

    @FindBy(xpath ="//tr[@class='odd'  or 'even']")
    WebElement allUserList;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement tickBox;

    @FindBy(xpath = "//div[@id='deleteConfModal']")
    WebElement deleteFrame;
    @FindBy(xpath = "//input[@class='btn']")
    WebElement okButton;

    public void clickOkOnDeletePopUp(){

        clickOnElement(okButton);

    }





    public String getTextFromSystemUserTab(){
        return getTextFromElement(systemUserText);

    }

    public void clickOnAddButton(){
        clickOnElement(addButton);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
    }

    public void clickOnSearchButton(){
        clickOnElement(search);
    }

    public void enterUserName(String userName)
    {
        sendTextToElement(userNameField,userName);
    }

    public void enterEmployeeName(String employeeName)
    {
        sendTextToElement(employeeNameField,employeeName);
    }
    public void selectUserRoleFromDropDown(String userRole){

        selectByVisibleTextFromDropDown(userRollDropdown,userRole);
    }

    public void selectUserStatusFromDropDown(String userStatus){

       selectByVisibleTextFromDropDown(statusDropDown,userStatus);
    }
    public void checkUserHasBeenAdded(String userAdded){
      isUserExistInList(allUserList,userAdded);

    }

    public void clickOnTickBox(String userToDelete){
    /*
        List<WebElement> allTickBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));


        for( int i=0;i<allTickBoxList.size();i++){

            if(allTickBoxList.get(i).getAttribute("value").equalsIgnoreCase(userToDelete)){

                allTickBoxList.get(i).click();
            }
        }

        acceptAlert();
        String message = getTextFromAlert();
        System.out.println(message);*/
        tickBox.click();
        clickOnDeleteButton();




    }





}
