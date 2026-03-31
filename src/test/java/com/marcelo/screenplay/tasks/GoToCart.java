package com.marcelo.screenplay.tasks;

import com.marcelo.screenplay.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: navigates directly to the shopping cart page.
 * Uses driver.get() for reliable navigation instead of clicking the cart icon,
 * which can fail to trigger React Router navigation in some Chrome configurations.
 */
public class GoToCart implements Task {

    public static GoToCart now() {
        return instrumented(GoToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            NavigateTo.thePage(CartPage.URL)
        );
    }
}
