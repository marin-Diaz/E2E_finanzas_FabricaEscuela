package co.edu.udea.qa.finanzaspersonales.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarHistorial implements Task {

    public ConsultarHistorial() {}

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
            Click.on(""),
            Enter.theValue("").into("")
        );
    }

    public static ConsultarHistorial consultarHistorial() {
        return instrumented(ConsultarHistorial.class);
    }
}