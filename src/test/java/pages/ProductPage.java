package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    private By firstProductButton=By.id("add-to-cart-sauce-labs-backpack");
    private By secondProductButton=By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBadge = By.className("shopping_cart_link");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProductButton(){
        driver.findElement(firstProductButton).click();
    }
    public void clickSecondProductButton(){
        driver.findElement(secondProductButton).click();
    }
    public boolean isProductInCart(int expectedCaount){
        String count = driver.findElement(cartBadge).getText();
        return Integer.parseInt(count) == expectedCaount;
    }

}
