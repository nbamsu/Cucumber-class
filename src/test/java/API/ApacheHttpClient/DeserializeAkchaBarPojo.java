package API.ApacheHttpClient;




import API.POJO.AkchaBarPojo;
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

public class DeserializeAkchaBarPojo {
    @Test
    public void getMoney() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                .setHost("rates.akchabar.kg")
                .setPath("get.json");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));

        ObjectMapper objectMapper = new ObjectMapper();
        AkchaBarPojo akchaBarPojo=objectMapper.readValue(response.getEntity().getContent(), AkchaBarPojo.class);

        System.out.println(akchaBarPojo.getRates().getUsd());
        System.out.println(akchaBarPojo.getRates().getEuro());
        System.out.println(akchaBarPojo.getRates().getRuble());
        System.out.println(akchaBarPojo.getRates().getTenge());
        System.out.println(akchaBarPojo.getRates().getBtc());



        Assert.assertEquals("82.2000",akchaBarPojo.getRates().getUsd());
        Assert.assertEquals("90.2474",akchaBarPojo.getRates().getEuro());
        Assert.assertEquals("1.0437",akchaBarPojo.getRates().getRuble());
        Assert.assertEquals("0.1836",akchaBarPojo.getRates().getTenge());
        Assert.assertEquals("531790.434",akchaBarPojo.getRates().getBtc());


    }
}