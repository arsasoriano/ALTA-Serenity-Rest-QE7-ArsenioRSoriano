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

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with parameter id {int}")
    public void getListUserWithId(int id){reqresAPI.getSingleUser(id);}

    @When("Send get single user request")
    public void sendGetSingleUserRequest(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Status response code should be {int} OK")
    public void statusResponseCodeShouldBe(int code){
        SerenityRest.then().statusCode(code);
    }

    @And("Response body code should contain id {int}")
    public void responseBodyCodeShouldContainIdId(int id) {
        SerenityRest.then().body(ReqresResponses.DATA_ID,equalTo(id));
    }

    @Then("Status response code should be {int} Not Found")
    public void statusResponseCodeShouldBeNotFound(int notFound){
        SerenityRest.then().statusCode(notFound);
    }

    @And("Validate get single list user json schema")
    public void validateGetSingleListUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListSingleUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
