package know;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aspect {

    public static Aspect get(String folder, String name, String type, String content) {
        return (Aspect) Save.setState(new Aspect(folder, name, type, content));
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Save.getJSON(this);
    }

    public Aspect() {
    }

    public Aspect(String folder, String name, String type, String content) {
        this.folder = folder;
        this.name = name;
        this.type = type;
        this.content = content;

    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String folder;
    @Column(length = Integer.MAX_VALUE)
    private String name;
    @Column(length = Integer.MAX_VALUE)
    private String type;
    @Column(length = Integer.MAX_VALUE)
    private String content;

}
