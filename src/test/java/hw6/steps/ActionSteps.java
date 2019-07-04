package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.DifferentElements;
import hw6.enums.UserTables;
import hw6.enums.WebsiteAndUserInfo;

import java.util.List;

public class ActionSteps extends BaseStep {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAsEntity(WebsiteAndUserInfo username, WebsiteAndUserInfo password) {
        homePage.userIconClick();
        homePage.fillLoginTextField(username.getText());
        homePage.fillPasswordTextField(password.getText());
        homePage.loginButtonClick();
    }

    @When("I click on Service subcategory in the header")
    public void iClickServiceInTheHeader() {
        homePage.serviceInTheHeaderClick();
    }

    @When("I click on Service subcategory in the left section")
    public void iClickServiceInTheLeftSection() {
        homePage.serviceInTheLeftSectionClick();
    }

    @When("I open Different Elements Page through Service header menu")
    public void iOpenDifferentElementsPageInServiceHeaderMenu() {
        homePage.serviceInTheHeaderClick();
        homePage.differentElementsInServiceInTheHeaderClick();
    }

    @When("I select checkboxes")
    public void iSelectCheckboxes(List<DifferentElements> checkboxes) {
        for (DifferentElements element : checkboxes) {
            selectAndClickElementByName("checkbox", element.getName());
        }
    }

    @When("I select radiobutton '([^\"]*)'")
    public void iSelectRadiobutton(DifferentElements radiobutton) {
        selectAndClickElementByName("radiobutton", radiobutton.getName());
    }

    @When("I select dropdown '([^\"]*)'")
    public void iSelectDropdown(DifferentElements dropdown) {
        selectAndClickElementByName("dropdown", dropdown.getName());
    }

    @When("I unselect checkboxes")
    public void iUnselectCheckboxes(List<DifferentElements> checkboxes) {
        for (DifferentElements element : checkboxes) {
            selectAndClickElementByName("checkbox", element.getName());
        }
    }

    @When("I click on User Table button in Service dropdown")
    public void iClickOnUserTableInServiceDropdown() {
        homePage.userTableInServiceInTheHeaderClick();
    }

    @When("I select vip checkbox for '([^\"]*)'")
    public void iSelectCheckboxOnUsersTable(UserTables name) {
        userTablePage.vipCheckboxOnUsersTableClickByName(name);
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void iClickOnDropdownOnUsersTable(UserTables name) {
        userTablePage.dropdownOnUsersTableClickByName(name);
    }
}
