package API.ApacheHttpClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class Delete_Verify {
    @Test
    public void verifyDeletedPet() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/9");

        //construc menthod
        HttpDelete delete=new HttpDelete(uriBuilder.build());
        delete.setHeader("Accept","application/json");

        HttpResponse response=httpClient.execute(delete);
        ObjectMapper objectMapper=new ObjectMapper();
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getStatusCode());

        Map<String,Object> deleteStatus=objectMapper.readValue(response.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});

        Assert.assertEquals("9",deleteStatus.get("message"));

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        HttpResponse response2=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND,response2.getStatusLine().getStatusCode());
        System.out.println(response2.getStatusLine().getStatusCode());
    }
}
