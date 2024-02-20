package bookStore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookStoreInfo {

    @Test
    public void getBookStoreBooks(){

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        RequestSpecification input = RestAssured.given().when();

        Response resp = input.get();

        resp.prettyPrint();

        System.out.println("Response code for Status:"+resp.statusCode());

        System.out.println("Status Code :"+resp.getStatusCode());

        Assert.assertEquals(200,200);

        String statusLine = resp.getStatusLine();

        String body = String.valueOf(resp.body());

        System.out.println("Status Code :"+statusLine);

        System.out.println("Body :"+body);

        System.out.println();

    }
}
