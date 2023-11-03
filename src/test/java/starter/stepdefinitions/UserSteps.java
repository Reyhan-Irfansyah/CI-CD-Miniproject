package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.AUTHORIZATION.*;
import starter.Orders.*;

public class UserSteps {

    @Steps
    Register register;

    @Steps
    Login login;

    @Steps
    GetUser getUser;

    @Steps
    CreateNewOrder createNewOrder;

    @Steps
    GetAllOrders getAllOrders;

    @Steps
    GetOrderByID getOrderByID;



    //  Registration
//  Verify Successful User Registration
    @Given("I set endpoints for Successful User Registration")
    public void RegistrationEndpointAvailable(){
        register.RegistrationEndpointAvailable();
    }
    @When("I register with valid details")
    public void RegisterWithValidDetails(){
        register.RegisterWithValidDetails();
    }
    @And("the response status code should be 200 for Successful User Registration")
    public void ResponsecodeShouldBe200ForSuccessfulUserRegistration(){
        register.ResponsecodeShouldBe200ForSuccessfulUserRegistration();
    }
    @Then("I received a user id")
    public void ReceivedUserId(){
        register.ReceivedUserId();
    }


    //  Verify User Registration with Existing Email
    @Given("I set endpoints for User Registration with Existing Email")
    public void SetEndpointsUserRegistrationExistingEmail(){
        register.SetEndpointsUserRegistrationExistingEmail();
    }
    @When("I register with an already registered email")
    public void RegisterWithAlreadyRegisteredEmail(){
        register.RegisterWithAlreadyRegisteredEmail();
    }
    @And("the response status code should be 400 for User Registration with Existing Email")
    public void Responsecode400RegistrationExistingEmail(){
        register.Responsecode400RegistrationExistingEmail();
    }
    @Then("I received a error message for existing email")
    public void ReceivedErrorMessageExistingEmail(){
        register.ReceivedErrorMessageExistingEmail();
    }


    //  Verify User Registration with Empty Email
    @Given("I set endpoints for User Registration with Empty Email")
    public void SetEndpointsRegistrationEmptyEmail(){
        register.SetEndpointsRegistrationEmptyEmail();
    }
    @When("I register with an empty email")
    public void RegisterWithEmptyEmail(){
        register.RegisterWithEmptyEmail();
    }
    @And("the response status code should be 400 for User Registration with Empty Email")
    public void Responsecode400RegistrationEmptyEmail(){
        register.Responsecode400RegistrationEmptyEmail();
    }
    @Then("I received a error message for Registration with Empty Email")
    public void ReceivedErrorMessageRegistrationEmptyEmail(){
        register.ReceivedErrorMessageRegistrationEmptyEmail();
    }


    //  Verify User Registration with Empty Password
    @Given("I set endpoints for User Registration with Empty Password")
    public void SetEndpointsRegistrationWithEmptyPassword(){
        register.SetEndpointsRegistrationWithEmptyPassword();
    }
    @When("I register with an empty password")
    public void RegisterWithEmptyPassword(){
        register.RegisterWithEmptyPassword();
    }
    @And("the response status code should be 400 for Registration with Empty Password")
    public void Responsecode400RegistrationEmptyPassword(){
        register.Responsecode400RegistrationEmptyPassword();
    }
    @Then("I received a error message for Registration with Empty Password")
    public void ReceivedErrorMessageRegistrationEmptyPassword(){
        register.ReceivedErrorMessageRegistrationEmptyPassword();
    }


    //  Verify User Registration with Empty Full Name
    @Given("I set endpoints for User Registration with Empty Full Name")
    public void SetEndpointsRegistrationEmptyFullName(){
        register.SetEndpointsRegistrationEmptyFullName();
    }
    @When("I register with an empty full name")
    public void RegisterEmptyFullName(){
        register.RegisterEmptyFullName();
    }
    @And("the response status code should be 400 for User Registration with Empty Full Name")
    public void Responsecode400RegistrationEmptyFullName(){
        register.Responsecode400RegistrationEmptyFullName();
    }
    @Then("I received a error message for Registration with Empty Full Name")
    public void ReceivedErrorMessageRegistrationEmptyFullName(){
        register.ReceivedErrorMessageRegistrationEmptyFullName();
    }


////  Verify User Registration with Special Characters in Full Name
//    @Given("I set endpoints for User Registration with Special Characters in Full Name")
//    public void SetEndpointsRegistrationSpecialCharactersFullName(){
//        register.SetEndpointsRegistrationSpecialCharactersFullName();
//    }
//    @When("I register with a full name that contains special characters")
//    public void RegisterWithFullNameSpecialCharacters(){
//        register.RegisterWithFullNameSpecialCharacters();
//    }
//    @And("the response status code should be 400 For Registration with Special Characters in Full Name")
//    public void Responsecode400RegistrationSpecialCharactersFullName(){
//        register.Responsecode400RegistrationSpecialCharactersFullName();
//    }
//    @Then("I received a error message for Registration with Special Characters in Full Name")
//    public void ReceivedErrorMessageRegistrationWithSpecialCharactersFullName(){
//        register.ReceivedErrorMessageRegistrationWithSpecialCharactersFullName();
//    }
//
//
////  Verify User Registration with Spaces in password
//    @Given("I set endpoints for User Registration with Spaces in password")
//    public void SetEndpointsRegistrationWithSpacesInPassword(){
//        register.SetEndpointsRegistrationWithSpacesInPassword();
//    }
//    @When("I registered a password with spaces")
//    public void RegisteredPasswordWithSpaces(){
//        register.RegisteredPasswordWithSpaces();
//    }
//    @And("the response status code should be 400 for Registration with Spaces in password")
//    public void Responsecode400RegistrationSpacesPassword(){
//        register.Responsecode400RegistrationSpacesPassword();
//    }
//    @Then("I received a error message for Registration with Spaces in password")
//    public void ReceivedErrorMessageRegistrationSpacesPassword(){
//        register.ReceivedErrorMessageRegistrationSpacesPassword();
//    }
//
//
////  Verify User Registration with Invalid Email Format
//    @Given("I set endpoints for User Registration with Special Characters in Email")
//    public void SetEndpointsRegistrationWithInvalidEmailFormat(){
//        register.SetEndpointsRegistrationWithInvalidEmailFormat();
//    }
//    @When("I register with Special Characters in Email")
//    public void RegisterInvalidEmailFormat(){
//        register.RegisterInvalidEmailFormat();
//    }
//    @And("the response status code should be 400 for Registration with Special Characters in Email")
//    public void Responsecode400RegistrationInvalidEmailFormat(){
//        register.Responsecode400RegistrationInvalidEmailFormat();
//    }
//    @Then("I received a error message for Registration with Special Characters in Email")
//    public void ReceivedErrorMessageRegistrationInvalidEmailFormat(){
//        register.ReceivedErrorMessageRegistrationInvalidEmailFormat();
//    }


    //  Verify User Registration with Special Characters in password
    @Given("I set endpoints for Registration with Special Characters in password")
    public void SetEndpointsRegistrationSpecialCharactersPassword(){
        register.SetEndpointsRegistrationSpecialCharactersPassword();
    }
    @When("I Registration with Special Characters in a password")
    public void RegistrationWithSpecialCharactersPassword(){
        register.RegistrationWithSpecialCharactersPassword();
    }
    @And("the response status code should be 200 for User Registration with Special Characters in password")
    public void Responsecode200RegistrationSpecialCharactersPassword(){
        register.Responsecode200RegistrationSpecialCharactersPassword();
    }
    @Then("I received a user Id")
    public void IReceiveduserId(){
        register.IReceiveduserId();
    }



    //  Login
//  Successful User Login
    @Given("I set endpoints for Successful User Login")
    public void SetEndpointsforSuccessfulUserLogin(){
        login.SetEndpointsforSuccessfulUserLogin();
    }
    @When("I login with valid credentials")
    public void LoginWithValidCredentials(){
        login.LoginWithValidCredentials();
    }
    @And("the response status code should be 200 for Successful User Login")
    public void Responsecode200SuccessfulUserLogin(){
        login.Responsecode200SuccessfulUserLogin();
    }
    @Then("I received a data")
    public void ReceivedData(){
        login.ReceivedData();
    }


    //  User Login with Unregistered Email
    @Given("I set endpoints for Login with Unregistered Email")
    public void SetEndpointsLoginUnregisteredEmail(){
        login.SetEndpointsLoginUnregisteredEmail();
    }
    @When("I login with an unregistered email")
    public void LoginWithUnregisteredEmail(){
        login.LoginWithUnregisteredEmail();
    }
    @And("the response status code should be 400 for Login with Unregistered Email")
    public void Responsecode400LoginWithUnregisteredEmail(){
        login.Responsecode400LoginWithUnregisteredEmail();
    }
    @Then("I received a error message for unregistered email")
    public void ReceivedErrorMessageUnregisteredEmail(){
        login.ReceivedErrorMessageUnregisteredEmail();
    }


    //  User Login with Incorrect Password
    @Given("I set endpoints for Login with Incorrect Password")
    public void SetEndpointsLoginWithIncorrectPassword(){
        login.SetEndpointsLoginWithIncorrectPassword();
    }
    @When("I login with an incorrect password")
    public void LoginWithIncorrectPassword(){
        login.LoginWithIncorrectPassword();
    }
    @And("the response status code should be 400 for Login with Incorrect Password")
    public void Responsecode400LoginWithIncorrectPassword(){
        login.Responsecode400LoginWithIncorrectPassword();
    }
    @Then("I received a error message for incorrect password")
    public void ReceivedErrorMessageIncorrectPassword(){
        login.ReceivedErrorMessageIncorrectPassword();
    }


    //  User Login with Empty Email
    @Given("I set endpoints for Login with Empty Email")
    public void SetEndpointsLoginWithEmptyEmail(){
        login.SetEndpointsLoginWithEmptyEmail();
    }
    @When("I login with an empty email")
    public void LoginWithEmptyEmail(){
        login.LoginWithEmptyEmail();
    }
    @And("the response status code should be 400 for Login with Empty Email")
    public void Responsecode400LoginwithEmptyEmail(){
        login.Responsecode400LoginwithEmptyEmail();
    }
    @Then("I received a error message for empty email")
    public void ReceivedErrorMessageEmptyEmail(){
        login.ReceivedErrorMessageEmptyEmail();
    }


    //  Verify User Login with Empty Password
    @Given("I set endpoints for Login with Empty Password")
    public void SetEndpointsLoginWithEmptyPassword(){
        login.SetEndpointsLoginWithEmptyPassword();
    }
    @When("I login with an empty password")
    public void LoginWithEmptyPassword(){
        login.LoginWithEmptyPassword();
    }
    @And("the response status code should be 400 for Login with Empty Password")
    public void Responsecode400LoginWithEmptyPassword(){
        login.Responsecode400LoginwithEmptyPassword();
    }
    @Then("I received a error message for empty password")
    public void ReceivedErrorMessageEmptyPassword(){
        login.ReceivedErrorMessageEmptyPassword();
    }


////  Verify User Login with only Spaces in email
//    @Given("I set endpoints for Login with Spaces in email")
//    public void SetEndpointsLoginWithSpacesInEmail(){
//        login.SetEndpointsLoginWithSpacesInEmail();
//    }
//    @When("I fill in the email with spaces")
//    public void FillInEmailWithSpaces(){
//        login.FillInEmailWithSpaces();
//    }
//    @And("the response status code should be 400 for Login with Spaces in email")
//    public void Responsecode400LoginSpacesEmail(){
//        login.Responsecode400LoginSpacesEmail();
//    }
//    @Then("I received a error message for Login with Spaces in email")
//    public void ReceivedErrorMessageLoginWithSpacesEmail(){
//        login.ReceivedErrorMessageLoginWithSpacesEmail();
//    }
//
//
////  Verify User Login with Spaces in password
//    @Given("I set endpoints for Login with Spaces in password")
//    public void SetEndpointsLoginWithSpacesPassword(){
//        login.SetEndpointsLoginWithSpacesPassword();
//    }
//    @When("I fill in the password with spaces")
//    public void FillPasswordWithSpaces(){
//        login.FillPasswordWithSpaces();
//    }
//    @And("the response status code should be 400 for Login with Spaces in password")
//    public void responsecode400LoginSpacespassword(){
//        login.responsecode400LoginSpacespassword();
//    }
//    @Then("I received a error message for Login with Spaces in password")
//    public void ReceivedErrorMessageLoginWithSpacesPassword(){
//        login.ReceivedErrorMessageLoginWithSpacesPassword();
//    }
//
//
////  Verify User Login with Only Special Characters in Email
//    @Given("I set endpoints for Login with Special Characters in Email")
//    public void SetEndpointsLoginSpecialCharactersEmail(){
//        login.SetEndpointsLoginSpecialCharactersEmail();
//    }
//    @When("I login with a Email with Special Characters")
//    public void LoginWithEmailSpecialCharacters(){
//        login.LoginWithEmailSpecialCharacters();
//    }
//    @And("the response status code should be 400 for Login with Special Characters in Email")
//    public void Responsecode400LoginSpecialCharacters(){
//        login.Responsecode400LoginSpecialCharacters();
//    }
//    @Then("I received a error message for Login with Special Characters in Email")
//    public void ReceivedErrorMessageLoginSpecialCharactersEmail(){
//        login.ReceivedErrorMessageLoginSpecialCharactersEmail();
//    }


    //  Verify User Login with Special Characters in Password
    @Given("I set endpoints for Login with Special Characters in Password")
    public void SetEndpointsLoginWithSpecialCharactersPassword(){
        login.SetEndpointsLoginWithSpecialCharactersPassword();
    }
    @When("I login with Special Characters in a password")
    public void LoginSpecialCharactersPassword(){
        login.LoginSpecialCharactersPassword();
    }
    @And("the response status code should be 200 for Login with Special Characters in Password")
    public void Responsecode200LoginSpecialCharactersPassword(){
        login.Responsecode200LoginSpecialCharactersPassword();
    }
    @Then("I received a error message for Login with Special Characters in Password")
    public void ReceivedErrorMessageLoginSpecialCharactersPassword(){
        login.ReceivedErrorMessageLoginSpecialCharactersPassword();
    }


    //  Verify User Login with Fill in email with valid password, and Fill in password with valid email
    @Given("I set endpoints for Login with Fill in email with valid password, and Fill in password with valid email")
    public void SetEndpointsLoginFillEmailWithValidPasswordFillPasswordWithValidEmail(){
        login.SetEndpointsLoginFillEmailWithValidPasswordFillPasswordWithValidEmail();
    }
    @When("I login with Fill in email with valid password, and Fill in password with valid email")
    public void LoginFillEmailValidPasswordFillPasswordWithValidEmail(){
        login.LoginFillEmailValidPasswordFillPasswordWithValidEmail();
    }
    @And("the response status code should be 400 for Login with Fill in email with valid password, and Fill in password with valid email")
    public void Responsecode400ForLoginFillEmailValidPasswordFillPasswordWithValidEmail(){
        login.Responsecode400ForLoginFillEmailValidPasswordFillPasswordWithValidEmail();
    }
    @Then("I received a error message for for Login with Fill in email with valid password, and Fill in password with valid email")
    public void ReceivedErrorMessageForLoginFillEmailValidPasswordFillPasswordWithValidEmail(){
        login.ReceivedErrorMessageForLoginFillEmailValidPasswordFillPasswordWithValidEmail();
    }



    //  Get User Information
//  Successfully Get User Information
    @Given("I set endpoints for Successfully Get User Information")
    public void SetEndpointsSuccessfullyGetUserInformation(){
        getUser.SetEndpointsSuccessfullyGetUserInformation();
    }
    @When("a valid bearer token is provided")
    public void ValidBearerTokenProvided(){
        getUser.ValidBearerTokenProvided();
    }
    @And("I request user information with valid credentials")
    public void RequestUserinformationwithValidCredentials(){
        getUser.RequestUserinformationwithValidCredentials();
    }
    @And("the response code should be 200 for Successfully Get User Information")
    public void Responsecode200SuccessfullyGetUserInformation(){
        getUser.Responsecode200SuccessfullyGetUserInformation();
    }
    @Then("I received the correct user details")
    public void ReceivedCorrectUserDetails(){
        getUser.ReceivedCorrectUserDetails();
    }


    //  Verify Get User Information with Invalid Token
    @Given("I set endpoints for Get User Information with Invalid Token")
    public void SetEndpointsGetUserInformationInvalidToken(){
        getUser.SetEndpointsGetUserInformationInvalidToken();
    }
    @When("an invalid bearer token is provided")
    public void InvalidBearerTokenProvided(){
        getUser.InvalidBearerTokenProvided();
    }
    @And("I request user information with an invalid token")
    public void RequestUserInformationWithInvalidToken(){
        getUser.RequestUserInformationWithInvalidToken();;
    }
    @And("the response code should be 401 for Get User Information with Invalid Token")
    public void Responsecode401GetUserInformationInvalidToke(){
        getUser.Responsecode401GetUserInformationInvalidToke();
    }
    @Then("I received a error message for invalid token")
    public void ReceivedErrorMessageInvalidToken(){
        getUser.ReceivedErrorMessageInvalidToken();
    }

    //  Verify Get User Information without Token
    @Given("I set endpoints for Get User Information without Token")
    public void SetEndpointsGetUserInformationWithoutToken(){
        getUser.SetEndpointsGetUserInformationWithoutToken();
    }
    @When("no bearer token is provided")
    public void NoBearerTokenProvided(){
        getUser.NoBearerTokenProvided();
    }
    @And("I request user information without a token")
    public void RequestUserInformationWithoutToken(){
        getUser.RequestUserInformationWithoutToken();
    }
    @And("the response status code should be 401 for Get User Information without Token")
    public void Responsecode401GetUserInformationWithoutToken(){
        getUser.Responsecode401GetUserInformationWithoutToken();
    }
    @Then("I received a error message for invalid token a error message for missing token")
    public void ReceivedErrorMessageMissingToken(){
        getUser.ReceivedErrorMessageMissingToken();
    }

    //  Orders
//  Create a new order
//  TC23 Verify Successfully Create a new order
    @Given("I set endpoints for Successfully Create a new order")
    public void SetEndpointsToCreateaNewOrder(){
        createNewOrder.SetEndpointsToCreateaNewOrder();
    }
    @When("a valid bearer token is Provided")
    public void validbearertokenisProvided(){
        createNewOrder.validbearertokenisProvided();
    }
    @And("I Send HTTP Request for Create a new order")
    public void SendHTTPRequestforCreateneworder(){
        createNewOrder.sendHTTPRequestforCreateNewOrder();
    }
    @And("the response code should be 200 for Successfully Create a new order")
    public void Responsecode200CreateaNewOrder() {
        createNewOrder.Responsecode200CreateaNewOrder();
    }
    @Then("I received the correct user data")
    public void ReceivedTheCorrectUserData(){
        createNewOrder.ReceivedTheCorrectUserData();
    }

    //  TC24 Verify Create a new order with Invalid Token
    @Given("I set endpoints for Create a new order with Invalid Token")
    public void SetEndpointsToCreateaNewOrderwithInvalidToken(){
        createNewOrder.SetEndpointsToCreateaNewOrderwithInvalidToken();
    }
    @When("an invalid bearer Token is provided")
    public void InvalidbearertokenisProvided(){
        createNewOrder.InvalidbearertokenisProvided();
    }
    @And("I Send HTTP Request for Create a new order with Invalid Token")
    public void SendHTTPRequestforCreateneworderWithInvalidToken(){
        createNewOrder.SendHTTPRequestforCreateneworderWithInvalidToken();
    }
    @And("the response code should be 401 for Create a new order with Invalid Token")
    public void Responsecode401CreateaNewOrderWithInvalidToken() {
        createNewOrder.Responsecode401CreateaNewOrderWithInvalidToken();
    }
    @Then("I received a error message for Invalid token")
    public void ReceivedErrorMessageWithInvalidToken(){
        createNewOrder.ReceivedErrorMessageWithInvalidToken();
    }

    //  TC25 Verify Create a new order without Token
    @Given("I set endpoints for Create a new order without Token")
    public void SetEndpointsToCreateaNewOrderWithoutToken(){
        createNewOrder.SetEndpointsToCreateaNewOrderWithoutToken();
    }
    @When("no bearer Token is provided")
    public void NobearerTokenisProvided(){
        createNewOrder.NobearerTokenisProvided();
    }
    @And("I Send HTTP Request for Create a new order without Token")
    public void SendHTTPRequestforCreateneworderWithoutToken(){
        createNewOrder.SendHTTPRequestforCreateneworderWithoutToken();
    }
    @And("the response status code should be 401 for Create a new order without Token")
    public void Responsecode401CreateaNewOrderWithoutToken() {
        createNewOrder.Responsecode401CreateaNewOrderWithoutToken();
    }
    @Then("I received a error message for invalid Token a error message for missing token")
    public void ReceivederrorMessageMissingToken(){
        createNewOrder.ReceivederrorMessageMissingToken();
    }


    //  Get all orders
//  TC26 Verify Successfully Get all orders
    @Given("I set endpoints for Successfully Get all orders")
    public void SetEndpointsGetAllOrders(){
        getAllOrders.SetEndpointsGetAllOrders();
    }
    @When("a valid Bearer Token is provided")
    public void ValidbearerTokenisProvided(){
        getAllOrders.ValidbearerTokenisProvided();
    }
    @And("I request all orders with valid credentials")
    public void RequestAllOrdersWithValidCredentials(){
        getAllOrders.RequestAllOrdersWithValidCredentials();
    }
    @And("the response code should be 200 for Successfully Get all orders")
    public void Responsecode200GetAllOrders() {
        getAllOrders.Responsecode200GetAllOrders();
    }
    @Then("I received the correct all orders")
    public void ReceiveCorrectAllOrders(){
        getAllOrders.ReceiveCorrectAllOrders();
    }


    //  TC27 Verify Get all orders with Invalid Token
    @Given("I set endpoints for Get all orders with Invalid Token")
    public void SetEndpointsGetAllOrdersWithInvalidToken(){
        getAllOrders.SetEndpointsGetAllOrdersWithInvalidToken();
    }
    @When("an invalid Bearer Token is provided")
    public void InvalidbearerTokenisProvided(){
        getAllOrders.InvalidbearerTokenisProvided();
    }
    @And("I request all orders with an invalid token")
    public void RequestAllOrderswithaninvalidtoken(){
        getAllOrders.RequestAllOrderswitinvalidtoken();
    }
    @And("the response code should be 401 for Get all orders with Invalid Token")
    public void Responsecode401GetAllOrderInvalidToken() {
        getAllOrders.Responsecode401GetAllOrderInvalidToken();
    }
    @Then("I received a error message for invalid Token")
    public void ReceiveCorrectAllOrdersInvalidToken(){
        getAllOrders.ReceiveCorrectAllOrdersInvalidToken();
    }

    //  TC28 Verify Get all orders without Token
    @Given("I set endpoints for Get all orders without Token")
    public void SetEndpointsGetAllOrdersWithwithoutToken(){
        getAllOrders.SetEndpointsGetAllOrdersWithwithoutToken();
    }
    @When("no Bearer Token is provided")
    public void noBearerTokenisprovided(){
        getAllOrders.noBearerTokenisprovided();
    }
    @And("I request all orders without a token")
    public void RequestAllOrdersWithoutAtoken(){
        getAllOrders.RequestAllOrdersWithoutAtoken();
    }
    @And("the response status code should be 401 for Get all orders without Token")
    public void Responsecode401GetAllOrderswithoutToken() {
        getAllOrders.Responsecode401GetAllOrderswithoutToken();
    }
    @Then("I received a error message for invalid token a error message for missing Token")
    public void ReceiveCorrectAllOrdersmissingToken(){
        getAllOrders.ReceiveCorrectAllOrdersmissingToken();
    }


    //  Get order by ID
//  TC29 Verify Successfully Get orders By ID
    @Given("I set endpoints for Successfully Get orders by ID")
    public void SetEndpointsGetGetOrdersByID(){
        getOrderByID.SetEndpointsGetGetOrdersByID();
    }
    @When("a Valid Bearer Token is provided")
    public void validBearerTokenisprovided(){
        getOrderByID.validBearerTokenisprovided();
    }
    @And("I request orders By ID with valid credentials")
    public void RequestOrdersByIDWithAtoken(){
        getOrderByID.RequestOrdersByIDWithAtoken();
    }
    @And("the response code should be 200 for Successfully Get orders By ID")
    public void Responsecode200GetOrderByIDswithToken() {
        getOrderByID.Responsecode200GetOrderByIDswithToken();
    }
    @Then("I received the correct orders By ID")
    public void ReceiveCorrectOrdersByIDWithToken(){
        getOrderByID.ReceiveCorrectOrdersByID();
    }

    //  TC30 Verify Get orders by ID with Invalid Token
    @Given("I set endpoints for Get orders by ID with Invalid Token")
    public void SetEndpointsGetGetOrdersByIDWithInvalidToken(){
        getOrderByID.SetEndpointsGetGetOrdersByIDWithInvalidToken();
    }
    @When("an Invalid Bearer Token is provided")
    public void invalidBearerTokenisprovided(){
        getOrderByID.invalidBearerTokenisprovided();
    }
    @And("I request orders by ID with an invalid token")
    public void RequestOrdersByIDWithAInvalidtoken(){
        getOrderByID.RequestOrdersByIDWithAInvalidtoken();
    }
    @And("the response code should be 401 for Get orders by ID with Invalid Token")
    public void Responsecode401GetOrderByIDWithInvalidToken() {
        getOrderByID.Responsecode401GetOrderByIDWithInvalidToken();
    }
    @Then("I Received a error message for invalid Token")
    public void ReceivedErrorMessageForInvalidToken(){
        getOrderByID.ReceivedErrorMessageForInvalidToken();
    }

    //  TC31 Verify Get orders by ID without Token
    @Given("I set endpoints for Get orders by ID without Token")
    public void SetEndpointsGetGetOrdersByIDWithoutToken(){
        getOrderByID.SetEndpointsGetGetOrdersByIDWithoutToken();
    }
    @When("No Bearer Token is provided")
    public void NoBearerTokenisprovided(){
        getOrderByID.NoBearerTokenisprovided();
    }
    @And("I request orders by ID without a token")
    public void RequestOrdersbyIDWithoutToken(){
        getOrderByID.RequestOrdersbyIDWithoutToken();
    }
    @And("the response status code should be 401 for Get orders by ID without Token")
    public void Responsecode401GetOrderByIDwithoutToken() {
        getOrderByID.Responsecode401GetOrderByIDwithoutToken();
    }
    @Then("I Received a error message for invalid token a error message for missing Token")
    public void ReceivedErrorMessageFormissingToken(){
        getOrderByID.ReceivedErrorMessageFormissingToken();
    }
}