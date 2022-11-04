package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;

public class UpdateUser {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with valid json with invalid id {int}")
    public void putUpdateUserWithValidJsonWithInvalidIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send put update user requests")
    public void sendPutUpdateUserRequests() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Then("Respon code should be {int} ok")
    public void responCodeShouldBeBadRequest(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Put update user without job with valid id {int}")
    public void putUpdateUserWithoutJobWithValidIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateWithoutJob.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @And("Response body should contain name {string}")
    public void responseBodyShouldContainName(String name) {
        SerenityRest.then().body(ReqresResponses.NAME,equalTo(name));
    }

    @Given("Put update user without name with valid id {int}")
    public void putUpdateUserWithoutNameWithValidIdId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateWithoutName.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @And("Response body should contain job {string}")
    public void responseBodyShouldContainJob(String job) {
        SerenityRest.then().body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate update user json schema")
    public void validateUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/UpdateUserWithoutJobJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate update user Json Schema")
    public void validateUpdateJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/UpdateUserWithoutNameJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
