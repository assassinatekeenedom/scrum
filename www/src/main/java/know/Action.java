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
public class Action {

    private static final Map<String, Action> cache = Collections.synchronizedMap(new HashMap());

    public static Action get(String action) {
        return new Action(action).find();
    }

    public Action find() {
        if (cache.containsKey(action)) {
            return cache.get(action);
        }
        cache.put(action, (Action) Save.set(new Action(action)));
        return find();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Action() {
    }

    public Action(String action) {
        this.action = action;
    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String action;

}
