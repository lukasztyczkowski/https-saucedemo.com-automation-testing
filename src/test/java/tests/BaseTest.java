package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {
    protected WebDriver driver;
    protected static final String BaseURL = "https://saucedemo.com";
    @BeforeMethod
    public void beforeMethod() {}

    @BeforeMethod
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }


    }


}
