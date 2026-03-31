package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Screenplay Question: returns the text of the error message on the checkout page.
 * Returns empty string if no error element is present (safe, no NoSuchElementException).
 */
public class CheckoutErrorMessage implements Question<String> {

    private static final By ERROR_LOCATOR = By.cssSelector("[data-test='error']");

    @Override
    public String answeredBy(Actor actor) {
        List<WebElement> elements = BrowseTheWeb.as(actor).getDriver().findElements(ERROR_LOCATOR);
        return elements.isEmpty() ? "" : elements.get(0).getText();
    }

    public static CheckoutErrorMessage text() {
        return new CheckoutErrorMessage();
    }
}
