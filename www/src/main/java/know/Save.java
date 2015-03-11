package know;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Entity
public class Save {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @Column(length = Integer.MAX_VALUE)
    private String how;
    @Column(length = Integer.MAX_VALUE)
    private String json;

    @Override
    public String toString() {
        return Save.getJSON(this);
    }

    public Save() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public static Session getSession() {
        return selenium.openSession();
    }

    public static Object get(Class type, int id) {
        Object any = selenium.openSession().get(type, id);
        Save saved = new Save();
        saved.setJson(any.toString());
        saved.setHow("get");
        set(saved);
        return any;
    }

    public static Object set(Object save) {
        if (!save.getClass().equals(Save.class)) {
            Save saved = new Save();
            saved.setJson(save.toString());
            saved.setHow("set");
            set(saved);
        }
        Session local = selenium.openSession();
        Transaction tx = local.beginTransaction();
        local.saveOrUpdate(save);
        tx.commit();
        local.flush();
        local.close();
        return save;
    }

    private static final SessionFactory selenium;

    static {
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.current_session_context_class", "thread");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost/selenium");
        configuration.addAnnotatedClass(Action.class);
        configuration.addAnnotatedClass(Target.class);
        configuration.addAnnotatedClass(Value.class);
        configuration.addAnnotatedClass(Goal.class);
        configuration.addAnnotatedClass(Image.class);
        configuration.addAnnotatedClass(Event.class);
        configuration.addAnnotatedClass(Resource.class);
        configuration.addAnnotatedClass(Save.class);
        configuration.setProperties(properties);
        selenium = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
    }

    public static String getJSON(Object any) {
        try {
            return new ObjectMapper().writeValueAsString(any);
        } catch (JsonProcessingException ex) {
            return any.getClass().getCanonicalName();
        }
    }

}
