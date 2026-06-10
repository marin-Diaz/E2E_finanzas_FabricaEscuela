package co.edu.udea.qa.finanzaspersonales.tasks;

import co.edu.udea.qa.finanzaspersonales.interactions.autenticacion.IngresarEmail;
import co.edu.udea.qa.finanzaspersonales.interactions.autenticacion.IngresarPassword;
import co.edu.udea.qa.finanzaspersonales.userinterfaces.AutenticacionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

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
            actor.attemptsTo(IngresarEmail.conValor(correo));
        }
        if (!contrasena.isEmpty()) {
            actor.attemptsTo(IngresarPassword.conValor(contrasena));
        }
        actor.attemptsTo(Click.on(AutenticacionUI.BOTON_SUBMIT));
    }
}