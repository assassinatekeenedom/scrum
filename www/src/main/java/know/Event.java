package know;

import know.event.Save;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event {

    public static Event get(int id) {
        return (Event) Save.get(Event.class, id);
    }

    public static Event get(Action action, Target target, Value value, Goal goal, Image image) {
        return (Event) Save.set(new Event(action, target, value, goal, image));
    }

    public static Event get(String action, String target, String value, String goal, String image) {
        return get(Action.get(action), Target.get(target), Value.get(value), Goal.get(goal), Image.get(image));
    }

    public Event find() {
        return get(action, target, value, goal, image);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public know.Action getAction() {
        return action;
    }

    public void setAction(Action command) {
        this.action = command;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Event() {
    }

    public Event(Action action, Target target, Value value, Goal goal, Image image) {
        this.action = action;
        this.target = target;
        this.value = value;
        this.goal = goal;
        this.image = image;
    }

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "actionId")
    private Action action;
    @ManyToOne()
    @JoinColumn(name = "targetId")
    private Target target;
    @ManyToOne()
    @JoinColumn(name = "valueId")
    private Value value;
    @ManyToOne()
    @JoinColumn(name = "goalId")
    private Goal goal;
    @ManyToOne()
    @JoinColumn(name = "imageId")
    private Image image;
}
