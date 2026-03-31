package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Pregunta Screenplay: devuelve la URL actual del navegador.
 * Usada para validar la redirección tras el login.
 */
public class CurrentUrl implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }

    public static CurrentUrl value() {
        return new CurrentUrl();
    }
}
