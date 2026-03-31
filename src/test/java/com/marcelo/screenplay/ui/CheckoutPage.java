package com.marcelo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * UI targets for the SauceDemo checkout flow.
 */
public class CheckoutPage {

    public static final Target FIRST_NAME =
            Target.the("first name field").locatedBy("[data-test='firstName']");

    public static final Target LAST_NAME =
            Target.the("last name field").locatedBy("[data-test='lastName']");

    public static final Target POSTAL_CODE =
            Target.the("postal code field").locatedBy("[data-test='postalCode']");

    public static final Target CONTINUE_BUTTON =
            Target.the("continue button").locatedBy("[data-test='continue']");

    public static final Target FINISH_BUTTON =
            Target.the("finish button").locatedBy("[data-test='finish']");

    public static final Target CONFIRMATION_HEADER =
            Target.the("order confirmation header").locatedBy(".complete-header");

    public static final Target ERROR_MESSAGE =
            Target.the("checkout error message").locatedBy("[data-test='error']");
}
