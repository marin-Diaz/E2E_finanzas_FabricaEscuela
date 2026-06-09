package co.edu.udea.qa.finanzaspersonales.runners.transacciones;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/transacciones/registrar_gasto.feature",
        glue = "co.edu.udea.qa.finanzaspersonales.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegistrarGastoRunner {}