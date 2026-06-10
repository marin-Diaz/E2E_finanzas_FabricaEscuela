package co.edu.udea.qa.finanzaspersonales.interactions.autenticacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IngresarEmail implements Interaction {

    private final java.lang.String email;

    public IngresarEmail(java.lang.String email) {
        this.email = email;
    }

    public static IngresarEmail conValor(java.lang.String email) {
        return Tasks.instrumented(IngresarEmail.class, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email)
                        .into(Target.the("email")
                                .located(By.cssSelector("input[type='email']")))
        );
    }
}