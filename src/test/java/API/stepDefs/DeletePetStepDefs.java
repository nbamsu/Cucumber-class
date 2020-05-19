package API.stepDefs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class DeletePetStepDefs {
    HttpClient   httpClient;
    URIBuilder   uriBuilder;
    HttpResponse response;
    int petId;
    @When("user deletes a pet with id {int}")
    public void user_deletes_a_pet_with_id(int petId) throws IOException, URISyntaxException {
        this.petId=petId;
        httpClient= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/9");

        //construc menthod
        HttpDelete delete=new HttpDelete(uriBuilder.build());
        delete.setHeader("Accept","application/json");

        response=httpClient.execute(delete);

    }

    @Then("pet is delete")
    public void pet_is_delete() throws URISyntaxException, IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getStatusCode());

        Map<String,Object> deleteStatus=objectMapper.readValue(response.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});

        Assert.assertEquals(java.lang.String.valueOf(petId),deleteStatus.get("message"));

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        HttpResponse response2=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND,response2.getStatusLine().getStatusCode());
        System.out.println(response2.getStatusLine().getStatusCode());

    }

}
