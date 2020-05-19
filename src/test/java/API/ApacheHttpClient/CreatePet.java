package API.ApacheHttpClient;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreatePet {
    @Test
    public void createPet() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/9");
        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept","application/json");
        HttpResponse response=httpClient.execute(httpPost);


}
}
