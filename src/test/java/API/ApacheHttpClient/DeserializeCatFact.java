package API.ApacheHttpClient;

import API.POJO.All;
import API.POJO.CatFact2500Pojo;
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

public class DeserializeCatFact {
    @Test
    public void allUsers() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("cat-fact.herokuapp.com")
                .setPath("facts");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper=new ObjectMapper();
       CatFact2500Pojo catFact2500Pojo=objectMapper.readValue(response.getEntity().getContent(),CatFact2500Pojo.class);
        List<All> list=catFact2500Pojo.getAll();
        System.out.println(list.size());



    }
}
