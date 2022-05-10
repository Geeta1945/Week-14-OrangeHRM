package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class UsersTest extends TestBase {
    LoginPage loginPageObj;
    HomePage homePageObj;
    LoginPagetest loginPagetestObj;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod

    public void inBeginning() {

        loginPageObj = new LoginPage();
        homePageObj = new HomePage();
        loginPagetestObj = new LoginPagetest();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }/*
    1.adminShouldAddUserSuccessFully().
Login to Application
click On "Admin" Tab
Verify "System Users" Text
click On "Add" button
Verify "Add User" Text
Select User Role "Admin"
enter Employee Name "Ananya Dash"
enter Username
Select status "Disable"
enter password
enter Confirm Password
click On "Save" Button
verify message "Successfully Saved"
    */

    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {

        loginPageObj.enterUserName("Admin");

        loginPageObj.enterPassword("admin123");
        loginPageObj.clickOnLoginButton();
        Thread.sleep(2000);
        homePageObj.mouseHoverAndClickOnAdmin();
        String actualMessage = viewSystemUsersPage.getTextFromSystemUserTab();
        Assert.assertEquals(actualMessage,"System Users","You are not on System Users' Page");

        viewSystemUsersPage.clickOnAddButton();
        Thread.sleep(2000);
        // I have entered Alice Duval, Alice -username
        addUserPage.selectUserRoleFromDropDown("Admin");
        Thread.sleep(2000);        addUserPage.enterEmployeeName("Charlie Carter");
        addUserPage.enterUsername("CharlieJob");
        addUserPage.selectStatus("Disabled");
        addUserPage.enterPassword("MyPassword123@");
        Thread.sleep(2000);
        addUserPage.enterConfirmPassword("MyPassword123@");
        addUserPage.clickOnSaveButton();
        Thread.sleep(3000);

        // verifying successfully saved message.
        // IT IS ADDING THE USERNAME BUT NOT CAPTURING MESSAGE

        String actualMessage1 = addUserPage.getSuccessfullySavedMessage();
        Thread.sleep(3000);

        System.out.println(actualMessage1);
        Assert.assertEquals(actualMessage1,"Successfully Saved","User Cannot be added");

    }
    /*

    2. searchTheUserCreatedAndVerifyIt().
    Login to Application
    click On "Admin" Tab
    Verify "System Users" Text
    Enter Username - Anthony Nolan
    Select User Role - ESS
    Select Satatus -Enabled
    Click on "Search" Button
    Verify the User should be in Result list.*/

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginPageObj.enterUserName("Admin");
        Thread.sleep(2000);
        loginPageObj.enterPassword("admin123");
        loginPageObj.clickOnLoginButton();
        Thread.sleep(2000);
        homePageObj.mouseHoverAndClickOnAdmin();
        String actualMessage = viewSystemUsersPage.getTextFromSystemUserTab();
        Assert.assertEquals(actualMessage,"System Users","You are not on System Users' Page");
        // username - Anthony Nolan
        viewSystemUsersPage.checkUserHasBeenAdded("CharlieJob");
        // below method added to utility class
        /*
        List<WebElement> allUsersExist = driver.findElements(By.xpath("//tr[@class='odd'  or 'even']"));
        int no=   allUsersExist.size();
        System.out.println(no);
        for (WebElement oneUser:allUsersExist ) {
            //System.out.println(oneUser.getText());
            String userInformation = oneUser.getText();

            boolean isUserThere = userInformation.contains("CharlieJob");
            if (isUserThere) {
                System.out.println("User Exist");
                break;
            }
        }*/

    }

    /*
    3. verifyThatAdminShouldDeleteTheUserSuccessFully().
Login to Application
click On "Admin" Tab
Verify "System Users" Text
Enter Username
Select User Role
Select Satatus
Click on "Search" Button
Verify the User should be in Result list.
Click on Check box
Click on Delete Button
Popup will display
Click on Ok Button on Popup
verify message "Successfully Deleted"
     */

    @Test

    public void isUserDeleted() throws InterruptedException {

        loginPageObj.enterUserName("Admin");
        Thread.sleep(2000);
        loginPageObj.enterPassword("admin123");
        loginPageObj.clickOnLoginButton();
        Thread.sleep(2000);
        homePageObj.mouseHoverAndClickOnAdmin();
        String actualMessage = viewSystemUsersPage.getTextFromSystemUserTab();
        Thread.sleep(2000);
        Assert.assertEquals(actualMessage,"System Users","You are not on System Users' Page");
       viewSystemUsersPage.enterUserName("dilshad");
       viewSystemUsersPage.selectUserRoleFromDropDown("ESS");
       viewSystemUsersPage.selectUserStatusFromDropDown("Enabled");
        Thread.sleep(2000);
       viewSystemUsersPage.clickOnSearchButton();
       //checking user is there in list or not

        viewSystemUsersPage.checkUserHasBeenAdded("dilshad");
        Thread.sleep(2000);
        viewSystemUsersPage.clickOnTickBox("dilshad");
        Thread.sleep(5000);
        viewSystemUsersPage.clickOnDeleteButton();


    }

}
