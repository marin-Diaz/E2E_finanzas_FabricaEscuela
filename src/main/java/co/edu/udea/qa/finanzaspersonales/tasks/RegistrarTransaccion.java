package co.edu.udea.qa.finanzaspersonales.tasks;

import co.edu.udea.qa.finanzaspersonales.userinterfaces.TransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegistrarTransaccion implements Task {

    private final java.lang.String categoria;
    private final java.lang.String concepto;
    private final java.lang.String monto;
    private final java.lang.String fecha;

    public RegistrarTransaccion(java.lang.String categoria, java.lang.String concepto,
                                java.lang.String monto, java.lang.String fecha) {
        this.categoria = categoria;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
    }

    public static RegistrarTransaccion conDatos(java.lang.String categoria,
                                                java.lang.String concepto,
                                                java.lang.String monto,
                                                java.lang.String fecha) {
        return Tasks.instrumented(RegistrarTransaccion.class, categoria, concepto, monto, fecha);
    }

    public static RegistrarTransaccion sinMonto(java.lang.String categoria) {
        return Tasks.instrumented(RegistrarTransaccion.class, categoria, "Test concepto", "", "");
    }

    public static RegistrarTransaccion sinCategoria(java.lang.String monto) {
        return Tasks.instrumented(RegistrarTransaccion.class, "", "", monto, "");
    }

    private java.lang.String obtenerValorCategoria(java.lang.String nombreCategoria) {
        switch (nombreCategoria.toLowerCase()) {
            case "salario": return "36";
            case "freelance": return "37";
            case "otros ingresos": return "38";
            case "comida": return "39";
            case "transporte": return "40";
            case "servicios": return "41";
            case "entretenimiento": return "42";
            default: return nombreCategoria;
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!categoria.isEmpty()) {
            actor.attemptsTo(
                    SelectFromOptions.byValue(obtenerValorCategoria(categoria))
                            .from(TransaccionUI.SELECT_CATEGORIA)
            );
        }


        if (!concepto.isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(concepto).into(TransaccionUI.INPUT_CONCEPTO)
            );
        }
        if (!monto.isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(monto).into(TransaccionUI.INPUT_MONTO)
            );
        }
        if (!fecha.isEmpty()) {
            WebElement inputFecha = ThucydidesWebDriverSupport.getDriver()
                    .findElement(By.cssSelector("input[type='datetime-local']"));
            JavascriptExecutor js2 = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();
            js2.executeScript("arguments[0].value = arguments[1]", inputFecha, fecha);
            js2.executeScript(
                    "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
                            "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
                    inputFecha
            );
        }

        // Esperar a que desaparezca cualquier alerta anterior
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