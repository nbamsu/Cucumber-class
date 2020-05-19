package API.JiraAPI;

import API.utils.PayloadUtil;
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

import java.io.IOException;
import java.net.URISyntaxException;

import static API.utils.Constants.MEDIUM_PRIORITY;
import static API.utils.Constants.STORY;

public class JiraHTML {
    public static final String COOKIE="JSESSIONID=694D5AF17A10E0A60B2CBDC95F1FEEAB";
    @Test
    public void createMethodHTML() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("http").setHost("localhost:8080").setPath("rest/api/2/issue");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.addHeader("Accept","application/json");
        httpPost.addHeader("Cookie","JSESSIONID=E721DF27BABD9E44349E3D01F75A947F");
        httpPost.addHeader("Content-Type","application/json");
        HttpEntity entity=new StringEntity(PayloadUtil.getJiraIssuePayLoad("COVID19","Tropikanoboom","click on Menu button",
                "User should able to click on menu button and see the list",STORY,MEDIUM_PRIORITY,""));
        httpPost.setEntity(entity);
        HttpResponse response=httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

    }

    @Test
    public void createSprint() throws URISyntaxException, IOException {
    HttpClient httpClient=HttpClientBuilder.create().build();
    URIBuilder uriBuilder=new URIBuilder();
    uriBuilder.setScheme("http").setHost("localhost:8080").setPath("rest/agile/1.0/sprint");
    HttpPost httpPost=new HttpPost(uriBuilder.build());
    httpPost.addHeader("Accept","application/json");
    httpPost.addHeader("Cookie",COOKIE);
    httpPost.addHeader("Content-Type","application/json");
    HttpEntity entity=new StringEntity(PayloadUtil.createSprintBody("HttpSprint Name",
            "2020-04-20T19:00:00.000-05:00","2020-05-05T00:10:00.000-05:00","Try to create Sprint"));
    httpPost.setEntity(entity);
    HttpResponse response=httpClient.execute(httpPost);
    Assert.assertEquals(HttpStatus.SC_CREATED,response.getStatusLine().getStatusCode());
    Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

    }
}
