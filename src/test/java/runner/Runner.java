package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featurefile",glue = "steps", publish = true, monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {

}
