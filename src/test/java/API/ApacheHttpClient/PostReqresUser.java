package API.ApacheHttpClient;


import API.utils.PayloadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import com.fasterxml.jackson.core.type.TypeReference;
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

public class PostReqresUser {
    @Test
    public void createUser() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users");

        Properties properties=new Properties();
        properties.load(new FileInputStream(new File("configuration.properties")));
        String appJson=properties.getProperty("json");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept",appJson);
        httpPost.addHeader("Content-Type",appJson);

        String name="KOKO";
        String job="car";
        String requestBody = PayloadUtil.getUserPayload(name,job);

        HttpEntity entity=new StringEntity(requestBody);
        httpPost.setEntity(entity);

       HttpResponse response=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains(appJson));

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,String> userDetails=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,String>>(){});

               Assert.assertEquals(name,userDetails.get("name"));
        Assert.assertEquals(job,userDetails.get("job"));





    }
}
