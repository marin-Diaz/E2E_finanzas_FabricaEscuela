package co.edu.udea.qa.finanzaspersonales.interactions.autenticacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IngresarPassword implements Interaction {

    private final java.lang.String password;

    public IngresarPassword(java.lang.String password) {
        this.password = password;
    }

    public static IngresarPassword conValor(java.lang.String password) {
        return Tasks.instrumented(IngresarPassword.class, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(password)
                        .into(Target.the("password")
                                .located(By.cssSelector("input[type='password']")))
        );
    }
}