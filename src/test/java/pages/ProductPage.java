package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    private By firstProductButton=By.id("add-to-cart-sauce-labs-backpack");
    private By secondProductButton=By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButton = By.className("shopping_cart_link");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProductButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(firstProductButton).click();
    }
    public void clickSecondProductButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(secondProductButton).click();
    }
    public boolean isProductInCart(int expectedCaount){
        String count = driver.findElement(cartButton).getText();
        return Integer.parseInt(count) == expectedCaount;
    }

    public void openCart() {
        driver.findElement(cartButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("cart"));
    }
}
