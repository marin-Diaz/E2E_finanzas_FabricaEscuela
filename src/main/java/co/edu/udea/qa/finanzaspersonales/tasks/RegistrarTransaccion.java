package co.edu.udea.qa.finanzaspersonales.tasks;

import co.edu.udea.qa.finanzaspersonales.interactions.transacciones.ClickRegistrar;
import co.edu.udea.qa.finanzaspersonales.interactions.transacciones.IngresarConcepto;
import co.edu.udea.qa.finanzaspersonales.interactions.transacciones.IngresarFecha;
import co.edu.udea.qa.finanzaspersonales.interactions.transacciones.IngresarMonto;
import co.edu.udea.qa.finanzaspersonales.interactions.transacciones.SeleccionarCategoria;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

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
                    SeleccionarCategoria.conValor(obtenerValorCategoria(categoria))
            );
        }
        if (!concepto.isEmpty()) {
            actor.attemptsTo(
                    IngresarConcepto.conValor(concepto)
            );
        }
        if (!monto.isEmpty()) {
            actor.attemptsTo(
                    IngresarMonto.conValor(monto)
            );
        }
        if (!fecha.isEmpty()) {
            actor.attemptsTo(
                    IngresarFecha.conValor(fecha)
            );
        }
        actor.attemptsTo(
                ClickRegistrar.enBoton()
        );
    }
}