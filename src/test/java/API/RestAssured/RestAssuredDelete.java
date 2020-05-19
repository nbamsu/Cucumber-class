package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssuredDelete {
    @Test
    public void deletePet() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        Response response = when().delete("/123456789");
        response.then().statusCode(200);
    }

    @Test
    public void deletePet2() {
        RestAssured.baseURI = "https://petstore.swagger.io";
       RestAssured.basePath = "v2/pet/123456789";
        when().request("DELETE","/{petId}",123456789).then().statusCode(404);
    }
    @Test
    public void createPetFirstMethod(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/store/order";
        String reqBody="{\n" +
                "  \"date\": {\n" +
                "    \"id\": 321123,\n" +
                "    \"email\": \"ponyLend@gmail.com\",\n" +
                "    \"first_name\": \"Ratatui\",\n" +
                "    \"last_name\": \"Pony\",\n" +
                "    \"avatar\": \"https://www.google.com/search?q=funny+pony+smile&tbm=isch&ved=2ahUKEwj6t6Px87boAhVNPawKHTNBAQcQ2-cCegQIABAA&oq=funny+pony+smile&gs_l=img.3...131697.135615..135815...0.0..0.101.1181.15j1......0....1..gws-wiz-img.......35i39j0i67j0j0i8i30j0i24.HW5CatQZLNI&ei=Lfp7XrrtHs36sAWzgoU4&bih=754&biw=1536&rlz=1C1CHBF_enUS770US770#imgrc=raQMbZjkEi8qAM\"\n" +
                "  },\n" +
                "  \"ad\": {\n" +
                "    \"company\": \"HorsePower\",\n" +
                "    \"url\": \"https://www.google.com/search?q=horse&newwindow=1&rlz=1C1CHBF_enUS770US770&sxsrf=ALeKk01qA941ZSfCueuL0zUvRgul2VW3vw:1585183271002&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjRlpbu87boAhUNa80KHWlgAv8Q_AUoAXoECBoQAw&biw=1536&bih=754#imgrc=Tv8N3Ti_yNyyQM\",\n" +
                "    \"text\": \"Be strong as Horse\"\n" +
                "  }\n" +
                "}";


        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(reqBody)
                .when().post();
        response.then().statusCode(200).and().body("date.first_name", Matchers.is("Ratatui"));
    }
    @Test
    public void createPetSecondMethod(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

    }
}
