package com.marcelo.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: reloads the current page.
 */
public class RefreshPage implements Task {

    public static RefreshPage now() {
        return instrumented(RefreshPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().refresh();
    }
}
