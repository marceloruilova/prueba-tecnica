package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Screenplay Question: checks whether the order confirmation header is visible.
 * Returns false safely if the element is absent.
 */
public class CheckoutConfirmationIsVisible implements Question<Boolean> {

    private static final By CONFIRMATION_LOCATOR = By.cssSelector(".complete-header");

    @Override
    public Boolean answeredBy(Actor actor) {
        return !BrowseTheWeb.as(actor).getDriver().findElements(CONFIRMATION_LOCATOR).isEmpty();
    }

    public static CheckoutConfirmationIsVisible onPage() {
        return new CheckoutConfirmationIsVisible();
    }
}
