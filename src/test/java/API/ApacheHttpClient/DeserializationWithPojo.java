package API.ApacheHttpClient;


import API.POJO.UserPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;


public class DeserializationWithPojo {
    @Test
    public void getUser() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users/5");
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        HttpResponse response=httpClient.execute(httpGet);


        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();
       UserPojo userPojo= objectMapper.readValue(response.getEntity().getContent(), UserPojo.class);
        System.out.println( userPojo.getData().getAvatar());
        System.out.println(userPojo.getAd().getCompany());


        Assert.assertEquals("Charles",userPojo.getData().getFirst_name());
        Assert.assertEquals("Morris",userPojo.getData().getLast_name());


    }
}
