package co.edu.udea.qa.finanzaspersonales.interactions.transacciones;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.TransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SeleccionarCategoria implements Interaction {

    private final java.lang.String valorCategoria;

    public SeleccionarCategoria(java.lang.String valorCategoria) {
        this.valorCategoria = valorCategoria;
    }

    public static SeleccionarCategoria conValor(java.lang.String valor) {
        return Tasks.instrumented(SeleccionarCategoria.class, valor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(valorCategoria)
                        .from(TransaccionUI.SELECT_CATEGORIA)
        );
    }
}
