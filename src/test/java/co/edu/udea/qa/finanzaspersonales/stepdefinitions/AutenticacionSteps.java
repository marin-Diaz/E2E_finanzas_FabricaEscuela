package co.edu.udea.qa.finanzaspersonales.stepdefinitions;

import co.edu.udea.qa.finanzaspersonales.questions.UrlActual;
import co.edu.udea.qa.finanzaspersonales.tasks.IniciarSesion;
import co.edu.udea.qa.finanzaspersonales.tasks.RegistrarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class AutenticacionSteps {

    private Actor usuario;

    @Before("@autenticacion")
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("Usuario");
        usuario.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
    }

    @Given("I am on the login page")
    public void navegarALogin() {
        usuario.attemptsTo(Open.url("https://finance-app-ui.vercel.app/login"));
    }

    @Given("I am on the registration page")
    public void navegarARegistro() {
        usuario.attemptsTo(Open.url("https://finance-app-ui.vercel.app/registro"));
    }

    @When("I log in with email {string} and password {string}")
    public void iniciarSesion(String correo, String contrasena) {
        usuario.attemptsTo(IniciarSesion.conCredenciales(correo, contrasena));
    }

    @When("I try to log in with empty fields")
    public void iniciarSesionCamposVacios() {
        usuario.attemptsTo(IniciarSesion.conCamposVacios());
    }

    @When("I register with email {string}, password {string} and confirm password {string}")
    public void registrarUsuario(String correo, String contrasena, String confirmarContrasena) {
        usuario.attemptsTo(RegistrarUsuario.conDatos(correo, contrasena, confirmarContrasena));
    }

    @When("I try to register with empty fields")
    public void registrarUsuarioCamposVacios() {
        usuario.attemptsTo(RegistrarUsuario.conCamposVacios());
    }

    @Then("I am redirected to the dashboard")
    public void verificarRedirectDashboard() {
        new WebDriverWait(ThucydidesWebDriverSupport.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/dashboard"));
        usuario.should(seeThat(UrlActual.delNavegador(), containsString("/dashboard")));
    }

    @Then("I am redirected to the verification page")
    public void verificarRedirectVerificacion() {
        new WebDriverWait(ThucydidesWebDriverSupport.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/verificar"));
        usuario.should(seeThat(UrlActual.delNavegador(), containsString("/verificar")));
    }
}
