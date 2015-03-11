package know.event;

import know.Save;
import java.util.ArrayList;
import know.Event;

public class Agent extends ArrayList<Event> {

    private String callback;

    public Agent() {
    }

    public Agent(String callback) {
        this.callback = callback;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        StringBuilder json = new StringBuilder();
        for (Event event : this) {
            json.append(callback);
            json.append("(");
            json.append(Save.getJSON(event));
            json.append(");");
        }
        return json.toString();
    }

}
