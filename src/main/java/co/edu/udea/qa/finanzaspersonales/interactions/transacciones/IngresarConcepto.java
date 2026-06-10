package co.edu.udea.qa.finanzaspersonales.interactions.transacciones;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.TransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarConcepto implements Interaction {

    private final java.lang.String concepto;

    public IngresarConcepto(java.lang.String concepto) {
        this.concepto = concepto;
    }

    public static IngresarConcepto conValor(java.lang.String concepto) {
        return Tasks.instrumented(IngresarConcepto.class, concepto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(concepto).into(TransaccionUI.INPUT_CONCEPTO)
        );
    }
}
