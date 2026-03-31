package com.marcelo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de la página de login de SauceDemo.
 * Usa selectores por atributo data-test (más estables que clases CSS).
 */
public class LoginPage {

    public static final String URL = "https://www.saucedemo.com";

    public static final Target USERNAME_FIELD =
            Target.the("campo de usuario").locatedBy("[data-test='username']");

    public static final Target PASSWORD_FIELD =
            Target.the("campo de contraseña").locatedBy("[data-test='password']");

    public static final Target LOGIN_BUTTON =
            Target.the("botón de login").locatedBy("[data-test='login-button']");

    public static final Target ERROR_MESSAGE =
            Target.the("mensaje de error").locatedBy("[data-test='error']");
}
