package co.edu.udea.qa.finanzaspersonales.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ConsultarHistorial implements Task {

    public static ConsultarHistorial desdeElMenu() {
        return Tasks.instrumented(ConsultarHistorial.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://finance-app-ui.vercel.app/dashboard")
        );

        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // Scroll hasta el historial
        JavascriptExecutor js = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
        try {
            org.openqa.selenium.WebElement historial = ThucydidesWebDriverSupport.getDriver()
                    .findElement(By.cssSelector("div.tx-item"));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", historial);
        } catch (Exception ignored) {}
    }
}