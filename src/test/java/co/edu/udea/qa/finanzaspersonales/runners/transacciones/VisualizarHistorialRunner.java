package co.edu.udea.qa.finanzaspersonales.runners.transacciones;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/transacciones/visualizar_historial.feature",
        glue = "co.edu.udea.qa.finanzaspersonales.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class VisualizarHistorialRunner {}