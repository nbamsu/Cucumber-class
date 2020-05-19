package API.ApacheHttpClient;

import API.POJO.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SerializationIntro {
    @Test
    public void SerializationInt() throws IOException {
        Rates rates=new Rates();
        rates.setBtc("10");
        rates.setEuro("50");
        rates.setRuble("5");
        rates.setUsd("25");
        rates.setTenge("2");
        System.out.println(rates.getEuro());
        System.out.println(rates.getBtc());
        System.out.println(rates.getTenge());

        //serialization to json object
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("rates.json");
        objectMapper.writeValue(file,rates);

    }

    @Test
    public void serializ() throws IOException {
        UserPojo userPojo=new UserPojo();
        Ad ad=new Ad();
        ad.setCompany("HorsePower");
        ad.setText("Be strong as Horse");
        ad.setUrl("https://www.google.com/search?q=horse&newwindow=1&rlz=1C1C" +
                "HBF_enUS770US770&sxsrf=ALeKk01qA941ZSfCueuL0zUvRgul2VW" +
                "3vw:1585183271002&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjRlpbu87boAhUN" +
                "a80KHWlgAv8Q_AUoAXoECBoQAw&biw=1536&bih=754#imgrc=Tv8N3Ti_yNyyQM");
        userPojo.setAd(ad);
        Data data =new Data();
        data.setFirst_name("Ratatui");
        data.setLast_name("Pony");
        data.setEmail("ponyLend@gmail.com");
        data.setAvatar("https://www.google.com/search?q=funny+pony+smile&tbm=isch&ved=2ahUKEwj6t6Px87boAhV" +
                "NPawKHTNBAQcQ2-cCegQIABAA&oq=funny+pony+smile&gs_l=img.3...131697.135615..135815...0.0..0.101.1181" +
                ".15j1......0....1..gws-wiz-img.......35i39j0i67j0j0i8i30j0i24.HW5CatQZLNI&ei=Lfp7XrrtHs36sAWzgoU4&bih=" +
                "754&biw=1536&rlz=1C1CHBF_enUS770US770#imgrc=raQMbZjkEi8qAM");
        userPojo.setData(data);
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("pony.json");
        objectMapper.writeValue(file,userPojo);

    }
    @Test
    public void serialazPet() throws IOException, URISyntaxException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("breakingbadapi.com")
                .setPath("api/characters");
        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept","application/json");
        HttpResponse response=httpClient.execute(httpPost);

        PetPojo petPojo=new PetPojo();
        Category category=new Category();
        category.setId(7);
        category.setName("poping");

        List<String> photoUR=new ArrayList();
        photoUR.add("www.pivture.com");

        List<Tags> tagsList=new ArrayList();
        Tags tags=new Tags();
        tags.setName("bobo");
        tags.setId(122) ;
        tagsList.add(tags);

        petPojo.setName("Dudu");
        petPojo.setStatus("home boy");
        petPojo.setId(333);
        petPojo.setCategory(category);

        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("pet.json");
        objectMapper.writeValue(file,petPojo);
    }
}
