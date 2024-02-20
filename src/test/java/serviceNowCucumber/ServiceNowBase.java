package serviceNowCucumber;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServiceNowBase {

    public static String sysId;

    @BeforeMethod
    public void baseServiceNow() {

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

    }

}
