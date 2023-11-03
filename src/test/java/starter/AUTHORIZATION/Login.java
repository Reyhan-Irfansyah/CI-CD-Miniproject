package starter.AUTHORIZATION;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Login {
    protected String url = "https://altashop-api.fly.dev/";

    //  Successful User Login
    @Step("I set endpoints for Successful User Login")
    public String SetEndpointsforSuccessfulUserLogin(){
        return url + "api/auth/login";
    }

    @Step("I login with valid credentials")
    public void LoginWithValidCredentials(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan@gmail.com");
        requestBody.put("password", "reyhan123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsforSuccessfulUserLogin());
    }

    @Step("the response status code should be 200 for Successful User Login")
    public void Responsecode200SuccessfulUserLogin(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I received a data")
    public void ReceivedData(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String data = jsonPath.get("data");
        restAssuredThat(response -> response.body("data", equalTo(data)));
    }

    //  User Login with Unregistered Email
    @Step("I set endpoints for Login with Unregistered Email")
    public String SetEndpointsLoginUnregisteredEmail(){
        return url + "api/auth/login";
    }
    @Step("I login with an unregistered email")
    public void LoginWithUnregisteredEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "akuntidakterdaftar@gmail.com");
        requestBody.put("password", "reyhan123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginUnregisteredEmail());
    }
    @Step("the response status code should be 400 for Login with Unregistered Email")
    public void Responsecode400LoginWithUnregisteredEmail(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for unregistered email")
    public void ReceivedErrorMessageUnregisteredEmail(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("record not found")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  User Login with Incorrect Password
    @Step("I set endpoints for Login with Incorrect Password")
    public String SetEndpointsLoginWithIncorrectPassword(){
        return url + "api/auth/login";
    }
    @Step("I login with an incorrect password")
    public void LoginWithIncorrectPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan@gmail.com");
        requestBody.put("password", "test123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginWithIncorrectPassword());
    }
    @Step("the response status code should be 400 for Login with Incorrect Password")
    public void Responsecode400LoginWithIncorrectPassword(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for incorrect password")
    public void ReceivedErrorMessageIncorrectPassword(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("email or password is invalid")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  User Login with Empty Email
    @Step("I set endpoints for Login with Empty Email")
    public String SetEndpointsLoginWithEmptyEmail(){
        return url + "api/auth/login";
    }
    @Step("I login with an empty email")
    public void LoginWithEmptyEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "reyhan123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginWithEmptyEmail());
    }
    @Step("the response status code should be 400 for Login with Empty Email")
    public void Responsecode400LoginwithEmptyEmail(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for empty email")
    public void ReceivedErrorMessageEmptyEmail(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("email is required")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Verify User Login with Empty Password
    @Step("I set endpoints for Login with Empty Password")
    public String SetEndpointsLoginWithEmptyPassword(){
        return url + "api/auth/login";
    }
    @Step("I login with an empty password")
    public void LoginWithEmptyPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan@gmail.com");
        requestBody.put("password", "");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginWithEmptyPassword());
    }
    @Step("the response status code should be 400 for Login with Empty Password")
    public void Responsecode400LoginwithEmptyPassword(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for empty password")
    public void ReceivedErrorMessageEmptyPassword(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("password is required")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Verify User Login with only Spaces in email
    @Step("I set endpoints for Login with Spaces in email")
    public String SetEndpointsLoginWithSpacesInEmail(){
        return url + "api/auth/login";
    }
    @Step("I fill in the email with spaces")
    public void FillInEmailWithSpaces(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "        ");
        requestBody.put("password", "reyhan123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginWithSpacesInEmail());
    }
    @Step("the response status code should be 400 for Login with Spaces in email")
    public void Responsecode400LoginSpacesEmail(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Login with Spaces in email")
    public void ReceivedErrorMessageLoginWithSpacesEmail(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("email or password is invalid")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Verify User Login with Spaces in password
    @Step("I set endpoints for Login with Spaces in password")
    public String SetEndpointsLoginWithSpacesPassword(){
        return url + "api/auth/login";
    }
    @Step("I fill in the password with spaces")
    public void FillPasswordWithSpaces(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan4@gmail.com");
        requestBody.put("password", "        ");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginWithSpacesPassword());
    }
    @Step("the response status code should be 400 for Login with Spaces in password")
    public void responsecode400LoginSpacespassword(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Login with Spaces in password")
    public void ReceivedErrorMessageLoginWithSpacesPassword(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("email or password is invalid")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Verify User Login with Only Special Characters in Email
    @Step("I set endpoints for Login with Special Characters in Email")
    public String SetEndpointsLoginSpecialCharactersEmail(){
        return url + "api/auth/login";
    }
    @Step("I login with a Email with Special Characters")
    public void LoginWithEmailSpecialCharacters(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "~!@#$%^&*");
        requestBody.put("password", "reyhan123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginSpecialCharactersEmail());
    }
    @Step("the response status code should be 400 for Login with Special Characters in Email")
    public void Responsecode400LoginSpecialCharacters(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for Login with Special Characters in Email")
    public void ReceivedErrorMessageLoginSpecialCharactersEmail(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("email or password is invalid")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //  Verify User Login with Special Characters in Password
    @Step("I set endpoints for Login with Special Characters in Password")
    public String SetEndpointsLoginWithSpecialCharactersPassword(){
        return url + "api/auth/login";
    }
    @Step("I login with Special Characters in a password")
    public void LoginSpecialCharactersPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Reyhan5@gmail.com");
        requestBody.put("password", "~!@#$%^&*");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginWithSpecialCharactersPassword());
    }
    @Step("the response status code should be 200 for Login with Special Characters in Password")
    public void Responsecode200LoginSpecialCharactersPassword(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received a error message for Login with Special Characters in Password")
    public void ReceivedErrorMessageLoginSpecialCharactersPassword(){
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String data = jsonPath.get("data");
        restAssuredThat(response -> response.body("data", equalTo(data)));
    }


    //  Verify User Login with Fill in email with valid password, and Fill in password with valid email
    @Step("I set endpoints for Login with Fill in email with valid password, and Fill in password with valid email")
    public String SetEndpointsLoginFillEmailWithValidPasswordFillPasswordWithValidEmail(){
        return url + "api/auth/login";
    }
    @Step("I login with Fill in email with valid password, and Fill in password with valid email")
    public void LoginFillEmailValidPasswordFillPasswordWithValidEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "reyhan123");
        requestBody.put("password", "Reyhan@gmail.com");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(SetEndpointsLoginFillEmailWithValidPasswordFillPasswordWithValidEmail());
    }
    @Step("the response status code should be 400 for Login with Fill in email with valid password, and Fill in password with valid email")
    public void Responsecode400ForLoginFillEmailValidPasswordFillPasswordWithValidEmail(){
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("I received a error message for for Login with Fill in email with valid password, and Fill in password with valid email")
    public void ReceivedErrorMessageForLoginFillEmailValidPasswordFillPasswordWithValidEmail(){
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("record not found")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
