package StepsDefinition;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src//test//resources//Features",glue= {"StepsDefinition"})
public class TestRunner extends DataProvider{

}
