package co.edu.udea.qa.finanzaspersonales.stepdefinitions;

import co.edu.udea.qa.finanzaspersonales.tasks.IniciarSesionConToken;
import co.edu.udea.qa.finanzaspersonales.tasks.RegistrarTransaccion;
import co.edu.udea.qa.finanzaspersonales.tasks.ConsultarHistorial;
import co.edu.udea.qa.finanzaspersonales.questions.MensajeAlerta;
import co.edu.udea.qa.finanzaspersonales.questions.HistorialTransacciones;
import co.edu.udea.qa.finanzaspersonales.utils.GestorAutenticacion;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;


public class RegistrarTransaccionSteps {

    private Actor usuario;

    @Before
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
        usuario = OnStage.theActorCalled("Andrea");
        usuario.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
        usuario.attemptsTo(IniciarSesionConToken.conToken(
                GestorAutenticacion.obtenerToken()
        ));
    }

    @Given("I am an authenticated user")
    public void usuarioAutenticado() {
        // autenticacion manejada en @Before
    }

    @Given("I am an authenticated user with registered transactions")
    public void usuarioAutenticadoConTransacciones() {
        // autenticacion manejada en @Before
    }

    @Given("I am an authenticated user with no registered transactions")
    public void usuarioAutenticadoSinTransacciones() {
        // autenticacion manejada en @Before
    }

    @When("I register an income with valid data: category {string}, concept {string}, amount {string} and date {string}")
    public void registrarIngreso(java.lang.String categoria, java.lang.String concepto, java.lang.String monto, java.lang.String fecha) {
        usuario.attemptsTo(
                RegistrarTransaccion.conDatos(categoria, concepto, monto, fecha)
        );
    }

    @When("I register an expense with valid data: category {string}, concept {string}, amount {string} and date {string}")
    public void registrarGasto(java.lang.String categoria, java.lang.String concepto, java.lang.String monto, java.lang.String fecha) {
        usuario.attemptsTo(
                RegistrarTransaccion.conDatos(categoria, concepto, monto, fecha)
        );
    }

    @When("I try to register an income with category {string} and empty amount")
    public void registrarIngresoMontoVacio(java.lang.String categoria) {
        usuario.attemptsTo(
                RegistrarTransaccion.sinMonto(categoria)
        );
    }

    @When("I try to register an expense with category {string} and empty amount")
    public void registrarGastoMontoVacio(java.lang.String categoria) {
        usuario.attemptsTo(
                RegistrarTransaccion.sinMonto(categoria)
        );
    }

    @When("I try to register an income without selecting a category with amount {string}")
    public void registrarIngresoSinCategoria(java.lang.String monto) {
        usuario.attemptsTo(
                RegistrarTransaccion.sinCategoria(monto)
        );
    }

    @When("I try to register an expense without selecting a category with amount {string}")
    public void registrarGastoSinCategoria(java.lang.String monto) {
        usuario.attemptsTo(
                RegistrarTransaccion.sinCategoria(monto)
        );
    }

    @When("I query my transaction history")
    public void consultarHistorial() {
        usuario.attemptsTo(
                ConsultarHistorial.desdeElMenu()
        );
    }

    @Then("the system displays the message {string}")
    public void verificarMensaje(java.lang.String mensajeEsperado) {
        usuario.should(
                seeThat(MensajeAlerta.texto(), containsString(mensajeEsperado))
        );
    }

    @Then("the system displays my transactions")
    public void verificarHistorial() {
        usuario.should(
                seeThat(HistorialTransacciones.estaVisible(), not(containsString("Sin movimientos")))
        );
    }
}