package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBConfig
 *
 * Manages the EntityManagerFactory
 */
@WebListener
public class DBConfig implements ServletContextListener {
	private static EntityManagerFactory emf;
	
	/**
	 * Close EntityManagerFactory
	 */
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
         if (emf != null && emf.isOpen())
        	 emf.close();
    }
	/**
	 * Create EntityManagerFactory 
	 */
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
         emf = Persistence.createEntityManagerFactory("Umowy");
    }
    /**
     * Create EntityManager
     * @return EntityManager if not exist
     */
    public static EntityManager createEntitymanager() {
    	if (emf != null)
    		return emf.createEntityManager();
    	else
    		return null;
    }
	
}
