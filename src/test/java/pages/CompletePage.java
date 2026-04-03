package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePage {
    private WebDriver driver;
    private By backpackButton= By.id("back-to-products");


    public CompletePage(WebDriver driver) {
        this.driver=driver;

    }

    public void clickBackToHomeButton(){

        driver.findElement(backpackButton).click();
    }


}
