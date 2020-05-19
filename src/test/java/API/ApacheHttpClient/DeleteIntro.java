package API.ApacheHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class DeleteIntro {
    @Test
    public void deleteUser() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users/963");

        //construc menthod
        HttpDelete delete=new HttpDelete(uriBuilder.build());
        delete.setHeader("Accept","application/json");

        HttpResponse response=httpClient.execute(delete);
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT,response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getStatusCode());
        //773-814-2774 den wi-fi

        uriBuilder.setPath("api/users/963");
        HttpGet httpGet= new HttpGet(uriBuilder.build());
        HttpResponse response1=httpClient.execute(httpGet);

    }
}
