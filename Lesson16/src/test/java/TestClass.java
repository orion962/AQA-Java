import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestClass {
    @BeforeEach
    public void start() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void get() {
        Response response = RestAssured
                .given().param("foo1", "bar1")
                .param("foo2", "bar2").when().get("/get")
                .then().statusCode(200).contentType(ContentType.JSON)
                .body("args.foo1", equalTo("bar1")).body("args.foo2", equalTo("bar2"))
                .extract().response();
        response.prettyPrint();
    }

    @Test
    public void post() {
        Response response = RestAssured
                .given().contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", "bar1").formParam("foo2", "bar2")
                .post("/post").then().statusCode(200)
                .body("form.foo1", equalTo("bar1")).body("form.foo2", equalTo("bar2"))
                .extract().response();
        response.prettyPrint();
    }
}
