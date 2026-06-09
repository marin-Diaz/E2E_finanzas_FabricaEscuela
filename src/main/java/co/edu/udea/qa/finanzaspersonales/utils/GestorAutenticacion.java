package co.edu.udea.qa.finanzaspersonales.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class GestorAutenticacion {

    private static final java.lang.String BASE_URL =
            "https://finance-app-api-latest.onrender.com";

    public static java.lang.String obtenerToken() {
        return RestAssured
                .given()
                .config(RestAssuredConfig.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 60000)
                                .setParam("http.socket.timeout", 60000)))
                .contentType(ContentType.JSON)
                .body("{\"correo\":\"andrea.marin1713@gmail.com\"," +
                        "\"contrasena\":\"Mipass123!\"}")
                .when()
                .post(BASE_URL + "/api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("data.accessToken");
    }
}