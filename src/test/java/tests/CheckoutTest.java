package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends BaseTest {
	@Test
	public void shouldFinishCheckoutSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge sholud show 1 product");

        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html")
                , "Should be on cart page");
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(1)
                , "Cart in cart sholud show 1 product");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("Jan","Kot","80-250");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(cartPage.waitForUrlToContain("checkout-step-two.html"),
                "User should be on checkout summary page" );

                Assert.assertTrue(
                checkOutPage.isCheckoutComplete(),
                "Checkout should be completed successfully"
        );


        checkOutPage.clickFinishButton();
        CompletePage completePage = new CompletePage(driver);
        completePage.clickBackToHomeButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com/inventory.html"),
                "Back to homepage page");




    }
    @Test
    public void shouldFinishCheckoutSuccessfullyWithTwoProducts(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickSecondProductButton();
        Assert.assertTrue(productPage.isCartBadgeEqual(2)
                ,"Cart badge should show 2 products"
        );
        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html"));
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(2)
                , "Two products should be in the cart");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("Jan","Kot","80-250");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(checkOutPage.waitForUrlToContain("checkout-step-two.html"),
                "User should be on checkout summary page");
        checkOutPage.clickFinishButton();

        Assert.assertTrue(
                checkOutPage.isCheckoutComplete(),
                "Checkout should be completed successfully"
        );
    }
    @Test
    public void shouldFinishCheckoutSuccessfullyWithThreeProducts(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickSecondProductButton();
        productPage.clickThirdProductButton();
        Assert.assertTrue(productPage.isCartBadgeEqual(3)
                , "Cart badge should show 3 products");

        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html"));
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(3)
                , "Three products should be in the cart");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("Jan","Kot","80-250");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(cartPage.waitForUrlToContain("checkout-step-two.html"),
                "User should be on checkout summary page");
        checkOutPage.clickFinishButton();

        Assert.assertTrue(
                checkOutPage.isCheckoutComplete(),
                "Checkout should be completed successfully"
        );
    }
    @Test
    public void shouldCheckoutSuccessfullyWitchWithoutUserName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");

        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html"));
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(1)
                , "Cart should be in the cart");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("","Kot","80-250");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(cartPage.waitForUrlToContain("checkout-step-one.html"),
                "User should be on Checkout page");

        Assert.assertTrue(
                checkOutPage.isErrorDisplayed(),
                "Error message should be visible"
        );
    }
    @Test
    public void shouldCheckoutSuccessfullyWitchWithoutSurname(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");

        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html"));
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(1),
                "Cart should be in the cart");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("Jan","","80-250");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(cartPage.waitForUrlToContain("checkout-step-one.html"),
                "User should be on Checkout page");

        Assert.assertTrue(
                checkOutPage.isErrorDisplayed(),
                "Error message should be visible"
        );

    }
    @Test
    public void shouldCheckoutWitchNoPostalCode(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");

        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html"));
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(1),
                "Cart should be in the cart");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("Jan","Kot","");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(checkOutPage.waitForUrlToContain("checkout-step-one.html"),
                "User should be on Checkout page");

        Assert.assertTrue(
                checkOutPage.isErrorDisplayed(),
                "Error message should be visible"
        );
    }
    @Test
    public void shouldCheckoutSuccessfullyWitchWithoutAnyData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");

        productPage.openCart();
        Assert.assertTrue(productPage.waitForUrlToContain("cart.html"));
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart(1),
                "Cart should be in the cart");
        cartPage.clickCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterUserData("","","");
        checkOutPage.clickContinueButton();
        Assert.assertTrue(checkOutPage.waitForUrlToContain("checkout-step-one.html"),
                "User should be on Checkout page");

        Assert.assertTrue(
                checkOutPage.isErrorDisplayed(),
                "Error message should be visible"
        );


    }



}
