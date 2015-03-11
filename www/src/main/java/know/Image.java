package know;

import know.event.Save;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

    public static Image get(int id) {
        return (Image) Save.get(Image.class, id);
    }

    private static final Map<String, Image> cache = Collections.synchronizedMap(new HashMap());

    public static Image get(String action) {
        return new Image(action).find();
    }

    public Image find() {
        if (cache.containsKey(image)) {
            return cache.get(image);
        }
        cache.put(image, (Image) Save.set(new Image(image)));
        return find();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Image() {
    }

    public Image(String image) {
        this.image = image;
    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String image;

}
