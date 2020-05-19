package API.ApacheHttpClient;

import API.utils.PayloadConvertUtil;
import API.utils.PayloadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class PostLogIn {

@Test
    public void logIn() throws URISyntaxException, IOException {
    HttpClient httpClient= HttpClientBuilder.create().build();
    URIBuilder uriBuilder=new URIBuilder();
    uriBuilder.setScheme("https")
            .setHost("reqres.in")
            .setPath("api/login");
    HttpPost httpPost=new HttpPost(uriBuilder.build());
    httpPost.addHeader("Accept","application/json");
   // httpPost.addHeader("Content-Type","application/json");

    String reqBody= PayloadConvertUtil.generatStringFromResource
            ("src/test/java/API/utils/AuthorizationPayload.json");

    HttpEntity entity=new StringEntity(reqBody, ContentType.APPLICATION_JSON);
    httpPost.setEntity(entity);
    HttpResponse response;
    try {
        response=httpClient.execute(httpPost);
    }catch (IOException e){
        e.getStackTrace();
        throw new RuntimeException();
    }
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

    ObjectMapper objectMapper=new ObjectMapper();
    Map<String, String> token=objectMapper.readValue(response.getEntity().getContent(),
            new TypeReference<Map<String,String>>(){});

    Assert.assertNotNull(token.containsKey("token"));


}

}
