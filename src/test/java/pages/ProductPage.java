package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {


    private By firstProductButton=By.id("add-to-cart-sauce-labs-backpack");
    private By secondProductButton=By.id("add-to-cart-sauce-labs-bike-light");
    private By thirdProductButton =By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By removeFirstFromCartButton = By.id("remove-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        super(driver);

    }





    public void clickFirstProductButton(){
        wait.until(ExpectedConditions.elementToBeClickable(firstProductButton)).click();

    }
    public void clickSecondProductButton(){
        wait.until(ExpectedConditions.elementToBeClickable(secondProductButton)).click();

    }
    public void clickThirdProductButton(){
        wait.until(ExpectedConditions.elementToBeClickable(thirdProductButton)).click();

    }
    public void clickRemoveFirstFromCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(removeFirstFromCartButton)).click();

    }

    public void openCart() {
        driver.findElement(cartBadge).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("cart"));
    }

    public boolean isCartBadgeEqual(int expectedCount){

        String count = driver.findElement(cartBadge).getText();
        return Integer.parseInt(count) == expectedCount;
    }
    public boolean isCartBadgeVisible() {
        return driver.findElement(cartBadge).isDisplayed();
    }


}
