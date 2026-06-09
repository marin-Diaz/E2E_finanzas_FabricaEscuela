package co.edu.udea.qa.finanzaspersonales.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class UrlActual implements Question<String> {

    public static UrlActual delNavegador() {
        return new UrlActual();
    }

    @Override
    public String answeredBy(Actor actor) {
        return ThucydidesWebDriverSupport.getDriver().getCurrentUrl();
    }
}
