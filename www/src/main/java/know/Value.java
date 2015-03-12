package know;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Value {

    private static final Map<String, Value> cache = Collections.synchronizedMap(new HashMap());

    public static Value get(int id) {
        return (Value) Save.get(Value.class, id);
    }

    public static Value get(String value) {
        return new Value(value).find();
    }

    public Value find() {
        if (cache.containsKey(value)) {
            return cache.get(value);
        }
        cache.put(value, (Value) Save.set(new Value(value)));
        return find();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Value() {
    }

    public Value(String value) {
        this.value = value;
    }
    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String value;

}
