package za.co.momagano.model;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;

public class DB {
    EnvironmentVariables environmentVariables;

    public static Response queryByCompanyRegistration(String webserviceEndpoint, String companyRegistration) {
        // ...
        return SerenityRest.given()
                .contentType("application/json")
                .queryParam("companyRegistration",companyRegistration)
                .get(webserviceEndpoint);
    }
}
