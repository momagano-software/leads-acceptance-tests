package za.co.momagano.model;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class DB {
    public static Response queryByCompanyRegistration(String companyRegistration) {
        return SerenityRest.given()
                .contentType("application/json")
                .queryParam("companyRegistration",companyRegistration)
                .get("https://momagano-test.herokuapp.com/profile");
    }
}
