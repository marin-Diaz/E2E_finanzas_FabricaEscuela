package co.edu.udea.qa.finanzaspersonales.questions;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.TransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration;

public class MensajeAlerta implements Question<java.lang.String> {

    public static MensajeAlerta texto() {
        return new MensajeAlerta();
    }

    @Override
    public java.lang.String answeredBy(Actor actor) {
        return TransaccionUI.MENSAJE_ALERTA.resolveFor(actor).getText();
    }
}