package com.marcelo.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;

/**
 * Shared lifecycle hooks for all Cucumber scenarios.
 * Centralised here so that adding new step-definition classes does not
 * accidentally create duplicate @Before / @After hooks.
 */
public class Hooks {

    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDownStage() {
        OnStage.drawTheCurtain();
    }
}
