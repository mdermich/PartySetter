package com.party.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.party.models.Comments;
import com.party.models.Evenement;
import com.party.models.Event;
import com.party.models.Menu;
import com.party.models.Paiement;
import com.party.models.Reservation;
import com.party.models.User;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/projetjee?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Event.class);
				configuration.addAnnotatedClass(Evenement.class);
				configuration.addAnnotatedClass(Reservation.class);
				configuration.addAnnotatedClass(Paiement.class);
				configuration.addAnnotatedClass(Comments.class);
				configuration.addAnnotatedClass(Menu.class);
				
				


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