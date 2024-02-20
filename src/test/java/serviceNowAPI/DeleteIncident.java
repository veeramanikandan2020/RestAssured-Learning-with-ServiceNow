package serviceNowAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteIncident {

    @Test
    public void deletingIncident(){
        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

        Response delete = RestAssured.delete("incident/5c159ecf9710c2103838bcb3f153af4c");

        int sCode = delete.getStatusCode();

        System.out.println("Status Code for Delete :"+sCode);

    }
}
