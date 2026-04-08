package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    private By backToShopButton = By.id("back-to-products");


    public CompletePage(WebDriver driver) {
        super(driver);


    }

    public void clickBackToHomeButton(){

        driver.findElement(backToShopButton).click();
    }


}
