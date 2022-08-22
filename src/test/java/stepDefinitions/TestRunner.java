package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue= {"stepDefinitions"}, tags = "@test", 
monochrome = true, plugin = {"json:target/cucumber.json"}) // "pretty", "html:target/HtmlReports", 


public class TestRunner {

	
}
