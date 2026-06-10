package co.edu.udea.qa.finanzaspersonales.interactions;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.TransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarMonto implements Interaction {

    private final java.lang.String monto;

    public IngresarMonto(java.lang.String monto) {
        this.monto = monto;
    }

    public static IngresarMonto conValor(java.lang.String monto) {
        return Tasks.instrumented(IngresarMonto.class, monto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(monto).into(TransaccionUI.INPUT_MONTO)
        );
    }
}