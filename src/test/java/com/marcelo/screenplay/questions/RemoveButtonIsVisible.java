package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

/**
 * Screenplay Question: checks whether a "Remove" button is visible on the current page.
 * Returns false safely when no remove button exists in the DOM.
 */
public class RemoveButtonIsVisible implements Question<Boolean> {

    private static final By REMOVE_LOCATOR = By.cssSelector("button[data-test^='remove-']");

    @Override
    public Boolean answeredBy(Actor actor) {
        return !BrowseTheWeb.as(actor).getDriver().findElements(REMOVE_LOCATOR).isEmpty();
    }

    public static RemoveButtonIsVisible onPage() {
        return new RemoveButtonIsVisible();
    }
}
