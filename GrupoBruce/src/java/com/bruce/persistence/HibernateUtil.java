package com.bruce.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author SISTEMAS
 */
public class HibernateUtil {
    
    private static SessionFactory factory;
    
    private static SessionFactory createSessionFactory(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(registry);
        return factory;
    }
    
    public static SessionFactory getSessionFactory(){
        return factory == null ? createSessionFactory() : factory;
    }
}
