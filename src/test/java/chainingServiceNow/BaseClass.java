package chainingServiceNow;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {

    public static String sysId;
    public static String number;

    @BeforeMethod
    public void base(){

        RestAssured.baseURI = "https://dev30304.service-now.com/api/now/table/";

        RestAssured.authentication = RestAssured.basic("admin","9Z!Kj%k8NtcP");

    }
}
