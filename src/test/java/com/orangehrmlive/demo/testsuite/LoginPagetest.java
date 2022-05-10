package com.orangehrmlive.demo.testsuite;

import com.google.inject.RestrictedBindingSource;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPagetest extends TestBase {

LoginPage loginPageObj;
HomePage homePageObj;

/*
Enter “Admin” username
* Enter “admin123 password

 */

@BeforeMethod
    public void inBeginning(){
    loginPageObj =new LoginPage();
    homePageObj =new HomePage();
}
/*
1. verifyUserShouldLoginSuccessFully()
Enter username
Enter password
Click on Login Button
Verify "WelCome" Message
*/


@Test
    public void verifyUserShouldLoginSuccessFully() throws InterruptedException {

    loginPageObj.enterUserName("Admin");

    loginPageObj.enterPassword("admin123");
    loginPageObj.clickOnLoginButton();
    String expectedWelcomeMessage = "Welcome";
    Thread.sleep(1000);
    String actualMessage = loginPageObj.getWelcomeTest();
    String splitMessage[]=actualMessage.split(" ");
    String welcomeMessageDispalyed = splitMessage[0];

    if(welcomeMessageDispalyed.equalsIgnoreCase("welcome"))
    {
        System.out.println("You have successfully log in ");

    }
}

/*
2. verifyThatTheLogoDisplayOnHomePage()
Login To The application
Verify Logo is Displayed
 */

@ Test

public void   verifyThatTheLogoDisplayOnHomePage() throws InterruptedException {

    verifyUserShouldLoginSuccessFully();
    homePageObj.isLogoDisplayed();

}

/*
3. verifyUserShouldLogOutSuccessFully()
Login To The application
Click on User Profile logo
Mouse hover on "Logout" and click
Verify the text "Login Panel" is displayed
 */


    @Test

    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {

        verifyUserShouldLoginSuccessFully();
        homePageObj.mouseHoverAndClickOnWelcomeText();
        Thread.sleep(1500);
        homePageObj.mouseHoverAndClickLogOutButton();
        String actualMessage = loginPageObj.getTextFromLoginPanel();
        Assert.assertEquals("You are not on login page","LOGIN Panel",actualMessage);

    }




}
