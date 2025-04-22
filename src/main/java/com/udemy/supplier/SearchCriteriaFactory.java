package com.udemy.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SearchCriteriaFactory {

    private static final Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
    private static final Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
    private static final Predicate<List<WebElement>> allGender = allFemale.or(allMale);
    private static final Predicate<List<WebElement>> onlyUSA = (l) -> l.get(2).getText().equalsIgnoreCase("USA");
    private static final Predicate<List<WebElement>> allMaleUSA = allMale.and(onlyUSA);

    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();

    static {
        MAP.put("allMale", allMale);
        MAP.put("allFemale", allFemale);
        MAP.put("allGender", allGender);
        MAP.put("onlyUSA", onlyUSA);
        MAP.put("allMaleUSA", allMaleUSA);
    }

    public static Predicate<List<WebElement>> getCriteria(String criteriaName) {
        return MAP.get(criteriaName);
    }
}
