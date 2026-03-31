package com.marcelo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * UI targets for the SauceDemo inventory page (post-login).
 */
public class InventoryPage {

    public static final Target PRODUCT_LIST =
            Target.the("product list").locatedBy(".inventory_list");

    public static final Target PRODUCT_ITEMS =
            Target.the("product items").locatedBy(".inventory_item");
}
