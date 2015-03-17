package know;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PDF {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PDF() {
    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = 10)
    private int page;
    @Column(length = Integer.MAX_VALUE)
    private String content;
    @Column(length = Integer.MAX_VALUE)
    private String image;
    @Column(length = Integer.MAX_VALUE)
    private String path;

}
