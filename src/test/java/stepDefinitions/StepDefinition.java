package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.APIResources;
import resource.TestDataBuild;
import resource.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition {
    RequestSpecification res;
    ResponseSpecification respec;
    Response response;
    TestDataBuild data = new TestDataBuild();


    @Given("Add Place Payload with {string}, {string} and {string}")
    public void addPlacePayloadWithAnd(String name, String language, String address) throws IOException {
        respec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        res = given().spec(Utils.requestSpecification()).body(data.addPlacePayLoad(name, language, address));
    }

    @When("User calls {string} with {string} http request")
    public void user_calls_with_post_http_request(String resource, String requestType) {
        APIResources resoAPI = APIResources.valueOf(resource);

        if (requestType.equalsIgnoreCase("post"))
            response = res.when().post(resoAPI.getResource());
        else if (requestType.equalsIgnoreCase("get"))
            response = res.when().get(resoAPI.getResource());

    }

    @Then("The API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int temp) {
        assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        JsonPath js = new JsonPath(response.asString());
        assertEquals(js.get(key).toString(), value);
    }


}
