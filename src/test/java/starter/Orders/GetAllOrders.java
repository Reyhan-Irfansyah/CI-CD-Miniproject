package starter.Orders;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.HashMap;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllOrders {
    protected String url = "https://altashop-api.fly.dev/";
    protected String ValidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IlJleWhhbiBJcmZhbnN5YWgiLCJFbWFpbCI6IlJleWhhbkBnbWFpbC5jb20ifQ.Bn6KUspeNCzBRc9mTDLzPZJse59mSYLea6N2errYZQs";
    protected String InvalidToken = "testWithInvalidToken";

    //  Verify Successfully Get all orders
    @Step("I set endpoints for Successfully Get all orders")
    public String SetEndpointsGetAllOrders(){
        return url + "api/orders";
    }
    @Step("a valid Bearer Token is provided")
    public String  ValidbearerTokenisProvided(){
        return ValidToken;
    }
    @Step("I request all orders with valid credentials")
    public void RequestAllOrdersWithValidCredentials() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + ValidToken)
                .get(SetEndpointsGetAllOrders());
    }
    @Step("the response code should be 200 for Successfully Get all orders")
    public void Responsecode200GetAllOrders(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I received the correct all orders")
    public void ReceiveCorrectAllOrders() {
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


    //  Verify Get all orders with Invalid Token
    @Step("I set endpoints for Get all orders with Invalid Token")
    public String SetEndpointsGetAllOrdersWithInvalidToken(){
        return url + "api/orders";
    }
    @Step("an invalid Bearer Token is provided")
    public String  InvalidbearerTokenisProvided(){
        return InvalidToken;
    }
    @Step("I request all orders with an invalid token")
    public void RequestAllOrderswitinvalidtoken() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + InvalidToken)
                .get(SetEndpointsGetAllOrders());
    }
    @Step("the response code should be 401 for Get all orders with Invalid Token")
    public void Responsecode401GetAllOrderInvalidToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I received a error message for invalid Token")
    public void ReceiveCorrectAllOrdersInvalidToken() {
        try {
            String responseBody = SerenityRest.lastResponse().getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errorMessage = jsonPath.get("error.message");
            restAssuredThat(response -> response.body("error.message", equalTo("token contains an invalid number of segments")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //  Verify Get all orders without Token
    @Step("I set endpoints for Get all orders without Token")
    public String SetEndpointsGetAllOrdersWithwithoutToken(){
        return url + "api/orders";
    }
    @Step("no Bearer Token is provided")
    public void noBearerTokenisprovided(){

    }
    @Step("I request all orders without a token")
    public void RequestAllOrdersWithoutAtoken() {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ")
                .get(SetEndpointsGetAllOrders());
    }
    @Step("the response code should be 401 for Get all orders with Invalid Token")
    public void Responsecode401GetAllOrderswithoutToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
    @Step("I received a error message for invalid token a error message for missing Token")
    public void ReceiveCorrectAllOrdersmissingToken() {
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
