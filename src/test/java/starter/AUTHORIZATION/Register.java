package starter.AUTHORIZATION;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Register {
    protected String url = "https://altashop-api.fly.dev/";

    //  Verify Successful User Registration
    @Step("I set endpoints for Successful User Registration")
    public String RegistrationEndpointAvailable(){
        return url + "api/auth/register";
    }
    @Step("I register with valid details")
    public void RegisterWithValidDetails(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ReyHAN000000001@gmail.com");
        requestBody.put("password", "reyhan123");
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 200 for Successful User Registration")
    public void ResponsecodeShouldBe200ForSuccessfulUserRegistration(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received a user id")
    public void ReceivedUserId(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String id = jsonPath.get("id");
        restAssuredThat(response -> response.body("id", equalTo(id)));
    }


    //  Verify User Registration with Existing Email
    @Step("I set endpoints for User Registration with Existing Email")
    public String SetEndpointsUserRegistrationExistingEmail(){
        return url + "api/auth/register";
    }
    @Step("I register with an already registered email")
    public void RegisterWithAlreadyRegisteredEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "reyhan0001@gmail.com");
        requestBody.put("password", "reyhan123");
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 for User Registration with Existing Email")
    public void Responsecode400RegistrationExistingEmail(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for existing email")
    public void ReceivedErrorMessageExistingEmail(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Empty Email
    @Step("I set endpoints for User Registration with Empty Email")
    public String SetEndpointsRegistrationEmptyEmail(){
        return url + "api/auth/register";
    }
    @Step("I register with an empty email")
    public void RegisterWithEmptyEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "reyhan123");
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 for User Registration with Empty Email")
    public void Responsecode400RegistrationEmptyEmail(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Registration with Empty Email")
    public void ReceivedErrorMessageRegistrationEmptyEmail(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Empty Password
    @Step("I set endpoints for User Registration with Empty Password")
    public String SetEndpointsRegistrationWithEmptyPassword(){
        return url + "api/auth/register";
    }
    @Step("I register with an empty password")
    public void RegisterWithEmptyPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan1@gmail.com");
        requestBody.put("password", "");
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 for Registration with Empty Password")
    public void Responsecode400RegistrationEmptyPassword(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Registration with Empty Password")
    public void ReceivedErrorMessageRegistrationEmptyPassword(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Empty Full Name
    @Step("I set endpoints for User Registration with Empty Full Name")
    public String SetEndpointsRegistrationEmptyFullName(){
        return url + "api/auth/register";
    }
    @Step("I register with an empty full name")
    public void RegisterEmptyFullName(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan2@gmail.com");
        requestBody.put("password", "reyhan123");
        requestBody.put("fullname", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 for User Registration with Empty Full Name")
    public void Responsecode400RegistrationEmptyFullName(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Registration with Empty Full Name")
    public void ReceivedErrorMessageRegistrationEmptyFullName(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Special Characters in Full Name
    @Step("I set endpoints for User Registration with Special Characters in Full Name")
    public String SetEndpointsRegistrationSpecialCharactersFullName(){
        return url + "api/auth/register";
    }
    @Step("I register with a full name that contains special characters")
    public void RegisterWithFullNameSpecialCharacters(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan0001@gmail.com");
        requestBody.put("password", "reyhan123");
        requestBody.put("fullname", "~!@#$%^&*");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 For Registration with Special Characters in Full Name")
    public void Responsecode400RegistrationSpecialCharactersFullName(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Registration with Special Characters in Full Name")
    public void ReceivedErrorMessageRegistrationWithSpecialCharactersFullName(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Spaces in password
    @Step("I set endpoints for User Registration with Spaces in password")
    public String SetEndpointsRegistrationWithSpacesInPassword(){
        return url + "api/auth/register";
    }
    @Step("I registered a password with spaces")
    public void RegisteredPasswordWithSpaces(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan00010@gmail.com");
        requestBody.put("password", "        ");    //8 X spaces
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 for Registration with Spaces in password")
    public void Responsecode400RegistrationSpacesPassword(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Registration with Spaces in password")
    public void ReceivedErrorMessageRegistrationSpacesPassword(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Invalid Email Format
    @Step("I set endpoints for User Registration with Special Characters in Email")
    public String SetEndpointsRegistrationWithInvalidEmailFormat(){
        return url + "api/auth/register";
    }
    @Step("I register with Special Characters in Email")
    public void RegisterInvalidEmailFormat(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "~!@#$%^&*.");
        requestBody.put("password", "reyhan123");
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 400 for Registration with Special Characters in Email")
    public void Responsecode400RegistrationInvalidEmailFormat(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Registration with Special Characters in Email")
    public void ReceivedErrorMessageRegistrationInvalidEmailFormat(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String error = jsonPath.get("error");
        restAssuredThat(response -> response.body("error", equalTo(error)));
    }


    //  Verify User Registration with Special Characters in password
    @Step("I set endpoints for Registration with Special Characters in password")
    public String SetEndpointsRegistrationSpecialCharactersPassword(){
        return url + "api/auth/register";
    }
    @Step("I Registration with Special Characters in a password")
    public void RegistrationWithSpecialCharactersPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "rEYHAN0101@gmail.com");
        requestBody.put("password", "~!@#$%^&*");
        requestBody.put("fullname", "Reyhan Irfansyah");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(RegistrationEndpointAvailable());
    }
    @Step("the response status code should be 200 for User Registration with Special Characters in password")
    public void Responsecode200RegistrationSpecialCharactersPassword(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received a user Id")
    public void IReceiveduserId(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String id = jsonPath.get("id");
        restAssuredThat(response -> response.body("id", equalTo(id)));
    }

}
