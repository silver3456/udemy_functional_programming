package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ElectronicDevicesPage {
    private final WebDriver driver;

    public ElectronicDevicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table#prods tr")
    private List<WebElement> rows;

    @FindBy(id = "result")
    private WebElement verifyButton;

    @FindBy(id = "status")
    private WebElement status;

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
    }

    public void selectMinPriceRow() {
        Optional<List<WebElement>> minRow = rows.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .filter(tdList -> tdList.size() == 4) //make sure there are 4 tags inside the list, error check
                .min(Comparator.comparing(tdList -> Integer.valueOf(tdList.get(2).getText())));

        if (minRow.isPresent()) {
            List<WebElement> cells = minRow.get();
            cells.get(3).findElement(By.tagName("input")).click();
        }
        verifyButton.click();
    }

    public String getStatus() {
        return this.status.getText().trim();
    }
}
