package com.udemy.java.test;

import com.udemy.supplier.DriverFactory;
import com.udemy.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> list = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getDomProperty("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());
        Assert.assertEquals(list.size(), 0, list.toString());
    }

    @Test
    public void linkGoogleTest() {
        this.driver.get("https://www.google.com");
        System.out.println("Before:: " + LocalDateTime.now());
        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e -> e.getDomProperty("href"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());
        System.out.println("After:: " + LocalDateTime.now());
        Assert.assertEquals(list.size(), 0, list.toString());


    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
