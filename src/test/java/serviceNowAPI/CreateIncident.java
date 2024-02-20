package serviceNowAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateIncident {

    public static String sysId;
    @Test
    public void create() {

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin", "9Z!Kj%k8NtcP");

        RequestSpecification input = RestAssured.given().
                contentType("application/json")
                .when().body("{\n" +
                        "    \"description\": \"Bus repair\",\n" +
                        "    \"short_description\": \"Tata\"\n" +
                        "}");

        Response response = input.post("incident");

        response.prettyPrint();

        System.out.println("Response Code for Post :" + response.getStatusCode());

        System.out.println("Status Line :" + response.getStatusLine());

        sysId = response.jsonPath().get("result.sys_id");

        System.out.println("System Id :"+sysId);

    }
}
