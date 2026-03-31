package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private WebDriver driver;

    public  CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continiueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By succcessMessage = By.id("success-message");


    public void enterUserData(String name , String surname, String coede) {
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(surname);
        driver.findElement(postalCode).sendKeys(coede);

    }
    public void clickContinueButton() {
        driver.findElement(continiueButton).click();
    }
    public void clickFinishButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("finish")));

        driver.findElement(finishButton).click();
    }
    public void clickSuccessMessage() {
        driver.findElement(succcessMessage).click();
    }
    private By cartButton = By.className("shopping_cart_link");

    public void openCart() {
        driver.findElement(cartButton).click();
    }


    public boolean isCheckoutComplete() {
        return driver.findElement(cartButton).isDisplayed();
    }
}
