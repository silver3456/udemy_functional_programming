package com.udemy.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static Predicate<WebElement> isBlank = (webElement -> webElement.getText().trim().isEmpty());
    private static Predicate<WebElement> hasLetterS = (webElement -> webElement.getText().toLowerCase().contains("s"));

    public static List<Predicate<WebElement>> get() {
        List<Predicate<WebElement>> rules = new ArrayList<>();
        rules.add(isBlank);
        rules.add(hasLetterS);
        return rules;
    }



}
