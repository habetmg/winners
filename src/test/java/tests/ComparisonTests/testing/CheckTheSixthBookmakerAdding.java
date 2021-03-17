package tests.ComparisonTests.testing;

import api.BookmakerApiCalls;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;


class CheckTheSixthBookmakerAdding extends BaseTest  {

    @BeforeMethod(description = "Create one bookmaker")
    public void createBookmaker() throws Exception {
        bookmakerApiCalls.createBookmaker();
        bookmakerApiCalls.uploadBookmakerLogo(BookmakerApiCalls.bookmakerId);
        bookmakerApiCalls.addBookmakerProfile(BookmakerApiCalls.bookmakerId);
        bookmakerApiCalls.addBookmakerBonus(BookmakerApiCalls.bookmakerId);
        bookmakerApiCalls.addBookmakerReviews(BookmakerApiCalls.bookmakerId);
        bookmakerApiCalls.publishBookmaker(BookmakerApiCalls.bookmakerId);
    }

    @Test(description = "Check Functionalities adding six bookmakers to comparison Chart WN-163")
    public void checkTheSixthBookmakerAdding() throws Exception {

        mainPage.selectTabInHeader("Bookmaker Comparison");
        Thread.sleep(5000);
        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmakerName,"Plus");

        softAssert.assertEquals("Number of selected bookmakers differ!!!",
                "\"1\"","\"" +bookmakersTablePage.getNumberOfCheckedBookmakers().size()+"\"");

        comparisonPage.currentUrl0=webDriver().getCurrentUrl();

        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmakerName,"Plus");
        softAssert.assertEquals("Number of selected bookmakers is not 0 !!!",
                       "\"0\"",  "\"" +bookmakersTablePage.getNumberOfCheckedBookmakers().size()+"\"");

        bookmakerApiCalls.createFiveBookmakers();
        bookmakerApiCalls.uploadBookmakerLogo(BookmakerApiCalls.bookmaker_Id_1);
        bookmakerApiCalls.addBookmakerProfile(BookmakerApiCalls.bookmaker_Id_1);
        bookmakerApiCalls.addBookmakerBonus(BookmakerApiCalls.bookmaker_Id_1);
        bookmakerApiCalls.addBookmakerReviews(BookmakerApiCalls.bookmaker_Id_1);
        bookmakerApiCalls.publishBookmaker(BookmakerApiCalls.bookmaker_Id_1);
        bookmakerApiCalls.uploadBookmakerLogo(BookmakerApiCalls.bookmaker_Id_2);
        bookmakerApiCalls.addBookmakerProfile(BookmakerApiCalls.bookmaker_Id_2);
        bookmakerApiCalls.addBookmakerBonus(BookmakerApiCalls.bookmaker_Id_2);
        bookmakerApiCalls.addBookmakerReviews(BookmakerApiCalls.bookmaker_Id_2);
        bookmakerApiCalls.publishBookmaker(BookmakerApiCalls.bookmaker_Id_2);
        bookmakerApiCalls.uploadBookmakerLogo(BookmakerApiCalls.bookmaker_Id_3);
        bookmakerApiCalls.addBookmakerProfile(BookmakerApiCalls.bookmaker_Id_3);
        bookmakerApiCalls.addBookmakerBonus(BookmakerApiCalls.bookmaker_Id_3);
        bookmakerApiCalls.addBookmakerReviews(BookmakerApiCalls.bookmaker_Id_3);
        bookmakerApiCalls.publishBookmaker(BookmakerApiCalls.bookmaker_Id_3);
        bookmakerApiCalls.uploadBookmakerLogo(BookmakerApiCalls.bookmaker_Id_4);
        bookmakerApiCalls.addBookmakerProfile(BookmakerApiCalls.bookmaker_Id_4);
        bookmakerApiCalls.addBookmakerBonus(BookmakerApiCalls.bookmaker_Id_4);
        bookmakerApiCalls.addBookmakerReviews(BookmakerApiCalls.bookmaker_Id_4);
        bookmakerApiCalls.publishBookmaker(BookmakerApiCalls.bookmaker_Id_4);
        bookmakerApiCalls.uploadBookmakerLogo(BookmakerApiCalls.bookmaker_Id_5);
        bookmakerApiCalls.addBookmakerProfile(BookmakerApiCalls.bookmaker_Id_5);
        bookmakerApiCalls.addBookmakerBonus(BookmakerApiCalls.bookmaker_Id_5);
        bookmakerApiCalls.addBookmakerReviews(BookmakerApiCalls.bookmaker_Id_5);
        bookmakerApiCalls.publishBookmaker(BookmakerApiCalls.bookmaker_Id_5);

        bookmakersTablePage.refreshPage();
        Thread.sleep(1000);

        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmaker_Name_1,"Plus");
        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmaker_Name_2,"Plus");
        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmaker_Name_3,"Plus");
        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmaker_Name_4,"Plus");
        bookmakersTablePage.clickOnButtonsByBookmakerName(BookmakerApiCalls.bookmaker_Name_5,"Plus");

        bookmakersTablePage.refreshPage();
        Thread.sleep(1000);

        softAssert.assertEquals("Not 5 bookmakers are checked!!!",
                "\"5\"", "\"" +bookmakersTablePage.getNumberOfDisabledBookmakers()+"\"");

        webDriver().get(comparisonPage.currentUrl0);

        bookmakersTablePage.refreshPage();
        Thread.sleep(4000);

        softAssert.assertEquals("Number of selected bookmakers differ!!!",
                "\"1\"","\"" +bookmakersTablePage.getNumberOfCheckedBookmakers()+"\"");

        softAssert.assertEquals("Not the same bookmaker was selected after URL refresh!!!",
                bookmakerApiCalls.bookmakerName,comparisonPage.getNameFromLegendElement());
        softAssert.assertAll();
    }

   @AfterTest(alwaysRun = true,description = "Delete created Bookmakers")
   public void deleteCreatedBookmakers() throws Exception {
       bookmakerApiCalls.deleteBookmakerById(BookmakerApiCalls.bookmaker_Id_1);
       bookmakerApiCalls.deleteBookmakerById(BookmakerApiCalls.bookmaker_Id_2);
       bookmakerApiCalls.deleteBookmakerById(BookmakerApiCalls.bookmaker_Id_3);
       bookmakerApiCalls.deleteBookmakerById(BookmakerApiCalls.bookmaker_Id_4);
       bookmakerApiCalls.deleteBookmakerById(BookmakerApiCalls.bookmaker_Id_5);
       bookmakerApiCalls.deleteBookmakerById(BookmakerApiCalls.bookmakerId);
   }
}