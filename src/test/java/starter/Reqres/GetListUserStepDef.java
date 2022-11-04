package starter.Reqres;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class GetListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page){
        reqresAPI.getListInvalidUsers(page);
    }
}
