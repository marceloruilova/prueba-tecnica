package com.marcelo.screenplay.tasks;

import com.marcelo.screenplay.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: clicks the Finish button to complete the checkout.
 * Uses findElements guard — if the Finish button is absent (e.g. already clicked in TC-12),
 * the task is a no-op and does not throw NoSuchElementException.
 */
public class CompleteCheckout implements Task {

    private static final By FINISH_LOCATOR = By.cssSelector("[data-test='finish']");

    public static CompleteCheckout now() {
        return instrumented(CompleteCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!BrowseTheWeb.as(actor).getDriver().findElements(FINISH_LOCATOR).isEmpty()) {
            BrowseTheWeb.as(actor).getDriver().findElement(FINISH_LOCATOR).click();
        }
    }
}
