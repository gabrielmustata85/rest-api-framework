package tests.user;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.pojo.User;
import org.example.requests.SpecBuilders;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserTests {

    public static String response;

    @Test
    public void createUser() {

        RestAssured.given()
                .spec(SpecBuilders.request())
                .when()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"gabriel.mustata\",\n" +
                        "  \"firstName\": \"gabriel\",\n" +
                        "  \"lastName\": \"mustata\",\n" +
                        "  \"email\": \"test@test.com\",\n" +
                        "  \"password\": \"123\",\n" +
                        "  \"phone\": \"43535457657567\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .post("user")
                .then()
                .spec(SpecBuilders.response())
                .log().all();

    }

    @Test
    public void getUserByUserName() {


        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.given()
                .when()
                .get("user/gabriel.mustata")
                .then()
                .assertThat()
                .log().all()
                .extract().response().as(User.class);


//        JsonPath js = new JsonPath(response);
//
//        String username = js.get("username");
//        String firstname = js.get("firstName");
//
//        System.out.println(username);
//        System.out.println(firstname);
    }

    @Test
    public void getUserByUserName1() {


        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.given()
                .when()
                .get("user/gabriel.mustata")
                .then()
                .assertThat()
                .log().all();


//        JsonPath js = new JsonPath(response);
//
//        String username = js.get("username");
//        String firstname = js.get("firstName");
//
//        System.out.println(username);
//        System.out.println(firstname);
    }

    @Test
    public void updateUser() throws IOException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(new String(Files.readAllBytes(Paths.get("src/test/resources/payload.json"))))
                .put("user/gabriel.mustata")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void updateUser1() throws IOException {

        User user = new User();
        user.setUsername("test_user_name");
        user.setFirstName("test first");
        user.setLastName("test last");
        user.setEmail("test@test");
        user.setPassword("567");

        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(user)
                .put("user/gabriel.mustata")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
