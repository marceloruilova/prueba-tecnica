package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

/**
 * Pregunta Screenplay: comprueba si hay algún mensaje de error visible en pantalla.
 * Usa findElements (en lugar de findElement) para evitar NoSuchElementException
 * cuando el elemento no existe; devuelve false en ese caso.
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
