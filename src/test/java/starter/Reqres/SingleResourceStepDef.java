package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class SingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single resource with parameter id {int}")
    public void getSingleResourceWithParameterId(int id){
        reqresAPI.getSingleResource(id);
    }

    @When("Send get resource user request")
    public void sendGetResourceUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_SINGLE_RESOURCE);
    }

    @Then("Status Response code should be {int} OK")
    public void statusResponseCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response Body code should contain id {int}")
    public void responseBodyCodeShouldContainIdId(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID,equalTo(id));
    }

    @Then("Status Response code should be {int} Not Found")
    public void statusResponseCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Validate get single list resource json schema")
    public void validateGetSingleListResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListSingleResourceJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
