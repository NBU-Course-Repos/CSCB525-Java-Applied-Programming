package config;

import com.mysql.cj.log.Log;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getCurrentSessionFromConfig() {

        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .configure().build();
            try{
                sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            }
            catch (Exception e){
                System.out.println(e);
            }

        }

        return sessionFactory;
    }
}
