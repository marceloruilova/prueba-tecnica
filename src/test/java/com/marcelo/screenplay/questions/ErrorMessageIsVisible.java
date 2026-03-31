package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

/**
 * Screenplay Question: checks whether an error message is visible on the login page.
 * Uses findElements() instead of findElement() to safely return false
 * when the element is absent, avoiding NoSuchElementException.
 */
public class ErrorMessageIsVisible implements Question<Boolean> {

    private static final By ERROR_LOCATOR = By.cssSelector("[data-test='error']");

    @Override
    public Boolean answeredBy(Actor actor) {
        return !BrowseTheWeb.as(actor)
                .getDriver()
                .findElements(ERROR_LOCATOR)
                .isEmpty();
    }

    public static ErrorMessageIsVisible onScreen() {
        return new ErrorMessageIsVisible();
    }
}
