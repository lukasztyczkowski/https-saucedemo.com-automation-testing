package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage  {
    private WebDriver driver;
    private By checkoutButton = By.id("checkout");
    private By removeFirstFromCartButton = By.id("remove-sauce-labs-backpack");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }




    public void clickCheckout () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));

        driver.findElement(checkoutButton).click();




    }

    public boolean isProductInCart(int expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), expectedCount));
        List<WebElement> products = driver.findElements(By.className("cart_item"));

        return products.size() == expectedCount;
    }
    public void clickRemoveFirstFromCartButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(removeFirstFromCartButton).click();
    }
}
