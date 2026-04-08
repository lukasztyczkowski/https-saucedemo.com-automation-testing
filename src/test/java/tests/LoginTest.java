package tests;

import base.Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void shouldLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Boolean isUrsCorrect = wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));


        Assert.assertTrue(isUrsCorrect,"User should be redirected to inventory page");

    }



    @Test
    public void shouldNotLoginWithEmptyUsernameAndEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be visible"
        );


        Assert.assertEquals(
                driver.getCurrentUrl(),"https://www.saucedemo.com/",
                "User should stay on login page"
        );

    }
    @Test
    public void shouldNotLoginWithEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("https://www.saucedemo.com/"),
                "User should stay on login page"
        );
        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be visible"
        );
    }

    @Test
    public void shouldNotLoginWithEmptyUsername () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("https://www.saucedemo.com/"),
                "User should stay on login page"
        );
        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be visible"
        );

    }
    @Test
    public void shouldNotLoginWithWrongUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_username","secret_sauce");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com"),
                "User should stay on login page"
        );
        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be visible"
        );
    }


    @Test
    public void shouldNotLoginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("saucedemo.com"),
                "User should stay on login page"
        );
        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be visible"
        );
    }
    @Test
    public void shouldNotLoginWithLockedUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user","secret_sauce");


        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be visible"
        );


        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Proper error message should be displayed");

        Assert.assertTrue(
                loginPage.isLoginPageOpened(),
                "User should stay on login page");



    }

}
