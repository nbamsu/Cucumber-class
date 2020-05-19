package API.ApacheHttpClient;

import API.utils.PayloadUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

public class POSTIntro {
    @Test
    public void createPet() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet");

        Properties properties=new Properties();

        properties.load(new FileInputStream(new File("configuration.properties")));
        String appJson = properties.getProperty("json");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept",appJson);
        httpPost.addHeader("Content-Type",appJson);

        int petid=96369;
        String requestBody= PayloadUtil.getPetPayload(petid);

        HttpEntity entity=new StringEntity(requestBody);
        httpPost.setEntity(entity);

        HttpResponse response=httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(appJson));


        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,Object> petDetails=objectMapper.readValue(response.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});

        Assert.assertEquals(petid,petDetails.get("id"));
        Assert.assertEquals("Pony",petDetails.get("name"));

        Map<String,Object> url=(Map<String,Object>)petDetails.get("category");

        Assert.assertEquals("Bomba",url.get("name"));
        System.out.println(url.get("name"));




    }
}
