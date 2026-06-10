package co.edu.udea.qa.finanzaspersonales.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ClickRegistrar implements Interaction {

    public static ClickRegistrar enBoton() {
        return Tasks.instrumented(ClickRegistrar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            new org.openqa.selenium.support.ui.WebDriverWait(
                    ThucydidesWebDriverSupport.getDriver(),
                    java.time.Duration.ofSeconds(8)
            ).until(org.openqa.selenium.support.ui.ExpectedConditions
                    .invisibilityOfElementLocated(
                            By.cssSelector("div.alert.alert--error, div.alert.alert--success")
                    )
            );
        } catch (Exception ignored) {}

        JavascriptExecutor js = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
        WebElement boton = ThucydidesWebDriverSupport.getDriver()
                .findElement(By.xpath(
                        "//button[@type='submit' and contains(text(),'Registrar')]"
                ));
        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", boton);
        try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        boton.click();
    }
}