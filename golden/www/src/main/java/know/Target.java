package know;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Target {

    private static final Map<String, Target> cache = Collections.synchronizedMap(new HashMap());

    public static Target get(String target) {
        return new Target(target).find();
    }

    public Target find() {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        cache.put(target, (Target) Save.setState(new Target(target)));
        return find();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Target() {
    }

    public Target(String target) {
        this.target = target;
    }
    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String target;

}
