package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;

import static hw6.enums.WebsiteAndUserInfo.LINK_MAIN;

public class GivenSteps {

    @Given("I am on the JDI Index Page")
    public void iAmOnTheJdiIndexPage() {
        TestContext.getDriver().get(LINK_MAIN.getText());
    }
}
