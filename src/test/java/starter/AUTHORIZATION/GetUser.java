package starter.AUTHORIZATION;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetUser {
    protected String url = "https://altashop-api.fly.dev/";
    protected String ValidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlJleWhhbiBJcmZhbnN5YWgiLCJFbWFpbCI6IlJleWhhbkBnbWFpbC5jb20ifQ.Bn6KUspeNCzBRc9mTDLzPZJse59mSYLea6N2errYZQs";
    protected String InvalidToken = "testWithInvalidToken";

    //  Successfully Get User Information
    @Step("I set endpoints for Successfully Get User Information")
    public String SetEndpointsSuccessfullyGetUserInformation(){
        return url + "api/auth/info";
    }
    @Step("a valid bearer token is provided")
    public String  ValidBearerTokenProvided(){
        return ValidToken;
    }
    @Step("I request user information with valid credentials")
    public void RequestUserinformationwithValidCredentials(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + ValidToken)
                .when()
                .get(SetEndpointsSuccessfullyGetUserInformation());
    }
    @Step("the response code should be 200 for Successfully Get User Information")
    public void Responsecode200SuccessfullyGetUserInformation(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received the correct user details")
    public void ReceivedCorrectUserDetails(){
        restAssuredThat(response -> response.body("'data'.'ID'", Matchers.equalTo(26339)));
        restAssuredThat(response -> response.body("'data'.'Fullname'", Matchers.equalTo("Reyhan Irfansyah")));
        restAssuredThat(response -> response.body("'data'.'Email'", Matchers.equalTo("Reyhan@gmail.com")));
        restAssuredThat(response -> response.body("'data'.'Password'", Matchers.equalTo("reyhan123")));
    }


    //  Verify Get User Information with Invalid Token
    @Step("I set endpoints for Get User Information with Invalid Token")
    public String SetEndpointsGetUserInformationInvalidToken(){
        return url + "api/auth/info";
    }
    @Step("an invalid bearer token is provided")
    public void   InvalidBearerTokenProvided(){

    }
    @Step("I request user information with an invalid token")
    public void RequestUserInformationWithInvalidToken(){
        SerenityRest.given()
                .when()
                .get(SetEndpointsGetUserInformationInvalidToken());
    }
    @Step("the response code should be 401 for Get User Information with Invalid Token")
    public void Responsecode401GetUserInformationInvalidToke(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I received a error message for invalid token")
    public void ReceivedErrorMessageInvalidToken() {
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("token contains an invalid number of segments")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Verify Get User Information without Token
    @Step("I set endpoints for Get User Information without Token")
    public String SetEndpointsGetUserInformationWithoutToken(){
        return url + "api/auth/info";
    }
    @Step("no bearer token is provided")
    public String  NoBearerTokenProvided(){
        return InvalidToken;
    }
    @Step("I request user information without a token")
    public void RequestUserInformationWithoutToken(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + InvalidToken)
                .when()
                .get(SetEndpointsGetUserInformationInvalidToken());
    }
    @Step("the response status code should be 401 for Get User Information without Token")
    public void Responsecode401GetUserInformationWithoutToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I received a error message for invalid token a error message for missing token")
    public void ReceivedErrorMessageMissingToken() {
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("unauthorized")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
