package com.marcelo.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class WebSteps extends ScenarioSteps {

    @Step("Navigate to {0}")
    public void navigateTo(String url) {
        getDriver().get(url);
    }
}
