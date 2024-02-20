package serviceNowAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GetWithQueryParams {

    @Test
    public void getWithQueryParams(){

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

        Map<String,String> lmap = new LinkedHashMap<>();

        lmap.put("sysparm_feilds","short_description,description,number,sys_id");
        lmap.put("sysparm_limit","2");

        Response getResp = RestAssured.given().queryParams(lmap).get("incident");

        getResp.prettyPrint();

        System.out.println("Status Code Post :"+getResp.getStatusCode());

        List <String> desc = getResp.jsonPath().getList("result.description");

        List<String> shortDesc = getResp.jsonPath().getList("result.short_description");

        for (int i = 0; i< desc.size(); i++)
        {
            System.out.println("Description :"+desc.get(i) +"and short Description : "+shortDesc.get(i));
        }

    }
}
