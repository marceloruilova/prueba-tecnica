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

    public static final Target ADD_TO_CART_BUTTONS =
            Target.the("add to cart buttons").locatedBy("button[data-test^='add-to-cart']");

    public static final Target REMOVE_BUTTONS =
            Target.the("remove buttons").locatedBy("button[data-test^='remove-']");

    public static final Target SORT_DROPDOWN =
            Target.the("sort dropdown").locatedBy("[data-test='product_sort_container']");

    public static final Target ITEM_PRICES =
            Target.the("item prices").locatedBy(".inventory_item_price");
}
