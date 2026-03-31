package com.marcelo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores de la página de inventario (post-login).
 */
public class InventoryPage {

    public static final Target PRODUCT_LIST =
            Target.the("listado de productos").locatedBy(".inventory_list");

    public static final Target PRODUCT_ITEMS =
            Target.the("items de productos").locatedBy(".inventory_item");
}
