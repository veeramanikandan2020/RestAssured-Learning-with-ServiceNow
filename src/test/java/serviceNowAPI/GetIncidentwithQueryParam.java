package serviceNowAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetIncidentwithQueryParam extends CreateIncident{

    @Test
    public void getIncidentWithQueryParameter(){

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

        Response getResp = RestAssured.given().queryParam("sysparm_fields","short_description,description,number,sys_id")
                .get("incident");

        int sgetCode = getResp.getStatusCode();

        getResp.prettyPrint();

        System.out.println(getResp.jsonPath().getList("result.sys_id"));

    }
}
