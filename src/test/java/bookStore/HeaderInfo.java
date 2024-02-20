package bookStore;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HeaderInfo {

    @Test
    public void headerinfomation(){

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        RequestSpecification input = RestAssured.given().when();

        Response resp = input.get();

        Headers allHeaders = resp.headers();

        System.out.println("-----------------------------------------------------------------");

        System.out.println(allHeaders);

        String contentType  = resp.header("Content-Type");

        System.out.println("-----------------------------------------------------------------");

        System.out.println(contentType);

        Headers headAll = resp.getHeaders();

        System.out.println("-----------------------------------------------------------------");

        System.out.println(headAll);

        String server = resp.getHeader("Server");

        Assert.assertEquals(server,"nginx/1.17.10 (Ubuntu)");

        System.out.println("-----------------------------------------------------------------");

        ResponseBody body = resp.getBody();

        String asStringBody = body.asString();

        System.out.println(asStringBody);

        System.out.println("-----------------------------------------------------------------");

        JsonPath jsonPath = resp.jsonPath();

        List<String> list = jsonPath.get("books");

        List<String> isbnlist = jsonPath.getList("isbn");

        for(int i =0; i<5; i++){

            String isbnBook = jsonPath.getString("books["+i+"].isbn");
            System.out.println(isbnBook);

        }



    }
}
