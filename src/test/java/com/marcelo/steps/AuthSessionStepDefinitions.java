package com.marcelo.steps;

import com.marcelo.screenplay.questions.CurrentUrl;
import com.marcelo.screenplay.tasks.NavigateTo;
import com.marcelo.screenplay.ui.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

/**
 * Step definitions for authentication and session management scenarios
 * (TC-06, TC-16, TC-17).
 */
public class AuthSessionStepDefinitions {

    /**
     * TC-06/17: Ensures a clean unauthenticated state by navigating to the login page.
     */
    @Given("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        OnStage.theActorCalled("User").attemptsTo(
            NavigateTo.thePage(LoginPage.URL)
        );
    }

    /**
     * TC-06/17: Navigates directly to a protected path without logging in.
     * Concatenates the base URL with the given path segment.
     */
    @When("they navigate directly to {string}")
    public void theyNavigateDirectlyTo(String path) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            NavigateTo.thePage(LoginPage.URL + path)
        );
    }

    /**
     * TC-06/16/17: Verifies the browser URL does not contain "inventory",
     * confirming SauceDemo redirected the user back to the login page.
     */
    @Then("they are redirected to the login page")
    public void theyAreRedirectedToTheLoginPage() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the URL points to the login page",
                CurrentUrl.value(),
                not(containsString("inventory")))
        );
        OnStage.theActorInTheSpotlight().should(
            seeThat("the URL is on saucedemo.com",
                CurrentUrl.value(),
                containsString("saucedemo.com"))
        );
    }
}
