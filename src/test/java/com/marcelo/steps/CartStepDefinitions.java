package com.marcelo.steps;

import com.marcelo.screenplay.questions.CartBadgeCount;
import com.marcelo.screenplay.questions.RemoveButtonIsVisible;
import com.marcelo.screenplay.tasks.AddProductToCart;
import com.marcelo.screenplay.tasks.GoToCart;
import com.marcelo.screenplay.tasks.Login;
import com.marcelo.screenplay.tasks.NavigateTo;
import com.marcelo.screenplay.ui.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

/**
 * Step definitions for shopping cart scenarios (TC-07, TC-08, TC-14, TC-19).
 * The @Given("the user is logged in as...") step is also reused by
 * CheckoutStepDefinitions and ProductStepDefinitions via Cucumber's global registry.
 */
public class CartStepDefinitions {

    /**
     * Shared Given across Cart, Checkout, and Product scenarios.
     * Navigates to the login page and authenticates with the provided credentials.
     */
    @Given("the user is logged in as {string} with password {string}")
    public void theUserIsLoggedInAs(String username, String password) {
        OnStage.theActorCalled("User").attemptsTo(
            NavigateTo.thePage(LoginPage.URL),
            Login.withCredentials(username, password)
        );
    }

    /**
     * TC-07/08/11/14/19: Clicks the first available "Add to cart" button.
     */
    @When("they add the first product to the cart")
    public void theyAddTheFirstProductToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            AddProductToCart.firstAvailable()
        );
    }

    /**
     * TC-07: Validates the cart badge displays the expected item count.
     */
    @Then("the cart badge shows {int}")
    public void theCartBadgeShows(int expectedCount) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the cart badge shows " + expectedCount,
                CartBadgeCount.displayed(),
                is(expectedCount))
        );
    }

    /**
     * TC-07/19: Validates that a "Remove" button is present, confirming the product was added.
     */
    @Then("the remove button is visible")
    public void theRemoveButtonIsVisible() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("the Remove button is visible",
                RemoveButtonIsVisible.onPage(),
                is(true))
        );
    }

    /**
     * TC-08/19: Navigates to the cart page.
     */
    @When("they navigate to the cart")
    public void theyNavigateToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            GoToCart.now()
        );
    }
}
