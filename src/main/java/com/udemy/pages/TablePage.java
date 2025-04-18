package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class TablePage {
    private final WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
    }

    public void selectCheckbox(Predicate<List<WebElement>> criteria) {
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(trList -> trList.findElements(By.tagName("td"))) // td list
                .filter(tdList -> tdList.size() == 4) //make sure there are 4 tags inside the list, error check
                .filter(criteria)
                .map(tdList -> tdList.get(3))// td containing checkbox
                .map(td -> td.findElement(By.tagName("input"))) //checkbox element
                .forEach(WebElement::click);
    }

}
