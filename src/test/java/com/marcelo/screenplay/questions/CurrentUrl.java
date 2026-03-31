package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Screenplay Question: returns the current browser URL.
 * Used to validate the post-login redirect.
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
