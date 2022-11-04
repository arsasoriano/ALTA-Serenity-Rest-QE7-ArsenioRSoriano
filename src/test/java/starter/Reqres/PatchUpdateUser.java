package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PatchUpdateUser {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch update user with valid json with valid id {int}")
    public void patchUpdateUserWithValidJsonWithValidId(int id){
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateUser.json");
        reqresAPI.patchUpdateUser(id,json);
    }

    @When("Send patch update user request")
    public void sendPatchUpdateUserRequest() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate patch update user json schema")
    public void validatePatchUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PutUpdateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
