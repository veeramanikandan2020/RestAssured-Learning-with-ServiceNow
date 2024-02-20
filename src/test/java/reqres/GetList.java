package reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetList {

    @Test
    public void getlist() {

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification input = RestAssured.given().when();
        Response resp = input.get("api/users?page=2");
        String responsePrint = resp.prettyPrint();
        System.out.println("Response :"+responsePrint);
        System.out.println("Response Code is :"+resp.statusCode());
        
    }

}
