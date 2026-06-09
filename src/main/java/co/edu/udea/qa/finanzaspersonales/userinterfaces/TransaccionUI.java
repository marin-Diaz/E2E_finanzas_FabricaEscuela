package co.edu.udea.qa.finanzaspersonales.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TransaccionUI {

    public static final Target SELECT_CATEGORIA = Target.the("select categoria")
            .located(By.xpath("(//select[contains(@class,'field-select')])[2]"));

    public static final Target INPUT_CONCEPTO = Target.the("input concepto")
            .located(By.cssSelector("input[placeholder='Ej: Salario abril']"));

    public static final Target INPUT_MONTO = Target.the("input monto")
            .located(By.cssSelector("input[type='number']"));

    public static final Target INPUT_FECHA = Target.the("input fecha")
            .located(By.cssSelector("input[type='datetime-local']"));

    public static final Target BOTON_REGISTRAR = Target.the("boton registrar")
            .located(By.xpath("(//button[contains(@class,'btn--primary') and @type='submit'])[last()]"));

    public static final Target LISTA_TRANSACCIONES = Target.the("historial transacciones")
            .located(By.cssSelector("div.tx-item"));

    public static final Target MENSAJE_ALERTA = Target.the("mensaje alerta")
            .located(By.cssSelector("div.alert.alert--error, div.alert.alert--success"));
}