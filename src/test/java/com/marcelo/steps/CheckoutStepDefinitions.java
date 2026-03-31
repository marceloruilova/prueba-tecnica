package com.marcelo.steps;

import com.marcelo.screenplay.questions.CheckoutConfirmationIsVisible;
import com.marcelo.screenplay.questions.CheckoutErrorMessage;
import com.marcelo.screenplay.tasks.CompleteCheckout;
import com.marcelo.screenplay.tasks.FillCheckoutForm;
import com.marcelo.screenplay.tasks.StartCheckout;
import com.marcelo.screenplay.ui.CheckoutPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    /**
     * TC-11/12: Clicks Finish to submit the order.
     */
    @When("they complete the order")
    public void theyCompleteTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            CompleteCheckout.now()
        );
    }

    /**
     * TC-11/12: Validates the confirmation page header is present.
     */
    @Then("the order confirmation is displayed")
    public void theOrderConfirmationIsDisplayed() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the order confirmation header is present",
                CheckoutConfirmationIsVisible.onPage(),
                is(true))
        );
    }

    /**
     * TC-11: Validates the confirmation header text contains the expected message.
     */
    @Then("the confirmation message says {string}")
    public void theConfirmationMessageSays(String expectedText) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the confirmation message says '" + expectedText + "'",
                actor -> {
                    List<WebElement> headers = BrowseTheWeb.as(actor).getDriver()
                        .findElements(By.cssSelector(".complete-header"));
                    return headers.isEmpty() ? "" : headers.get(0).getText();
                },
                containsString(expectedText))
        );
    }

    /**
     * TC-12: Attempts to click Finish a second time.
     * CompleteCheckout uses a findElements guard — no-op if button is absent.
     */
    @When("they click Finish again")
    public void theyClickFinishAgain() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            CompleteCheckout.now()
        );
    }
}
