package serviceNowCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class CreateIncident {

    public Response response;

    @Given("BasicAuthenticaion")
    public void basicAuth()
    {
        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");
    }

    @When("Create incident with body {String}")
    public void createIncident(String data)
    {

        RequestSpecification body = RestAssured.given().contentType("application/json").when().body(data);

        Response response = body.post("incident");

        response.prettyPrint();
    }

    @Then("validate the status Code 201")
    public void statusCodeCheck(){

        int statusCode = response.getStatusCode();

        System.out.println("Create Incident Post code received is:"+statusCode);

    }
}
