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
public class Goal {

    public static Goal get(int id) {
        return (Goal) Save.get(Goal.class, id);
    }

    private static final Map<String, Goal> cache = Collections.synchronizedMap(new HashMap());

    public static Goal get(String action) {
        return new Goal(action).find();
    }

    public Goal find() {
        if (cache.containsKey(goal)) {
            return cache.get(goal);
        }
        cache.put(goal, (Goal) Save.set(new Goal(goal)));
        return find();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Goal() {
    }

    public Goal(String goal) {
        this.goal = goal;
    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String goal;

}
