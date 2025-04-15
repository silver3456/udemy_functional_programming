package com.udemy.java.test;

import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void yandexTest() {

        this.driver.get("https://yandex.ru/");
        // Example of using Consumer
        // It returns a list of WebElements, and we provide the behavior to this data
        this.driver.findElements(By.tagName("a")).
                forEach(e-> System.out.println(e.getText()));
    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
