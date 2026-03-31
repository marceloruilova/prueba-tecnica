package com.marcelo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * UI targets for the SauceDemo login page.
 * Uses data-test attribute selectors — more stable than CSS class names.
 */
public class LoginPage {

    public static final String URL = "https://www.saucedemo.com";

    public static final Target USERNAME_FIELD =
            Target.the("username field").locatedBy("[data-test='username']");

    public static final Target PASSWORD_FIELD =
            Target.the("password field").locatedBy("[data-test='password']");

    public static final Target LOGIN_BUTTON =
            Target.the("login button").locatedBy("[data-test='login-button']");

    public static final Target ERROR_MESSAGE =
            Target.the("error message").locatedBy("[data-test='error']");
}
