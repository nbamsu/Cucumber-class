package API.stepDefs;

import API.utils.PayloadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

public class CreatePetStepDefs {

    private HttpResponse response;
    private String appJson;
    private int petId;
    private URIBuilder uriBuilder;
    private HttpClient httpClient;
    private static final String NAME="name";
    private static final String ID="id";
    private static final String HTTPS="https";



    @When("user {string} a pet with id {int}")
    public void user_creates_a_pet(String method,Integer petId) throws URISyntaxException, IOException {
        this.petId = petId;
        httpClient = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme(HTTPS)
                .setHost("petstore.swagger.io");
        if (method.equalsIgnoreCase("creates")) {
            uriBuilder.setPath("v2/pet");

            Properties properties = new Properties();

            properties.load(new FileInputStream(new File("configuration.properties")));
            appJson = properties.getProperty("json");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.addHeader("Accept", appJson);
            httpPost.addHeader("Content-Type", appJson);

            // int petid = 96369;
            String requestBody = PayloadUtil.getPetPayload(petId);

            HttpEntity entity = new StringEntity(requestBody);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
        }else if (method.equalsIgnoreCase("deletes")){

                    uriBuilder.setPath("v2/pet/"+petId);

            //construc menthod
            HttpDelete delete=new HttpDelete(uriBuilder.build());
            delete.setHeader("Accept","application/json");

            response=httpClient.execute(delete);
        }
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(appJson));

    }

    @Then("pet is {string}")
    public void pet_is_created(String method) throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> petDetails = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Assert.assertEquals(petId, petDetails.get(ID));
        Assert.assertEquals("Pony", petDetails.get(NAME));

        Map<String, Object> url = (Map<String, Object>) petDetails.get("category");

        Assert.assertEquals("Bomba", url.get(NAME));
        System.out.println(url.get(NAME));

        uriBuilder.setPath("v2/pet"+petId);

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        HttpResponse response1=httpClient.execute(httpGet);

        //Map<String,Object> getPetdetails= objectMapper.readValue(response1.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});

        Assert.assertEquals(petId,petDetails.get(ID));
        Assert.assertEquals("Pony",petDetails.get(NAME));

    }






//
//    @Then("pet is {string}")
//    public void pet_is(String action) throws IOException, URISyntaxException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        if (action.equalsIgnoreCase("created")) {
//            uriBuilder.setPath("v2/pet/" + petId);
//            HttpGet get = new HttpGet(uriBuilder.build());
//            response = httpClient.execute(get);
//            Map<String, Object> getPettDetails = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>(){});
//
//            Assert.assertEquals(petId, getPettDetails.get(ID));
//            Assert.assertEquals("Bomjik", getPettDetails.get(NAME));
//
//        } else if (action.equalsIgnoreCase("deleted")) {
//            HttpGet get = new HttpGet(uriBuilder.build());
//            response = httpClient.execute(get);
//            Map<String, Object> petDetails = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>(){});
//            Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusLine().getStatusCode());
//            Assert.assertEquals("Pet not found", petDetails.get("message"));
//        }


    }
