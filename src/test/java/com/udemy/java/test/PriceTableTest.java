package com.udemy.java.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.pages.ElectronicDevicesPage;
import com.udemy.pages.TablePage;
import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class PriceTableTest {

    private WebDriver driver;
    private ElectronicDevicesPage devicesPage;

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        devicesPage = new ElectronicDevicesPage(driver);
    }

    @Test()
    public void minPriceTest() {
        devicesPage.goTo();
        devicesPage.selectMinPriceRow();
        String status = devicesPage.getStatus();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        Assert.assertEquals(status, "PASS");

    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
