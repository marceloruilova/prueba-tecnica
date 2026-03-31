package com.marcelo.screenplay.tasks;

import com.marcelo.screenplay.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: clicks the first available "Add to cart" button on the inventory page.
 */
public class AddProductToCart implements Task {

    public static AddProductToCart firstAvailable() {
        return instrumented(AddProductToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(InventoryPage.ADD_TO_CART_BUTTONS)
        );
    }
}
