package API.ApacheHttpClient;

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
    public static void main(String[] args) {
        String reverse = "WE WILL BE STRUGGLING A LOT. WE WON'T TELL ANYBODY A WORD";

        String reverseMe= reverse.substring(53).toLowerCase();
        int lastIndex=reverseMe.length()-1;
        String reversedWord = "";

        for(int n=0; n<=lastIndex; lastIndex--) {

            reversedWord=reversedWord+reverseMe.charAt(lastIndex);
        }
        System.out.println(reversedWord);
    }
    @Test
    public void firstApiCall() throws URISyntaxException, IOException {
        // Construct our http CLint
        HttpClient httpClient = HttpClientBuilder.create().build();
        // build endpoint
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/112233");

        //Construct our Request
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        //execute a get request
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println("Status code check positive " + response.getStatusLine().getStatusCode());
        System.out.println("Second verification " + response.getEntity().getContentType().getValue());

        Assert.assertEquals("", HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertEquals("Invalid", "application/json", response.getEntity().getContentType().getValue());
    }

    @Test
    public void findByStatusPetStore() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")//https://reqres.in/
                .setPath("api/users")
                .setCustomQuery("page=2");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        //System.out.println(httpClient.execute(httpGet));
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response.getStatusLine().getStatusCode());
        int index = response.getEntity().getContentType().getValue().indexOf(" ");
        String form = response.getEntity().getContentType().getValue().substring(index + 1);

        // Assert.assertEquals("Accept","application/json; charset=utf-8",response.getEntity().getContentType().getValue());
        Assert.assertEquals(form, response.getEntity().getContentType().getValue().substring(index));
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

    }

    @Test
    public void petStoreId() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/id/2");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusLine().getStatusCode());

    }


}
