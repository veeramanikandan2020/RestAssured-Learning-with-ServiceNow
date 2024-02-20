package chainingServiceNow;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteAIncident extends BaseClass {

   // @Test (dependsOnMethods = "chainingServiceNow.UpdateIncident.updatingIncident")
    @Test (dependsOnMethods = "chainingServiceNow.CreateIncident.createincidentServiceNow")
    public void deletingIncident(){

        Response del = RestAssured.given().when().delete("incident/"+sysId);

        System.out.println(del.getStatusCode());

    }
}
