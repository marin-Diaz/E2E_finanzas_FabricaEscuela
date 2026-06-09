package co.edu.udea.qa.finanzaspersonales.tasks;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.AutenticacionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RegistrarUsuario implements Task {

    private final String correo;
    private final String contrasena;
    private final String confirmarContrasena;

    public RegistrarUsuario(String correo, String contrasena, String confirmarContrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.confirmarContrasena = confirmarContrasena;
    }

    public static RegistrarUsuario conDatos(String correo, String contrasena, String confirmarContrasena) {
        return Tasks.instrumented(RegistrarUsuario.class, correo, contrasena, confirmarContrasena);
    }

    public static RegistrarUsuario conCamposVacios() {
        return Tasks.instrumented(RegistrarUsuario.class, "", "", "");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!correo.isEmpty()) {
            actor.attemptsTo(Enter.theValue(correo).into(AutenticacionUI.INPUT_EMAIL));
        }
        if (!contrasena.isEmpty()) {
            actor.attemptsTo(Enter.theValue(contrasena).into(AutenticacionUI.INPUT_PASSWORD));
        }
        if (!confirmarContrasena.isEmpty()) {
            actor.attemptsTo(Enter.theValue(confirmarContrasena).into(AutenticacionUI.INPUT_CONFIRMAR_PASSWORD));
        }
        actor.attemptsTo(Click.on(AutenticacionUI.BOTON_SUBMIT));
    }
}
