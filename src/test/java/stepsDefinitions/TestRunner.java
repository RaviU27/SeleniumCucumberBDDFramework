package stepsDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features", glue={"stepsDefinitions"},
monochrome=true,
plugin = {"pretty", "html:target/HtmlReports/report.html",
		"json:target/JsonReports/report.json"})
//tags="@smokeTest")
public class TestRunner {

}
