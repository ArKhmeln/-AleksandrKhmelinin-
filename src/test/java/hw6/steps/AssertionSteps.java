package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.entities.User;
import hw6.enums.LogTexts;
import hw6.enums.UserTables;
import hw6.enums.WebsiteAndUserInfo;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseStep {

    private void assertElementsAreDisplayedInProperAmount(String name, int expectedAmount) {
        switch (name) {
            case("numberTypeDropdown"):
                checkIfElementsAreDisplayed(userTablePage.getNumberTypeDropdownsOnUsersTable(), expectedAmount);
                break;
            case ("userName"):
                checkIfElementsAreDisplayed(userTablePage.getUserNamesOnUsersTable(), expectedAmount);
                break;
            case ("descriptionImage"):
                checkIfElementsAreDisplayed(userTablePage.getDescriptionImagesOnUsersTable(), expectedAmount);
                break;
            case ("descriptionText"):
                checkIfElementsAreDisplayed(userTablePage.getDescriptionUnderImages(), expectedAmount);
                break;
        }
    }

    private void checkIfElementsAreDisplayed(List<WebElement> elements, int expectedAmount) {
        for(WebElement element : elements) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(elements.size(), expectedAmount);
    }

    @Then("Browser title equals '(.+)'")
    public void browserTitleEquals(WebsiteAndUserInfo expectedBrowserTitle) {
        assertEquals(TestContext.getDriver().getTitle(), expectedBrowserTitle.getText());
    }

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(WebsiteAndUserInfo expectedUsername) {
        assertEquals(TestContext.getDriver().findElement(By.id("user-name")).getText(), expectedUsername.getText());
    }

    @Then("Home Page should contain '(.+)' pictures")
    public void homePageShouldContainPictures(int amount) {
        assertEquals(homePage.getPictures().size(), amount);
    }

    @Then("Home Page should contain '(.+)' texts under pictures")
    public void homePageShouldContainTextsUnderPictures(int amount) {
        assertEquals(homePage.getTextsUnderPictures().size(), amount);
    }

    @Then("Home Page should contain '(.+)' texts above headline and description")
    public void homePageShouldContainTextsAboveHeadlineAndDescription(int amount) {
        assertEquals(homePage.getHeadlineAndDescription().size(), amount);
    }

    @Then("Service subcategory in the header should contain options")
    public void serviceInTheHeaderShouldContainOptions(List<String> options) {
        assertEquals(getTextsFromElements(homePage.getServiceElementsInTheHeader()), options);
    }

    @Then("Service subcategory in the left section should contain options")
    public void serviceInTheLeftSectionShouldContainOptions(List<String> options) {
        assertEquals(getTextsFromElements(homePage.getServiceElementsInTheLeftSection()), options);
    }

    @Then("Different elements page should contain '(.+)' checkboxes")
    public void differentElementsPageShouldContainCheckboxes(int amount) {
        assertEquals(differentElementsPage.getCheckboxes().size(), amount);
    }

    @Then("Different elements page should contain '(.+)' radios")
    public void differentElementsPageShouldContainRadios(int amount) {
        assertEquals(differentElementsPage.getRadiobuttons().size(), amount);
    }

    @Then("Different elements page should contain '(.+)' dropdown")
    public void differentElementsPageShouldContainDropdowns(int amount) {
        assertEquals(differentElementsPage.getDropdown().size(), amount);
    }

    @Then("Different elements page should contain '(.+)' buttons")
    public void differentElementsPageShouldContainButtons(int amount) {
        assertEquals(differentElementsPage.getButtons().size(), amount);
    }

    @Then("Different elements page should contain Right Section")
    public void differentElementsPageShouldContainRightSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("Different elements page should contain Left Section")
    public void differentElementsPageShouldContainLeftSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("Log should contain checkboxes names and its status corresponding to selected")
    public void logShouldContainCheckboxesNamesAndStatus(List<LogTexts> checkboxes) {
        for(LogTexts element: checkboxes) {
            assertTrue(checkLogText(differentElementsPage.getLogs(), element));
        }
    }

    @Then("Log should contain radiobutton name and its status corresponding to selected '(.+)'")
    public void logShouldContainRadiobuttonNameAndStatus(LogTexts radiobutton) {
        assertTrue(checkLogText(differentElementsPage.getLogs(), radiobutton));
    }

    @Then("Log should contain dropdown name and its status corresponding to selected '(.+)'")
    public void logShouldContainDropdownNameAndStatus(LogTexts dropdown) {
        assertTrue(checkLogText(differentElementsPage.getLogs(), dropdown));
    }

    @Then("Log should contain checkboxes names and its status corresponding to unselected")
    public void logShouldContainCheckboxesNamesAndUnselectedStatus(List<LogTexts> checkboxes) {
        for(LogTexts element: checkboxes) {
            assertTrue(checkLogText(differentElementsPage.getLogs(), element));
        }
    }

    @Then("'(.+)' NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void numberTypeDropdownsAreDisplayedOnUsersTable(int expectedAmount) {
        assertElementsAreDisplayedInProperAmount("numberTypeDropdown", expectedAmount);
    }

    @Then("'(.+)' User names are displayed on Users Table on User Table Page")
    public void userNamesAreDisplayedOnUsersTable(int expectedAmount) {
        assertElementsAreDisplayedInProperAmount("userName", expectedAmount);
    }

    @Then("'(.+)' Description images are displayed on Users Table on User Table Page")
    public void descriptionImagesAreDisplayedOnUsersTable(int expectedAmount) {
        assertElementsAreDisplayedInProperAmount("descriptionImage", expectedAmount);
    }

    @Then("'(.+)' Description texts under images are displayed on Users Table on User Table Page")
    public void descriptionTextsAreDisplayedOnUsersTable(int expectedAmount) {
        assertElementsAreDisplayedInProperAmount("descriptionText", expectedAmount);
    }

    @Then("User table contains following values:")
    public void userTableContainValues(List<User> values) {
        for(int i = 0; i < values.size(); i++) {
            assertEquals(userTablePage.getNumbersOnUsersTable().get(i).getText(), values.get(i).getNumber());
            assertEquals(userTablePage.getUserNamesOnUsersTable().get(i).getText(), values.get(i).getUser());
            assertEquals(userTablePage.getDescriptionUnderImages().get(i).getText().replace("\n", " "),
                    values.get(i).getDescription());
        }
    }

    //List<Map<>> variant
    /*@Then("User table contains following values:")
    public void userTableContainValues(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for(int i = 0; i < list.size(); i++) {
            String actualNumber = userTablePage.getNumbersOnUsersTable().get(i).getText();
            assertEquals(actualNumber, list.get(i).get("Number"));
            String actualUser = userTablePage.getUserNamesOnUsersTable().get(i).getText();
            assertEquals(actualUser, list.get(i).get("User"));
            String actualDescription = userTablePage.getDescriptionUnderImages()
                    .get(i).getText().replace("\n", " ");
            assertEquals(actualDescription, list.get(i).get("Description"));
        }
    }*/

    @Then("'(.+)' log row has '(.+)' text in log section")
    public void logRowHasText(int amount, LogTexts text) {
        assertTrue(checkLogText(userTablePage.getLogs(), text));
        assertEquals(userTablePage.getLogs().size(), amount);
    }

    @Then("Droplist for user '(.+)' contains values")
    public void dropListContainsValues(UserTables name, List<String> expectedValues) {
        List<String> actualValues = getTextsFromElements(userTablePage.getDropdownElementsOnUsersTableByName(name));
        assertEquals(actualValues, expectedValues);
    }
}
