package serviceNowAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class CreateIncidentwithJsonFile {

    @Test
    public void createWithJsonFile(){

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

        File file = new File("C:/Users/Veeramanikandan M/IdeaProjects/APIRestAssured/src/data/FileJSONData.json");

        RequestSpecification input = RestAssured.given().contentType("application/json").when().body(file);

         Response resp = input.post("incident");

         resp.prettyPrint();

        System.out.println("Status Code Post :"+resp.getStatusCode());

        String desc = resp.jsonPath().get("result.description");

        String shortDesc = resp.jsonPath().get("result.short_description");

        System.out.println("Description :"+desc +"and short Description : "+shortDesc);

    }
}
