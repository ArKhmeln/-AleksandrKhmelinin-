package hw4.Ex1;

import com.codeborne.selenide.SelenideElement;
import hw4.hw4Base.BaseTest;
import hw4.pages.TableWithPages;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.close;
import static hw4.enums.general.HeaderServiceDropdown.getHeaderServiceDropdownText;
import static hw4.enums.general.LeftSectionServiceDropdown.getLeftSectionServiceDropdownText;
import static hw4.enums.general.LogTexts.LENGTH_10;
import static hw4.enums.general.WebsiteAndUserInfo.SEARCH_TEXT;
import static hw4.enums.general.WebsiteAndUserInfo.USER_NAME;

public class Exercise1 extends BaseTest {

    @Test
    public void ex1Text() {
        TableWithPages tableWithPages = new TableWithPages();
        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.userName().shouldHave(text(USER_NAME.getText()));
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.serviceElementsFromHeader().shouldHave(texts(getHeaderServiceDropdownText()));
        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePage.serviceElementsFromLeftSection().shouldHave(texts(getLeftSectionServiceDropdownText()));
        //7. Open through the header menu Service -> Table with pages
        homePage.clickTableWithPagesInHeaderService();
        //8. Check that default value for “Show entries” dropdown is 5
        tableWithPages.showEntries(5).shouldBe(visible);
        //9. Assert that there is Right Section
        tableWithPages.rightSection().should(exist);
        //10. Assert that there is Left Section
        tableWithPages.leftSection().should(exist);
        //11. Select new value for the entries in the dropdown list
        tableWithPages.selectEntryInDropdown(10);
        //12. Assert that for the dropdown there is an individual log row and value is corresponded to the value of dropdown.
        tableWithPages.checkLogLengthValue(10).shouldHave(text(LENGTH_10.getText()));
        //13. Assert that in the table displayed corrected amount of entries
        tableWithPages.dataTable().shouldHaveSize(10);
        //14. Type in “Search” text field
        tableWithPages.typeInSearch(SEARCH_TEXT.getText());
        //15. Assert the table contains only records with Search field value
        for(SelenideElement element : tableWithPages.dataTable()) {
            element.shouldHave(text(SEARCH_TEXT.getText()));
        }
        close();
    }
}
