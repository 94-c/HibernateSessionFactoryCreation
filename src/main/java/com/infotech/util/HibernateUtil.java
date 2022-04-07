package com.infotech.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    /*static {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Map<String, String> dbSetting = new HashMap<>();
        dbSetting.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        dbSetting.put(Environment.USER, "root");
        dbSetting.put(Environment.PASS, "root");
        dbSetting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        dbSetting.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        registryBuilder.applySettings(dbSetting);

        standardServiceRegistry = registryBuilder.build();

        MetadataSources sources = new MetadataSources(standardServiceRegistry);

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }*/

    static {
        if (sessionFactory == null){
            try{
                // Create StandardServiceRegistry
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

                // Create MetadataSources
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

                // Create Metadata
                Metadata metadata = metadataSources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }catch (Exception e){
                e.printStackTrace();
                if (standardServiceRegistry != null){
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }
            }

        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
