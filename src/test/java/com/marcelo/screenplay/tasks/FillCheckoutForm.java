package com.marcelo.screenplay.tasks;

import com.marcelo.screenplay.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: fills in the checkout information form and clicks Continue.
 * Passing an empty string for any field leaves that field blank — tests required-field validation.
 */
public class FillCheckoutForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutForm(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static FillCheckoutForm with(String firstName, String lastName, String postalCode) {
        return instrumented(FillCheckoutForm.class, firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
            Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
            Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE),
            Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}
