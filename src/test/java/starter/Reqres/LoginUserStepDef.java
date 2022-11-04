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

public class LoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson(){
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/EmailandPassword.json");
        reqresAPI.loginUser(json);
    }

    @Given("Post login user without email")
    public void postLoginUserWithoutEmailJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/PasswordWithoutEmail.json");
        reqresAPI.loginUser(json);
    }

    @Given("Post login user without password")
    public void postLoginUserWithoutPassword() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/EmailWithoutPassword.json");
        reqresAPI.loginUser(json);
    }

    @When("Send post login user request")
    public void sendPostLoginUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @Then("Response Code should be {int} OK")
    public void responseCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @Then("Response Code should be {int} Bad Request")
    public void responseCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body should contain error messages {string}")
    public void responseBodyShouldContainErrorMessages(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate post login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostLoginUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate login error messages json schema")
    public void validateLoginErrorMessagesJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/ErrorMessagesJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
