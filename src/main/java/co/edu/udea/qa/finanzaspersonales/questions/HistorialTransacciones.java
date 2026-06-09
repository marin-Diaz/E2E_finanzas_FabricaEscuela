package co.edu.udea.qa.finanzaspersonales.questions;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.TransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HistorialTransacciones implements Question<java.lang.String> {

    @FindBy(css = "div.transaction-list, div[class*='historial'], div[class*='transaction']")
    private WebElementFacade listaTransacciones;

    public static HistorialTransacciones estaVisible() {
        return new HistorialTransacciones();
    }

    @Override
    public java.lang.String answeredBy(Actor actor) {
        return TransaccionUI.LISTA_TRANSACCIONES.resolveFor(actor).getText();
    }
}