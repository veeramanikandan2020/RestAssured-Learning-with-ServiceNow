package serviceNowAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateIncident extends CreateIncident {


    @Test
    public void updatingIncidents(){

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

        RequestSpecification update = RestAssured.given().
                contentType("application/json")
                .when().body("{\n" +
                "    \"description\": \"Auto repair\",\n" +
                "    \"short_description\": \"Balaji Auto engine\"\n" +
                "}");

        Response put = update.put("incident/5c159ecf9710c2103838bcb3f153af4c");

        System.out.println("5c159ecf9710c2103838bcb3f153af4c: same as this :"+sysId);

        System.out.println(put.getStatusCode());

        put.prettyPrint();

    }
}
