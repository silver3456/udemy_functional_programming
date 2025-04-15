package com.udemy.java.test;

import com.udemy.predicate.Rules;
import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.function.Predicate;

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
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
//                forEach(e-> System.out.println(e.getText()));

        // Example of Predicate
        // Remove all blank elements
        Predicate<WebElement> isBlank = (webElement -> webElement.getText().trim().isEmpty());

        //Remove 's' or 'S'
        Predicate<WebElement> hasLetterS = (webElement -> webElement.getText().toLowerCase().contains("c"));
        System.out.println("Before:: " +  elements.size());
        elements.removeIf(isBlank.or(hasLetterS));
        System.out.println("After:: " +  elements.size());
        elements.forEach(e-> System.out.println(e.getText()));

    }

    @Test
    public void googleTest() {

        this.driver.get("https://google.com/");

        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
        System.out.println("Before:: " +  elements.size());
//        Rules.get().forEach(rule -> elements.removeIf(rule));
        Rules.get().forEach(elements::removeIf);

        System.out.println("After:: " +  elements.size());
        elements.forEach(e-> System.out.println(e.getText()));



    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
