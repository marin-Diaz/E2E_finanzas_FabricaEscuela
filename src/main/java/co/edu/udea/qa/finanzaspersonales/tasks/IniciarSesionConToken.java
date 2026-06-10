package co.edu.udea.qa.finanzaspersonales.tasks;

import co.edu.udea.qa.finanzaspersonales.interactions.autenticacion.IngresarEmail;
import co.edu.udea.qa.finanzaspersonales.interactions.autenticacion.IngresarPassword;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class IniciarSesionConToken implements Task {

    private final java.lang.String token;

    public IniciarSesionConToken(java.lang.String token) {
        this.token = token;
    }

    public static IniciarSesionConToken conToken(java.lang.String token) {
        return Tasks.instrumented(IniciarSesionConToken.class, token);
    }

    private java.lang.String getBaseUrl() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return env.getProperty("webdriver.base.url", "https://finance-app-ui.vercel.app");
    }

    private java.lang.String getUserEmail() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return env.getProperty("serenity.user.email", "andrea.marin1713@gmail.com");
    }

    private java.lang.String getUserPassword() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return env.getProperty("serenity.user.password", "Mipass123!");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor)
                ThucydidesWebDriverSupport.getDriver();

        java.lang.String urlActual = ThucydidesWebDriverSupport.getDriver().getCurrentUrl();
        if (urlActual != null && urlActual.contains("dashboard")) {
            actor.attemptsTo(
                    Open.url(getBaseUrl() + "/dashboard")
            );
            return;
        }

        Target BOTON_LOGIN = Target.the("boton login")
                .located(By.cssSelector("button[type='submit']"));

        actor.attemptsTo(
                Open.url(getBaseUrl())
        );

        actor.attemptsTo(
                IngresarEmail.conValor(getUserEmail()),
                IngresarPassword.conValor(getUserPassword()),
                Click.on(BOTON_LOGIN)
        );
    }
}