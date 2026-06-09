package co.edu.udea.qa.finanzaspersonales.tasks;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.AutenticacionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {

    private final String correo;
    private final String contrasena;

    public IniciarSesion(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public static IniciarSesion conCredenciales(String correo, String contrasena) {
        return Tasks.instrumented(IniciarSesion.class, correo, contrasena);
    }

    public static IniciarSesion conCamposVacios() {
        return Tasks.instrumented(IniciarSesion.class, "", "");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!correo.isEmpty()) {
            actor.attemptsTo(Enter.theValue(correo).into(AutenticacionUI.INPUT_EMAIL));
        }
        if (!contrasena.isEmpty()) {
            actor.attemptsTo(Enter.theValue(contrasena).into(AutenticacionUI.INPUT_PASSWORD));
        }
        actor.attemptsTo(Click.on(AutenticacionUI.BOTON_SUBMIT));
    }
}
