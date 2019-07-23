import com.controller.HelloWorldController;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.expect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class HelloWorldTest {

    public HelloWorldTest(){
        RestAssured.baseURI  = "http://localhost";
        RestAssured.port     = 8091;
        RestAssured.basePath = "";
        RestAssured.config().connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponse());
    }


    private HelloWorldController.Person person;


    @Given("^I have hello world service$")
    public void iHaveHelloWorldService() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I invoke Hello World Resource$")
    public void iInvokeHelloWorldResource() throws Throwable {
        person = expect().statusCode(200).when().get("/hello").andReturn().as(HelloWorldController.Person.class);
    }

    @Then("^I should get JSON response:$")
    public void iShouldGetJSONResponse(String expected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(new com.fasterxml.jackson.databind.ObjectMapper().readValue(expected,
                HelloWorldController.Person.class).getName(),person.getName());
    }
}
