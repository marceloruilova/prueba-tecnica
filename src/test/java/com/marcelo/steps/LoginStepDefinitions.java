package com.marcelo.steps;

import com.marcelo.screenplay.questions.CurrentUrl;
import com.marcelo.screenplay.questions.ErrorMessageIsVisible;
import com.marcelo.screenplay.tasks.Login;
import com.marcelo.screenplay.tasks.NavigateTo;
import com.marcelo.screenplay.ui.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Definiciones de pasos para TC-01: Login exitoso.
 *
 * Usa OnlineCast (patrón Screenplay canónico de Serenity) en lugar de @Managed,
 * ya que @Managed solo se inyecta correctamente en clases que extienden ScenarioSteps.
 * OnlineCast conecta al Actor con el WebDriver gestionado internamente por Serenity.
 */
public class LoginStepDefinitions {

    @Before
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void limpiarEscenario() {
        OnStage.drawTheCurtain();
    }

    // -------------------------------------------------------------------------
    // Given
    // -------------------------------------------------------------------------

    /**
     * Abre el navegador y navega a la URL de SauceDemo.
     * Valida implícitamente que la página de login carga.
     */
    @Given("que el usuario está en la página de login de SauceDemo")
    public void queElUsuarioEstaEnLaPaginaDeLogin() {
        OnStage.theActorCalled("Usuario").attemptsTo(
            NavigateTo.thePage(LoginPage.URL)
        );
    }

    // -------------------------------------------------------------------------
    // When
    // -------------------------------------------------------------------------

    /**
     * Ingresa las credenciales en el formulario y hace clic en Login.
     */
    @When("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciaSesionConCredenciales(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Login.withCredentials(username, password)
        );
    }

    // -------------------------------------------------------------------------
    // Then
    // -------------------------------------------------------------------------

    /**
     * Valida que la URL del navegador contiene el fragmento esperado (/inventory.html),
     * confirmando la redirección post-login exitosa.
     */
    @Then("es redirigido a {string}")
    public void esRedirigidoA(String expectedUrlFragment) {
        OnStage.theActorInTheSpotlight().should(
            seeThat("la URL actual contiene '" + expectedUrlFragment + "'",
                CurrentUrl.value(),
                containsString(expectedUrlFragment))
        );
    }

    /**
     * Valida que el contenedor .inventory_list existe en el DOM,
     * confirmando que la página de inventario con productos cargó correctamente.
     */
    @Then("el listado de productos es visible")
    public void elListadoDeProductosEsVisible() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("el listado de productos está presente",
                actor -> !BrowseTheWeb.as(actor).getDriver()
                    .findElements(By.cssSelector(".inventory_list"))
                    .isEmpty(),
                is(true))
        );
    }

    /**
     * Valida que el elemento [data-test='error'] NO existe en el DOM,
     * confirmando que no se mostraron mensajes de error tras el login.
     */
    @Then("no hay mensajes de error en pantalla")
    public void noHayMensajesDeErrorEnPantalla() {
        OnStage.theActorInTheSpotlight().should(
            seeThat("no hay mensajes de error en pantalla",
                ErrorMessageIsVisible.onScreen(),
                is(false))
        );
    }
}
