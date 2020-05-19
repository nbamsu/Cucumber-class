package API.ApacheHttpClient;

import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeserializationAPICharacters {
    @Test
    public void getNames() throws URISyntaxException, IOException {


    HttpClient httpClient = HttpClientBuilder.create().build();
    URIBuilder uriBuilder = new URIBuilder();
    uriBuilder.setScheme("https")
            .setHost("breakingbadapi.com")
            .setPath("api/characters");
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");
        HttpResponse response=httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper=new ObjectMapper();

        List<Map<String,Object>> listUrl=objectMapper.readValue(response.getEntity().getContent(),new TypeReference<List<Map<String,Object>>>(){});

        List<String> names= new ArrayList<>();

        for (Map<String,Object>map:listUrl) {
            names.add((String)map.get("name"));

        }
        //System.out.println(names);
        int count=0;
        for(int i=0;i<listUrl.size();i++){
            if(listUrl.get(i).get("status").equals("Alive")){
                //System.out.println(listUrl.get(i).get("name"));
                count++;
            }

    }
        System.out.println(count);


       for (Map<String, Object> age2:listUrl)
           names.add((String)age2.get("birthday"));
            System.out.println(names);

       }

}

