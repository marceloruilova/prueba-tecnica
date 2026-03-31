package com.marcelo.screenplay.tasks;

import com.marcelo.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Screenplay Task: types credentials into the login form and submits it.
 * Does not handle navigation — the actor must already be on the login page.
 */
public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Factory method for fluent usage: Login.withCredentials("user", "pass") */
    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
            Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
            Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
