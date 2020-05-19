package API.ApacheHttpClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Randomdeserialization {
    @Test
    public void randomDeser() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("www.breakingbadapi.com")
                .setPath("api/character/random");
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        HttpResponse response=httpClient.execute(httpGet);
        System.out.println(response);

        ObjectMapper objectMapper=new ObjectMapper();
       List<String> listOfString= objectMapper.readValue(response.getEntity().getContent(),new TypeReference<List<String>>(){});


    }

}
