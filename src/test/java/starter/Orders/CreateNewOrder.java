package starter.Orders;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateNewOrder {
    protected String url = "https://altashop-api.fly.dev/";
    protected String ValidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlJleWhhbiBJcmZhbnN5YWgiLCJFbWFpbCI6IlJleWhhbkBnbWFpbC5jb20ifQ.Bn6KUspeNCzBRc9mTDLzPZJse59mSYLea6N2errYZQs";
    protected String InvalidToken = "testWithInvalidToken";

    //  Verify Successfully Create a new order
    @Step("I set endpoints for Successfully Create a new order")
    public String SetEndpointsToCreateaNewOrder(){
        return url + "api/orders";
    }
    @Step("a valid bearer token is Provided")
    public String  validbearertokenisProvided(){
        return ValidToken;
    }
    @Step("I Send HTTP Request for Create a new order")
    public void sendHTTPRequestforCreateNewOrder() {
        String requestBody = "[{\"order_items\": [{\"product_id\": 2, \"quantity\": 1}]}]";
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + ValidToken)
                .body(requestBody)
                .post(SetEndpointsToCreateaNewOrder());
    }
    @Step("the response code should be 200 for Successfully Create a new order")
    public void Responsecode200CreateaNewOrder(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received the correct user data")
    public void ReceivedTheCorrectUserData() {
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


    //  Verify Create a new order with Invalid Token
    @Step("I set endpoints for Create a new order with Invalid Token")
    public String SetEndpointsToCreateaNewOrderwithInvalidToken(){
        return url + "api/orders";
    }
    @Step("an invalid bearer Token is provided")
    public String  InvalidbearertokenisProvided(){
        return InvalidToken;
    }
    @Step("I Send HTTP Request for Create a new order with Invalid Token")
    public void SendHTTPRequestforCreateneworderWithInvalidToken() {
        String requestBody = "[{\"order_items\": [{\"product_id\": 2, \"quantity\": 1}]}]";
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + InvalidToken)
                .body(requestBody)
                .post(SetEndpointsToCreateaNewOrder());
    }
    @Step("the response code should be 401 for Create a new order with Invalid Token")
    public void Responsecode401CreateaNewOrderWithInvalidToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I received a error message for Invalid token")
    public void ReceivedErrorMessageWithInvalidToken() {
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("token contains an invalid number of segments")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Verify Create a new order without Token
    @Step("I set endpoints for Create a new order without Token")
    public String SetEndpointsToCreateaNewOrderWithoutToken(){
        return url + "api/orders";
    }
    @Step("no bearer Token is provided")
    public void  NobearerTokenisProvided(){

    }
    @Step("I Send HTTP Request for Create a new order without Token")
    public void SendHTTPRequestforCreateneworderWithoutToken() {
        String requestBody = "[{\"order_items\": [{\"product_id\": 2, \"quantity\": 1}]}]";
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer")
                .body(requestBody)
                .post(SetEndpointsToCreateaNewOrder());
    }
    @Step("the response status code should be 401 for Create a new order without Token")
    public void Responsecode401CreateaNewOrderWithoutToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I received a error message for invalid Token a error message for missing token")
    public void ReceivederrorMessageMissingToken() {
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
