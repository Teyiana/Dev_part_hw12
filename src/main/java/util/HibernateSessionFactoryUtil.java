package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import entity.Client;
import entity.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;


public class HibernateSessionFactoryUtil {
    private static final String URL_PROP = "hibernate.connection.url";
    private static final String USER_PROP = "hibernate.connection.username";
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().addProperties(System.getProperties());
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Planet.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static void init() throws IOException {
        Properties hibernateProps = new Properties();
        hibernateProps.load(HibernateSessionFactoryUtil.class.getClassLoader().getResourceAsStream("hibernate.properties"));

        String dbUrl = (String) hibernateProps.get(URL_PROP);
        String dbUser = (String) hibernateProps.get(USER_PROP);

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        HikariDataSource ds = new HikariDataSource(config);

        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(ds)
                .locations("db/migrations")
                .load();
        flyway.migrate();
        ds.close();

    }

    public void close() {
        sessionFactory.close();
    }

}


