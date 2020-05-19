package API.POJO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter

public class PetPojo {
    private int id;
    private Category category;
    private String name;
    private List<String> photoURl;
    private List<Tags> tags;
    private String status;

}
