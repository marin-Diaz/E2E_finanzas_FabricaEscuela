package co.edu.udea.qa.finanzaspersonales.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IngresarFecha implements Interaction {

    private final java.lang.String fecha;

    public IngresarFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }

    public static IngresarFecha conValor(java.lang.String fecha) {
        return Tasks.instrumented(IngresarFecha.class, fecha);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement inputFecha = ThucydidesWebDriverSupport.getDriver()
                .findElement(By.cssSelector("input[type='datetime-local']"));
        JavascriptExecutor js = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
        js.executeScript("arguments[0].value = arguments[1]", inputFecha, fecha);
        js.executeScript(
                "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
                inputFecha
        );
    }
}
