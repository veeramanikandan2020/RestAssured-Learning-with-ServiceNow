package chainingServiceNow;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class CreateIncident extends BaseClass{

    @Test
    public void createincidentServiceNow(){

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

        number = response.jsonPath().get("result.number");

        ValidatableResponse validatableResponse = response.then().assertThat().statusCode(Matchers.equalTo(201));

        //System.out.println(validatableResponse.toString());

        ValidatableResponse inc = response.then().assertThat().body("result.number", Matchers.containsString("INC"));

       // System.out.println(inc.toString());


    }

}
