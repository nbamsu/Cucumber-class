package API.POJO;

import java.util.Map;

public class CommentPojo {
    private String self;
    private int id;
    private Map<String,Object> author;
    private String body;
    private Map<String, Object> updateAuthor;
    private String created;
    private String  updated;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getAuthor() {
        return author;
    }

    public void setAuthor(Map<String, Object> author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Object> getUpdateAuthor() {
        return updateAuthor;
    }

    public void setUpdateAuthor(Map<String, Object> updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
