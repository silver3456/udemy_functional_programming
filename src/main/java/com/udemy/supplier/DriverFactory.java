package com.udemy.supplier;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    // Example of using Supplier in Test Automation
    private static final Supplier<WebDriver> chromeSupplier = () -> {
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        WebDriverManager.firefoxdriver().clearResolutionCache().setup();
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox", firefoxSupplier);
    }

    public static WebDriver getDriver(String browser) {
        return MAP.get(browser).get();
    }
}
