package tests;

import base.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
	@Test
	public void shouldFinishCheckoutSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();

        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);

        checkOutPage.enterUserData("Jan","Kot","80-250");
        checkOutPage.clickContinueButton();
        checkOutPage.clickFinishButton();

        Assert.assertTrue(
                checkOutPage.isCheckoutComplete(),
                "Checkout should be completed successfully"
        );


    }

}
