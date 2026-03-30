package tests;

import base.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {
    @Test
    public void ProductTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickSecondProductButton();

        Assert.assertTrue(productPage.isProductInCart(2), "Two products should be in the cart");


    }
}
