package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String GET_LIST_RESOURCE = URL+"/api/unknown?page={page}";
    public static String GET_LIST_SINGLE_RESOURCE = URL+"/api/unknown/{id}";
    public static String POST_CREATE_NEW_USERS = URL+"/api/users";
    public static String POST_REGISTER_USER = URL+"/api/register";
    public static String POST_LOGIN_USER = URL+"/api/login";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get list invalid users")
    public void getListInvalidUsers(String page){SerenityRest.given().pathParam("page",page);}

    @Step("Get list resource")
    public void getListResource(int page){SerenityRest.given().pathParam("page",page);}

    @Step("Get single user")
    public void getSingleUser(int id){SerenityRest.given().pathParam("id",id);}

    @Step("Get single resource")
    public void getSingleResource(int id){SerenityRest.given().pathParam("id",id);}

    @Step("Post create new users")
    public void postCreateNewUsers(File json) {
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Register users")
    public void registerUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Login users")
    public void loginUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id,File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Patch update user")
    public void patchUpdateUser(int id,File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
}
