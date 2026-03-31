package tests;

import base.Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void shouldNotLoginWithEmptyUsernameAndEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
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
    public void shouldLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"User should be redirected to inventory page");






    }
}
