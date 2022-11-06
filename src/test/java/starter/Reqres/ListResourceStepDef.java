package starter.Reqres;

import com.github.fge.jsonschema.main.JsonValidator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class ListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resource with parameter page {int}")
    public void getListResourceWithParameterPagePage(int page) {
        reqresAPI.getListResource(page);
    }

    @When("Send get list resource request")
    public void sendGetListResourceRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @Then("Response status code should be {int} OK")
    public void responseStatusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body code should be {int}")
    public void responseBodyCodeShouldBePage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list resource json schema")
    public void validateGetListResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListResourceJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
