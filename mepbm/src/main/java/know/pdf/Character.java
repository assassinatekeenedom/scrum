package know.pdf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Character {

    private String name;
    private int command;
    private int agent;
    private int emissary;
    private int mage;
    private String date;
    private String message;
    

    public Character() {
    }

    public Character(String name, int command, int agent, int emissary, int mage) {
        this.name = name;
        this.command = command;
        this.agent = agent;
        this.emissary = emissary;
        this.mage = mage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getAgent() {
        return agent;
    }

    public void setAgent(int agent) {
        this.agent = agent;
    }

    public int getEmissary() {
        return emissary;
    }

    public void setEmissary(int emissary) {
        this.emissary = emissary;
    }

    public int getMage() {
        return mage;
    }

    public void setMage(int mage) {
        this.mage = mage;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            return "failed to create JSON for Character";
        }
    }

}
