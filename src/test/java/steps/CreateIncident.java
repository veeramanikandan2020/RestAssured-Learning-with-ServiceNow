package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import serviceNowCucumber.ServiceNowBase;

import java.io.File;


public class CreateIncident extends ServiceNowBase {

    public static Response response,getResponse, putResponse;

    public static String sysId;

    @Given("BasicAuthenticaion")
    public void basicAuth()
    {
        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");
    }

    @When("Create incident with body {string}")
    public void createIncidentWithBody(String data)
    {
        RequestSpecification body = RestAssured.given().contentType("application/json").when().body(data);
        response = body.post("incident");
        int statusCode = response.getStatusCode();

        //int sysId = response.jsonPath().get("result.sysId");

        sysId = response.jsonPath().get("result.sys_id");

        System.out.println("Sysid is :"+sysId);

        response.prettyPrint();
    }

    @Then("validate the status Code 201")
    public void statusCodeCheck(){

        int statusCode = response.getStatusCode();
        System.out.println("Create Incident Post code received is:"+statusCode);
        response.then().assertThat().statusCode(Matchers.equalTo(201));

    }

    @When("Get incident")
    public void getIncident() {

        /*RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");*/

        getResponse = RestAssured.get("incident/"+sysId); //incident/35f2335c976002103838bcb3f153af36

        getResponse.prettyPrint();

    }

    @Then("validate the status Code 200")
    public void getStatusCode(){

        int statusCode = getResponse.getStatusCode();
        System.out.println(statusCode);

        getResponse.then().assertThat().statusCode(Matchers.equalTo(200));

    }

    @When("Put incident with {string}")
    public void putIncident(String fileName) {

        /*RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");*/

        File file = new File("src/data/FileJSONData.json");
        RequestSpecification body = RestAssured.given().contentType("application/json").when().body(file);
        putResponse = body.put("incident/" + sysId);

        String s = putResponse.prettyPrint();

    }

    @Then("validate the status Code")
    public void validatethestatusCode(){

        int statusCode = putResponse.getStatusCode();

        System.out.println("Put update :"+statusCode);

       putResponse.then().assertThat().statusCode(Matchers.equalTo(200));

    }

}
