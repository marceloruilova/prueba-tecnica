package com.marcelo.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Tarea Screenplay: navega a una URL usando el WebDriver gestionado por Serenity.
 * Equivalente al WebSteps.navigateTo() del proyecto, adaptado al patrón Screenplay.
 */
public class NavigateTo implements Task {

    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    public static NavigateTo thePage(String url) {
        return instrumented(NavigateTo.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().get(url);
    }
}
