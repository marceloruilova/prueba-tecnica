package com.marcelo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * UI targets for the SauceDemo cart page.
 */
public class CartPage {

    public static final Target CART_BADGE =
            Target.the("cart badge").locatedBy(".shopping_cart_badge");

    public static final Target CART_LINK =
            Target.the("cart link").locatedBy(".shopping_cart_link");

    public static final Target CART_ITEMS =
            Target.the("cart items").locatedBy(".cart_item");

    public static final Target CHECKOUT_BUTTON =
            Target.the("checkout button").locatedBy("[data-test='checkout']");
}
