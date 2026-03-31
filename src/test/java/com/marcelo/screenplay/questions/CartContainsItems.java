package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

/**
 * Screenplay Question: checks whether the cart page contains at least one item.
 * Must be called while the cart page is open.
 */
public class CartContainsItems implements Question<Boolean> {

    private static final By CART_ITEM_LOCATOR = By.cssSelector(".cart_item");

    @Override
    public Boolean answeredBy(Actor actor) {
        return !BrowseTheWeb.as(actor).getDriver().findElements(CART_ITEM_LOCATOR).isEmpty();
    }

    public static CartContainsItems onPage() {
        return new CartContainsItems();
    }
}
