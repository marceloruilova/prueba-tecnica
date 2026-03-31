package com.marcelo.screenplay.tasks;

import com.marcelo.screenplay.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: clicks the Checkout button from the cart page.
 */
public class StartCheckout implements Task {

    public static StartCheckout fromCart() {
        return instrumented(StartCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }
}
