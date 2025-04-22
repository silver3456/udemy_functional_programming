package com.udemy.java.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.pages.TablePage;
import com.udemy.supplier.DriverFactory;
import com.udemy.supplier.SearchCriteriaFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxSelectionTest {
    private WebDriver driver;
    private TablePage page;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        page = new TablePage(driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void tableRowTest(Predicate<List<WebElement>> criteria) {
        page.goTo();
        page.selectCheckbox(criteria);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }



    @DataProvider(name = "criteriaProvider")
    public Object[] testData() {
        Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
        Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
        Predicate<List<WebElement>> allGender = allFemale.or(allMale);
        Predicate<List<WebElement>> onlyUSA = (l) -> l.get(2).getText().equalsIgnoreCase("USA");
        Predicate<List<WebElement>> allMaleUSA = allMale.and(onlyUSA);


        return new Object[]{
                SearchCriteriaFactory.getCriteria("allMale"),
                SearchCriteriaFactory.getCriteria("allFemale"),
                SearchCriteriaFactory.getCriteria("allGender"),
                SearchCriteriaFactory.getCriteria("onlyUSA"),
                SearchCriteriaFactory.getCriteria("allMaleUSA"),
        };

        //    @DataProvider(name = "criteriaProvider")
//    public Object[] testData() {
//        Predicate<List<WebElement>> allMale = (l) -> l.get(1).getText().equalsIgnoreCase("male");
//        Predicate<List<WebElement>> allFemale = (l) -> l.get(1).getText().equalsIgnoreCase("female");
//        Predicate<List<WebElement>> allGender = allFemale.or(allMale);
//        Predicate<List<WebElement>> onlyUSA = (l) -> l.get(2).getText().equalsIgnoreCase("USA")
//        Predicate<List<WebElement>> allMaleUSA = allMale.and(onlyUSA);


//        return new Object[]{
//                allMale,
//                allFemale,
//                allGender,
//                onlyUSA,
//                allMaleUSA
//        };
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
