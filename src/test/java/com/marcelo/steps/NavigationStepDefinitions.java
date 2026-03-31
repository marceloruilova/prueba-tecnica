package com.marcelo.steps;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class NavigationStepDefinitions {

    @Steps
    WebSteps webSteps;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        webSteps.navigateTo(url);
    }
}
