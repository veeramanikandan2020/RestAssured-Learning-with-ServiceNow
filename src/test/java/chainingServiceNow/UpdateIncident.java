package chainingServiceNow;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class UpdateIncident extends BaseClass{

    //@Test (dependsOnMethods = "chainingServiceNow.GetIncidents.getIncidentsBySysID") error chainingServiceNow.GetIncidents.getIncidentsBySysID()
    // is depending on method public void chainingServiceNow.CreateIncident.createincidentServiceNow(),
    // which is not annotated with @Test or not included. (Chaining doesnt work)
    @Test (dependsOnMethods = "chainingServiceNow.CreateIncident.createincidentServiceNow")
    public void updatingIncident(){

        File file = new File("src/data/FileJSONData.json");

        RequestSpecification input = RestAssured.given().contentType("application/json").body(file);

        Response put = input.put("incident/"+sysId);

        System.out.println(put.getStatusCode());

        put.prettyPrint();
    }
}
