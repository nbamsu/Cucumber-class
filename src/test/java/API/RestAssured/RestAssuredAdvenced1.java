package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredAdvenced1 {
    @Before
    public void setUp(){
        RestAssured.baseURI="http://api.football-data.org";
        RestAssured.basePath="v2/competitions/2000/teams";
    }
    @Test
    public void getTeams(){


        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request("GET").then().statusCode(200).extract().response();

        //find()
        Map<String,Object> japan=response.path("teams.find {it.name =='Japan'}");
        Assert.assertEquals(japan.get("name"),"Japan");
        Map<String,Object> region=response.path("teams.find {it.id == '2169'}");

    }
    @Test
    public void getRegion(){
//        RestAssured.baseURI="http://api.football-data.org";
//        RestAssured.basePath="v2/competitions/2000/teams";

        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request("GET").then().statusCode(200).extract().response();
        //find
        Map<String,Object> region=response.path("teams.area.find {it.id == 2169}");
        System.out.println(region.get("name"));
    //data.forEach(f-> System.out.println(f.get("email")));
    }

    @Test
    public void getRegion2(){
//        RestAssured.baseURI="http://api.football-data.org";
//        RestAssured.basePath="v2/competitions/2000/teams";

        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request("GET").then().statusCode(200).extract().response();

        Map<String,Object> data=response.getBody().as(new TypeRef<Map<String, Object>>() {
        });
       List<Map<String, Object> >list=(List)data.get("teams");
        for(Map<String, Object> map:list){
            Map<String, Object>area=(Map<String, Object>)map.get("area");
            if ((int)area.get("area")==2169){
                System.out.println(map.get("name"));
            }
        }

    }
    @Test
    public void findAll(){
        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request(Method.GET).then().statusCode(200).extract().response();
        List<String>countryNames=response.path("teams.findAll{it.founded<1900}.name");
        System.out.println(countryNames);

    }
    @Test
    public void findCodeNumber(){
        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request(Method.GET).then().statusCode(200).extract().response();
        List<String>names=response.path("teams.findAll{it.name.startsWith('S')}.name");

        System.out.println(names);
    }



    @Test
    public void findMax(){
        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request(Method.GET).then().statusCode(200).extract().response();
        System.out.println(response.path("teams.max{it.id}.area.name").toString());
        System.out.println(response.path("teams.min{it.id}.area.name").toString());
    }

    @Test
    public void collect(){
        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request(Method.GET).then().statusCode(200).extract().response();

       int sumOfId= response.path("teams.collect{it.id}.sum()");
       List<String> names= response.path("teams.collect{it.name}");
        System.out.println(sumOfId);
        System.out.println(names);
    }

    @Test
public void website(){

        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request(Method.GET).then().statusCode(200).extract().response();

        int sumOfId= response.path("teams.collect{it.id ==2169}.sum()");
        List<String> names= response.path("teams.collect{it.website}");

        System.out.println(names);
    }
    @Test
    public void competitions(){

        Response response=given().accept(ContentType.JSON).header("X-Auth-Token","a82e659c8fad4376843b7fffc5f366d3")
                .when().request(Method.GET).then().statusCode(200).extract().response();
        Map<String,?>competition=response.path("competition");
        Map<String,?> area=(Map<String,?>)competition.get("area");
        System.out.println(area.get("name"));

    }
}
