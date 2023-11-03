package starter.Orders;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.util.ArrayList;
import java.util.HashMap;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetOrderByID {
    protected String url = "https://altashop-api.fly.dev/";
    protected String ValidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlJleWhhbiBJcmZhbnN5YWgiLCJFbWFpbCI6IlJleWhhbkBnbWFpbC5jb20ifQ.Bn6KUspeNCzBRc9mTDLzPZJse59mSYLea6N2errYZQs";
    protected String InvalidToken = "testWithInvalidToken";


    //  Verify Successfully Get orders By ID
    @Step("I set endpoints for Successfully Get orders by ID")
    public String SetEndpointsGetGetOrdersByID(){
        return url + "api/orders";
    }
    @Step("a Valid Bearer Token is provided")
    public String  validBearerTokenisprovided(){
        return ValidToken;
    }
    @Step("I request orders By ID with valid credentials")
    public void RequestOrdersByIDWithAtoken() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + ValidToken)
                .get(SetEndpointsGetGetOrdersByID());
    }
    @Step("the response code should be 200 for Successfully Get orders By ID")
    public void Responsecode200GetOrderByIDswithToken(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received the correct orders By ID")
    public void ReceiveCorrectOrdersByID() {
        ArrayList<HashMap<String, Object>> dataList = SerenityRest.lastResponse().path("data");
        for (HashMap<String, Object> dataItem : dataList) {
            int orderID = (int) dataItem.get("ID");
            HashMap<String, Object> user = (HashMap<String, Object>) dataItem.get("User");
            int userID = (int) user.get("ID");
            String fullname = (String) user.get("Fullname");
            String email = (String) user.get("Email");
            System.out.println("Order ID: " + orderID);
            System.out.println("User ID: " + userID);
            System.out.println("Fullname: " + fullname);
            System.out.println("Email: " + email);
        }
    }


    //  Verify Get orders by ID with Invalid Token
    @Step("I set endpoints for Get orders by ID with Invalid Token")
    public String SetEndpointsGetGetOrdersByIDWithInvalidToken(){
        return url + "api/orders";
    }
    @Step("an Invalid Bearer Token is provided")
    public String  invalidBearerTokenisprovided(){
        return InvalidToken;
    }
    @Step("I request orders by ID with an invalid token")
    public void RequestOrdersByIDWithAInvalidtoken() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + InvalidToken)
                .get(SetEndpointsGetGetOrdersByIDWithInvalidToken());
    }
    @Step("the response code should be 401 for Get orders by ID with Invalid Token")
    public void Responsecode401GetOrderByIDWithInvalidToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I Received a error message for invalid Token")
    public void ReceivedErrorMessageForInvalidToken() {
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("token contains an invalid number of segments")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //  Verify Get orders by ID without Token
    @Step("I set endpoints for Get orders by ID without Token")
    public String SetEndpointsGetGetOrdersByIDWithoutToken(){
        return url + "api/orders";
    }
    @Step("No Bearer Token is provided")
    public void NoBearerTokenisprovided(){

    }
    @Step("I request orders by ID without a token")
    public void RequestOrdersbyIDWithoutToken() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ")
                .get(SetEndpointsGetGetOrdersByIDWithoutToken());
    }
    @Step("the response status code should be 401 for Get orders by ID without Token")
    public void Responsecode401GetOrderByIDwithoutToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I Received a error message for invalid token a error message for missing Token")
    public void ReceivedErrorMessageFormissingToken() {
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
