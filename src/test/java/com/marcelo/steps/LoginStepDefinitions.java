package com.marcelo.steps;

import com.marcelo.screenplay.questions.CurrentUrl;
import com.marcelo.screenplay.questions.ErrorMessageIsVisible;
import com.marcelo.screenplay.tasks.Login;
import com.marcelo.screenplay.tasks.NavigateTo;
import com.marcelo.screenplay.ui.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Step definitions for TC-01: Successful Login.
 *
 * Uses OnlineCast (Serenity's canonical Screenplay setup) instead of @Managed,
 * because @Managed WebDriver injection only works in classes that extend ScenarioSteps.
 * OnlineCast wires the Actor to the WebDriver managed internally by Serenity
 * (configured via serenity.properties).
 */
public class LoginStepDefinitions {

    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDownStage() {
        OnStage.drawTheCurtain();
    }

    // -------------------------------------------------------------------------
    // Given
    // -------------------------------------------------------------------------

    /**
     * Opens Chrome and navigates to the SauceDemo base URL.
     * Implicitly validates that the login page loads.
     */
    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        OnStage.theActorCalled("User").attemptsTo(
            NavigateTo.thePage(LoginPage.URL)
        );
    }

    // -------------------------------------------------------------------------
    // When
    // -------------------------------------------------------------------------

    /**
     * Types the username and password into the login form and clicks the Login button.
     */
    @When("they log in with username {string} and password {string}")
    public void theyLogInWithCredentials(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Login.withCredentials(username, password)
        );
    }

    // -------------------------------------------------------------------------
    // Then
    // -------------------------------------------------------------------------

    /**
     * Validates that the current browser URL contains the expected fragment (/inventory.html),
     * confirming a successful post-login redirect.
     */
    @Then("they are redirected to {string}")
    public void theyAreRedirectedTo(String expectedUrlFragment) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the current URL contains '" + expectedUrlFragment + "'",
                CurrentUrl.value(),
                containsString(expectedUrlFragment))
        );
    }

    /**
     * Validates that the .inventory_list container is present in the DOM,
     * confirming the product catalog page loaded correctly.
     */
    @Then("the product list is visible")
    public void theProductListIsVisible() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the product list is present",
                actor -> !BrowseTheWeb.as(actor).getDriver()
                    .findElements(By.cssSelector(".inventory_list"))
                    .isEmpty(),
                is(true))
        );
    }

    /**
     * Validates that the [data-test='error'] element does NOT exist in the DOM,
     * confirming no error messages were shown after login.
     */
    @Then("no error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("no error messages are displayed",
                ErrorMessageIsVisible.onScreen(),
                is(false))
        );
    }
}
