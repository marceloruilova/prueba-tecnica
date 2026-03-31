package com.marcelo.steps;

import com.marcelo.screenplay.questions.CurrentUrl;
import com.marcelo.screenplay.questions.ErrorMessageIsVisible;
import com.marcelo.screenplay.questions.ErrorMessageText;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Step definitions for login failure scenarios (TC-02, TC-03, TC-04, TC-05, TC-18, TC-20).
 * Reuses the Given/When steps from LoginStepDefinitions via Cucumber's global step registry.
 */
public class LoginFailureStepDefinitions {

    /**
     * TC-02/03/04/05/18: Verifies that the [data-test='error'] element is present in the DOM.
     */
    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("an error message is displayed",
                ErrorMessageIsVisible.onScreen(),
                is(true))
        );
    }

    /**
     * TC-03/20: Verifies that the error message text contains the expected phrase.
     */
    @Then("the error message contains {string}")
    public void theErrorMessageContains(String expectedText) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the error message contains '" + expectedText + "'",
                ErrorMessageText.fromLoginPage(),
                containsString(expectedText))
        );
    }

    /**
     * TC-02/03/04/05/18: Verifies the browser URL does not contain "inventory",
     * confirming the user was not redirected after a failed login.
     */
    @Then("the URL still shows the login page")
    public void theUrlStillShowsTheLoginPage() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the URL does not contain 'inventory'",
                CurrentUrl.value(),
                not(containsString("inventory")))
        );
    }

    /**
     * TC-20: Verifies the error message is human-readable and contains no stack trace fragments.
     */
    @Then("the error message does not contain a stack trace")
    public void theErrorMessageDoesNotContainAStackTrace() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the error message contains no stack trace",
                ErrorMessageText.fromLoginPage(),
                not(containsString("Exception")))
        );
        OnStage.theActorInTheSpotlight().should(
            seeThat("the error message contains no stack trace",
                ErrorMessageText.fromLoginPage(),
                not(containsString("at com.")))
        );
    }
}
