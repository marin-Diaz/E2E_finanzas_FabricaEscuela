package co.edu.udea.qa.finanzaspersonales.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
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

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor)
                ThucydidesWebDriverSupport.getDriver();

        // Si ya estamos en dashboard, solo scroll al top y esperar
        java.lang.String urlActual = ThucydidesWebDriverSupport.getDriver().getCurrentUrl();
        if (urlActual != null && urlActual.contains("dashboard")) {
            // Navegar al dashboard de nuevo para limpiar el formulario
            actor.attemptsTo(
                    Open.url("https://finance-app-ui.vercel.app/dashboard")
            );
            return;
        }

        // Login por UI
        Target INPUT_EMAIL = Target.the("email")
                .located(By.cssSelector("input[type='email']"));
        Target INPUT_PASSWORD = Target.the("password")
                .located(By.cssSelector("input[type='password']"));
        Target BOTON_LOGIN = Target.the("boton login")
                .located(By.cssSelector("button[type='submit']"));

        actor.attemptsTo(
                Open.url("https://finance-app-ui.vercel.app")
        );

        actor.attemptsTo(
                Enter.theValue("andrea.marin1713@gmail.com").into(INPUT_EMAIL),
                Enter.theValue("Mipass123!").into(INPUT_PASSWORD),
                Click.on(BOTON_LOGIN)
        );
    }
}