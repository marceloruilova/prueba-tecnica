package com.marcelo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Screenplay Question: returns the numeric value shown on the cart badge.
 * Returns 0 if the badge element is absent (no items in cart).
 */
public class CartBadgeCount implements Question<Integer> {

    private static final By BADGE_LOCATOR = By.cssSelector(".shopping_cart_badge");

    @Override
    public Integer answeredBy(Actor actor) {
        List<WebElement> badges = BrowseTheWeb.as(actor).getDriver().findElements(BADGE_LOCATOR);
        if (badges.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badges.get(0).getText().trim());
    }

    public static CartBadgeCount displayed() {
        return new CartBadgeCount();
    }
}
