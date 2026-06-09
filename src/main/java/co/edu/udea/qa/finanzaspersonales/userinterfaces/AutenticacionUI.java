package co.edu.udea.qa.finanzaspersonales.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AutenticacionUI {

    public static final Target INPUT_EMAIL = Target.the("input email")
            .located(By.cssSelector("input[type='email']"));

    public static final Target INPUT_PASSWORD = Target.the("input password")
            .located(By.xpath("(//input[@type='password'])[1]"));

    public static final Target INPUT_CONFIRMAR_PASSWORD = Target.the("input confirmar password")
            .located(By.xpath("(//input[@type='password'])[2]"));

    public static final Target BOTON_SUBMIT = Target.the("boton submit")
            .located(By.cssSelector("button[type='submit']"));

    public static final Target MENSAJE_ERROR = Target.the("mensaje error autenticacion")
            .located(By.cssSelector("div.alert.alert--error, div.alert.alert--success"));
}
