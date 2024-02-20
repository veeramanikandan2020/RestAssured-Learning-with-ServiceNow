package reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostCreate {

    @Test
    public void CreatePost(){

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification input = RestAssured.given().when().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");

        Response resp = input.post();

        resp.prettyPrint();

        System.out.println("Response Code : "+resp.getStatusCode());







    }


}
