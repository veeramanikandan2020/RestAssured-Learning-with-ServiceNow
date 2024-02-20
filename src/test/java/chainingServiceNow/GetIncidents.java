package chainingServiceNow;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetIncidents extends BaseClass {

    /*// @Test (dependsOnMethods = "chainingServiceNow.CreateIncident.createincidentServiceNow")
     public void getIncidentsAll(){

         Map<String,String> lmap = new LinkedHashMap<>();

         lmap.put("sysparm_feilds","short_description,description,number,sys_id");
         lmap.put("sysparm_limit","2");

         Response getResp = RestAssured.given().queryParams(lmap).get("incident");

         getResp.prettyPrint();

         System.out.println("Status Code Post :"+getResp.getStatusCode());

         List<String> desc = getResp.jsonPath().getList("result.description");

         List<String> shortDesc = getResp.jsonPath().getList("result.short_description");

         for (int i = 0; i< desc.size(); i++)
         {
             System.out.println("Description :"+desc.get(i) +"and short Description : "+shortDesc.get(i));
         }
     }*/
    //packageName.ClassName.MethodName
    @Test(dependsOnMethods = "chainingServiceNow.CreateIncident.createincidentServiceNow")
    public void getIncidentsBySysID() {

        Response getResp = RestAssured.given()
                .get("incident/" + sysId);

        int sgetCode = getResp.getStatusCode();

        getResp.prettyPrint();

        System.out.println("Get Status Code :" + sgetCode);

        getResp.then().assertThat().body("result.number", Matchers.equalToIgnoringCase(number));

        getResp.then().assertThat().body("result.sys_id", Matchers.equalToIgnoringCase(sysId));

    }
}
