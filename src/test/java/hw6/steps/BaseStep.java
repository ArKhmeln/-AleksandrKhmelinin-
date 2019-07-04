package hw6.steps;

import hw6.enums.LogTexts;
import hw6.hooks.TestContext;
import hw6.pages.DifferentElementsPage;
import hw6.pages.HomePage;
import hw6.pages.UserTablePage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseStep {

    protected HomePage homePage;

    protected DifferentElementsPage differentElementsPage;

    protected UserTablePage userTablePage;

    protected BaseStep() {
        homePage = hw6.pages.HomePage.getInstance(TestContext.getDriver());
        differentElementsPage = hw6.pages.DifferentElementsPage.getInstance(TestContext.getDriver());
        userTablePage = hw6.pages.UserTablePage.getInstance(TestContext.getDriver());
    }

    protected List<String> getTextsFromElements(List<WebElement> elements) {
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    protected void selectAndClickElementByName(String buttonName, String elementName) {
        switch (buttonName) {
            case "checkbox":
                findElementByName(differentElementsPage.getCheckboxes(), elementName);
                break;
            case "radiobutton":
                findElementByName(differentElementsPage.getRadiobuttons(), elementName);
                break;
            case "dropdown":
                findElementByName(differentElementsPage.getDropdownMenuElements(), elementName);
                break;
        }
    }

    protected void findElementByName(List<WebElement> buttons, String elementName) {
        for(WebElement element: buttons) {
            if (element.getText().equals(elementName)) {
                element.click();
                break;
            }
        }
    }

    protected boolean checkLogText(List<WebElement> logoElements, LogTexts searchingText) {
        for (WebElement element : logoElements) {
            if (element.getText().endsWith(searchingText.getText())) {
                return true;
            }
        }
        return false;
    }
}
