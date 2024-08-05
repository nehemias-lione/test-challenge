package steps;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import models.ContactModel;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ApiSteps {


    private void config(){
        baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        authentication = oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NmE0MWU1YzE3N2QzZDAwMTNkYzVjNDAiLCJpYXQiOjE3MjIyMjI2NDF9.zpJaZQDtvlHfVBSq5yyhb-3kG0yv52cU7L-CAxYblNY");
    }

    public void getContact(ContactModel contac){
        config();
        get("/contacts")
                .then()
                .statusCode(200)
                .body("[0].firstName", equalTo(contac.getFirstName()))
                .body("[0].lastName", equalTo(contac.getLastName()))
                .body("[0].birthdate", equalTo(contac.getBirthDate()))
                .body("[0].email", equalTo(contac.getEmail()))
                .body("[0].phone", equalTo(contac.getPhone()))
                .body("[0].street1", equalTo(contac.getAddress1()))
                .body("[0].street2", equalTo(contac.getAddress2()))
                .body("[0].city", equalTo(contac.getCity()))
                .body("[0].stateProvince", equalTo(contac.getStateProvince()))
                .body("[0].postalCode", equalTo(contac.getPostalCode()))
                .body("[0].country", equalTo(contac.getCountry()))
                .extract().response();
    }

    public void emptyContactsList(){
        config();
        get("/contacts")
                .then()
                .statusCode(200)
                .body("", hasSize(0));
    }

}
