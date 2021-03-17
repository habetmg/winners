package tests.ComparisonTests.production;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckBonusComparisonButtonFunctionalityProd extends BaseTest {

    @Test(description = "WN-114 Bookmakers full review checking with changed country and checking list and chart after that. ")
    public void checkBonusComparisonButtonFunctionality() throws InterruptedException {

        mainPage.openUrl("https://winners.net");
        filterPage.selectCountryInHeader("All Countries");
        softAssert.assertTrue(webDriver().getCurrentUrl().contains("countries=__all__")
                ,"'All Countries was not selected!!!'");
         //It should change country in "Best Betting Sites for" and update list of bookmakers for picked country.

        mainPage.selectTabInHeader("Bookmaker Comparison");
        bookmakersTablePage.clickOnButtonsByBookmakerName("Betway", "Full Review");

        softAssert.assertEquals(webDriver().getCurrentUrl(),"https://winners.net/review/bet365","Wrong Url - Selected!!!");

        comparisonPage.clickOnBonusesButton();

        softAssert.assertTrue(comparisonPage.bookmakerNameInHeader ().contains("Betway")
                ,"Wrong name was Displayed!!!");
        softAssert.assertEquals(comparisonPage.bookmakerNameIsInHeader (),"div.StickyHeader"
                ,"Not in Sticky Header");
        softAssert.assertTrue(comparisonPage.compareWithOthersInHeader ().contains("COMPARE WITH OTHERS")
                ,"Wrong name was Displayed!!!");
        softAssert.assertEquals(comparisonPage.compareWithOthersIsInHeader (),"div.StickyHeader"
                ,"Not in Sticky Header");
        softAssert.assertTrue(comparisonPage.websideInHeader ().contains("WEBSITE")
                ,"Wrong name was Displayed!!!");
        softAssert.assertEquals(comparisonPage.websideIsInHeader (),"div.StickyHeader"
                ,"Not in Sticky Header");

        comparisonPage.clickBonusComparisonButon();

        softAssert.assertTrue(webDriver().getCurrentUrl().contains("countries=__all__")
                ,"'All Countries was not selected!!!'");
        softAssert.assertTrue(comparisonPage.getNamesAndColorsFromLegend(1).contains("Betway"));
        softAssert.assertTrue(bookmakersTablePage.valueInSortByDropDown().equals("Bonus Amount")
                ,"Wrong Filter was set!!!");
//          * List of bookmakers sorted by Bonus Amount
    }
}
