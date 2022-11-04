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

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson(){
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/EmailandPassword.json");
        reqresAPI.registerUser(json);
    }

    @Given("Post register user without password json")
    public void postRegisterUserWithoutPassJson(){
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/EmailWithoutPassword.json");
        reqresAPI.registerUser(json);
    }

    @Given("Post register user without email json")
    public void postRegisterUserWithoutEmailJson(){
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PasswordWithoutEmail.json");
        reqresAPI.registerUser(json);
    }

    @When("Send post register user request")
    public void sendPostRegisterUserRequest(){
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @Then("Response code should be {int} OK")
    public void responseCodeShouldBe(int ok){
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should contain id {int} and token {string}")
    public void containResponseBody(int id,String token){
        SerenityRest.then()
                    .body(ReqresResponses.ID,equalTo(id))
                    .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @Then("Response code should be {int} Bad Request")
    public void responseCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate post register user json schema")
    public void validatePostRegisterUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostRegisterUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate register error messages json schema")
    public void validateRegisterErrorMessagesJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/ErrorMessagesJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
