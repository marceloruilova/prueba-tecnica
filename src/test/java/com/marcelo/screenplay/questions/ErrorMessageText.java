package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Screenplay Question: returns the text content of the [data-test='error'] element.
 * Returns an empty string if the element is absent (safe, no NoSuchElementException).
 * Used to assert specific error message wording (TC-03, TC-20, etc.).
 */
public class ErrorMessageText implements Question<String> {

    private static final By ERROR_LOCATOR = By.cssSelector("[data-test='error']");

    @Override
    public String answeredBy(Actor actor) {
        List<WebElement> elements = BrowseTheWeb.as(actor).getDriver().findElements(ERROR_LOCATOR);
        return elements.isEmpty() ? "" : elements.get(0).getText();
    }

    public static ErrorMessageText fromLoginPage() {
        return new ErrorMessageText();
    }
}
