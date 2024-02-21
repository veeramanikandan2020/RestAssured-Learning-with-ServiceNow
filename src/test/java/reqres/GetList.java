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

        Response resp =
                input.get("api/users?page=2");
        resp.prettyPrint();
        System.out.println("Details of API Request for");
        System.out.println("Base URI : https://reqres.in/");

        System.out.println("Page Request for Page no 2");

        System.out.println("Status Code for get is : 200");

        
    }

}
