package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import entity.User;



public class HibernateUtil {
	
	
	 private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "org.postgresql.Driver");
	    settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/User_DB");
	    settings.put(Environment.USER, "postgres");
	    settings.put(Environment.PASS, "root");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

//	    settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(User.class);

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	}


