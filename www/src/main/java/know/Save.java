package know;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Save implements Callable<Object> {

    @Override
    public Object call() {
        Transaction tx = session.beginTransaction();
        session.save(save);
        session.flush();
        session.clear();
        tx.commit();
        session.close();
        return save;
    }

    public static Object set(Object save) {
        return new Save(selenium.openSession(), save).call();
    }

    public static Object get(Class type, int id) {
        return selenium.openSession().get(type, id);
    }

    public static synchronized List get(Class type) {
        return selenium.openSession().createCriteria(type).list();
    }

    public static String getJSON(Object any) {
        try {
            return new ObjectMapper().writeValueAsString(any);
        } catch (JsonProcessingException ex) {
            return any.getClass().getCanonicalName();
        }
    }

    public Save(Session session, Object save) {
        this.session = session;
        this.save = save;
    }

    static {
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.hbm2ddl.auto", "update");
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
    private static final SessionFactory selenium;
    private final Session session;
    private final Object save;

}
