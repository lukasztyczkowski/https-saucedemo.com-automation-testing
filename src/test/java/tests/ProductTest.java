package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest  {
    @Test
    public void shouldSingleProductAddSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");
        productPage.openCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(
                cartPage.isProductInCart(1),
                "Cart badge should show 1 product"
        );
    }
    @Test
    public void shouldTwoProductAddSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickSecondProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(2)
                , "Two products should be in the cart");

        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(
                cartPage.isProductInCart(2),
                "Cart badge should show 2 products"
        );
    }
    @Test
    public void removeFirstProductSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");

        productPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickRemoveFirstFromCartButton();

        Assert.assertTrue(cartPage.isProductInCart(0),
                "Cart badge should show 0 product");
    }
    @Test
    public void removeFirstProductAndContiniueShopping(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(1)
        , "Cart badge should show 1 product");

        productPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickRemoveFirstFromCartButton();
        cartPage.clickContinueShoppingButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,
                "User should be redirected to inventory page");


    }
    @Test
    public void addTwoProductSuccessfullyAndRemoveFirstProductAndContinueShopping(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickSecondProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(2),
                "Cart badge should show 2 products");

        productPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickRemoveFirstFromCartButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(1),
                "Cart badge should show 1 product");

        cartPage.clickContinueShoppingButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,
                "User should be redirected to inventory page");
    }
    @Test
    public void addTwoProductsSuccessfullyAndRemoveSecondProduct(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickSecondProductButton();

        Assert.assertTrue(productPage.isCartBadgeEqual(2),
                "Cart badge should show 2 products");
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickRemoveSecondFromCartButton();

        Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 1 ,
                "Cart should contain exactly 1 product after removal");

    }
    @Test
    public void openCartWithNoProducts(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.openCart();
        CartPage cartPage = new CartPage(driver);
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,
                "User should be redirected to cart page");

        Assert.assertTrue(
                cartPage.isCartPageOpened(),
                "Cart badge should show 0 product"
        );
    }
    @Test
    public void removeProductOnInventoryPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProductButton();
        productPage.clickRemoveFirstFromCartButton();

        Assert.assertTrue(productPage.isCartBadgeVisible(),
                "Cart badge should not be visible when cart is empty");


    }
}
