package co.edu.udea.qa.finanzaspersonales.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class GestorAutenticacion {

    private static java.lang.String getBackendUrl() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return env.getProperty("serenity.backend.url", "https://finance-app-api-latest.onrender.com");
    }

    private static java.lang.String getUserEmail() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return env.getProperty("serenity.user.email", "andrea.marin1713@gmail.com");
    }

    private static java.lang.String getUserPassword() {
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        return env.getProperty("serenity.user.password", "Mipass123!");
    }

    public static java.lang.String obtenerToken() {
        return RestAssured
                .given()
                .config(RestAssuredConfig.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 60000)
                                .setParam("http.socket.timeout", 60000)))
                .contentType(ContentType.JSON)
                .body("{\"correo\":\"" + getUserEmail() + "\"," +
                        "\"contrasena\":\"" + getUserPassword() + "\"}")
                .when()
                .post(getBackendUrl() + "/api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("data.accessToken");
    }
}