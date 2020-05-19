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
import java.util.Map;

public class ReqResOneUserDeserialization {
    @Test
    public void reqresRequest() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users/2");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertTrue("Invalid content time", response.getEntity().getContentType().getValue().contains("application"));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserilizedObject = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(deserilizedObject.keySet());
        System.out.println(deserilizedObject.size());
        System.out.println(deserilizedObject.get("data"));


        Map<String, Object> dataValue = (Map<String, Object>) deserilizedObject.get("data");
        for (String str : dataValue.keySet()) {
            //System.out.println("User's " +str+" is " +dataValue.get(str));
            System.out.printf("User's %s is %s \n", str, dataValue.get(str));
        }

//        System.out.println("User's email is: " + dataValue.get("email"));
//        System.out.println("User's id is: " + dataValue.get("id"));
//        System.out.println("User's first name is: " + dataValue.get("first_name"));
//        System.out.println("User's last name is: " + dataValue.get("last_name"));
//        System.out.println("User's avatar located :" + dataValue.get("avatar"));

        Map<String, String> dataValue2 = (Map<String, String>) deserilizedObject.get("ad");
        System.out.println("Company name is: " + dataValue2.get("company"));

    }
}
