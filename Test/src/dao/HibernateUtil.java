package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session = buildSessionFactory();

	private static Session buildSessionFactory() {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		session = configuration.configure().buildSessionFactory().openSession();
		if(!session.isOpen() && session == null)
			throw new NullPointerException();
		return session;
		
	}

	/**
	 * @return the sessionfactory
	 */
	public static Session getSession() {
		return buildSessionFactory();
	}	
}
