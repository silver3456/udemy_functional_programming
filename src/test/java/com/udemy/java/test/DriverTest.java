package com.udemy.java.test;

import com.udemy.supplier.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    /**
     @Parameters("browser")
    public void beforeSetUp(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);

        driver.manage().timeouts().implicitlyWait(getDefaultWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
     */

    @Test
    public void googleTest(){
//        this.driver.get("https://google.com/");
        this.driver.get("https://yandex.ru/");
    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
