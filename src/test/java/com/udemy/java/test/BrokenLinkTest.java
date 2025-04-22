package com.udemy.java.test;

import com.udemy.supplier.DriverFactory;
import com.udemy.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        boolean result = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getDomProperty("src"))
                .map(src -> LinkUtil.getResponseCode(src))
                .anyMatch(rc -> rc != 200);
        Assert.assertFalse(result);
    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
