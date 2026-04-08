package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage  {

    private By checkoutButton = By.id("checkout");
    private By removeFirstFromCartButton = By.id("remove-sauce-labs-backpack");
    private By removeSecondFromCartButton = By.id("remove-sauce-labs-bike-light");
    private By continiueShoppingButton = By.id("continue-shopping");
    private By thankYouMessage = By.className("complete-header");


    public CartPage(WebDriver driver) {
        super(driver);

    }




    public void clickCheckout () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));

        driver.findElement(checkoutButton).click();




    }
    public boolean isCartPageOpened() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
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
    public void clickRemoveSecondFromCartButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(removeSecondFromCartButton).click();
    }
    public void clickContinueShoppingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(continiueShoppingButton).click();
    }
    public int getNumberOfProductsInCart(){
        return driver.findElements(By.className("cart_item")).size();
    }
    public String getThankYouMessage(){
        return driver.findElement((thankYouMessage)).getText();
    }

}
