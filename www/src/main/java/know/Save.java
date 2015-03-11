package know;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Save {

    public Save() {
    }

    public static Session getSession() {
        return selenium.openSession();
    }

    public static Aspect getAspect(int id) {
        return (Aspect) selenium.openSession().get(Aspect.class, id);
    }

    public static Object setState(Object save) {
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
        configuration.addAnnotatedClass(Aspect.class);
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
