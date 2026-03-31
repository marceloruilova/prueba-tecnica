package com.marcelo.steps;

import com.marcelo.screenplay.questions.CheckoutErrorMessage;
import com.marcelo.screenplay.tasks.FillCheckoutForm;
import com.marcelo.screenplay.tasks.StartCheckout;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.isEmptyString;

/**
 * Step definitions for checkout flow scenarios (TC-09, TC-10, TC-11, TC-12).
 * Reuses cart and login steps from CartStepDefinitions via Cucumber's global registry.
 */
public class CheckoutStepDefinitions {

    /**
     * TC-09/10/11/12: Clicks the Checkout button from the cart page.
     */
    @When("they proceed to checkout")
    public void theyProceedToCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            StartCheckout.fromCart()
        );
    }

    /**
     * TC-09/10: Fills the checkout form fields and clicks Continue.
     * Empty string leaves the field blank, triggering required-field validation.
     */
    @When("they fill in the checkout form with first name {string}, last name {string}, and postal code {string}")
    public void theyFillInTheCheckoutForm(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            FillCheckoutForm.with(firstName, lastName, postalCode)
        );
    }

    /**
     * TC-09/10: Validates that a checkout error message is present.
     */
    @Then("a checkout error is displayed")
    public void aCheckoutErrorIsDisplayed() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("a checkout error message is present",
                CheckoutErrorMessage.text(),
                not(isEmptyString()))
        );
    }

    /**
     * TC-09/10: Validates the checkout error message contains the expected text.
     */
    @Then("the checkout error contains {string}")
    public void theCheckoutErrorContains(String expectedText) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the checkout error contains '" + expectedText + "'",
                CheckoutErrorMessage.text(),
                containsString(expectedText))
        );
    }
}
