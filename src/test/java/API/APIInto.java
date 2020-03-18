package API;

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

public class APIInto {
    @Test
    public void firstApiCall() throws URISyntaxException, IOException {
        // Construct our http CLint
        HttpClient httpClient= HttpClientBuilder.create().build();
        // build endpoint
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/112233");

        //Construct our Request
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        //execute a get request
        HttpResponse response=httpClient.execute(httpGet);
        System.out.println("Status cod check "+response.getStatusLine().getStatusCode());
        Assert.assertEquals("", HttpStatus.SC_OK,response.getStatusLine().getStatusCode());


    }
}
