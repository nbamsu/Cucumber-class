package API.ApacheHttpClient;

import Pages.URLforPicsAPI.PicsPath;
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
import java.util.List;
import java.util.Map;

public class ReqResListOfUsersDeserialization {
    @Test
    public void getAllUsers() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users")
                .setCustomQuery("per_page=12");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserilized = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(deserilized.size());

        List<Object> listOfObject = (List<Object>) deserilized.get("data");

        System.out.println(deserilized.size());
        Assert.assertEquals(deserilized.get("per_page"), listOfObject.size());

        int count = 0;
        for (int i = 0; i < listOfObject.size(); i++) {
            if (listOfObject.get(i).toString().contains("id")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void getNames() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users")
                .setCustomQuery("per_page=12");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserilized = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(deserilized.size());
        //System.out.println(deserilized.get("data"));

        List<Object> listOfObject = (List<Object>) deserilized.get("data");

        Assert.assertEquals(deserilized.get("per_page"), listOfObject.size());
        int sum = 0;
        for (int i = 0; i < listOfObject.size(); i++) {
            Map<String, Object> userNames = (Map<String, Object>) listOfObject.get(i);
            System.out.println(userNames.get("first_name"));
            sum += (int) userNames.get("id");
        }
        System.out.println(sum);
    }


    @Test
    public void deserializationURLPics() throws URISyntaxException, IOException {
        PicsPath page=new PicsPath();
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users")
                .setCustomQuery("per_page=12");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType().getValue());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> urlPics = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Object> listOfObject = (List<Object>) urlPics.get("data");

        System.out.println(urlPics.size());
        Assert.assertEquals(urlPics.get("per_page"),listOfObject.size());
        for (int i=0;i<listOfObject.size();i++){
            Map<String,Object> allUrls=(Map<String,Object>)listOfObject.get(i);
            System.out.println(allUrls.get("avatar"));


            Assert.assertTrue(page.pic1.isDisplayed());

        }

    }
}
