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
 */
@WebListener
public class DBConfig implements ServletContextListener {
	private static EntityManagerFactory emf;
	
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
         if (emf != null && emf.isOpen())
        	 emf.close();
    }
	
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
         emf = Persistence.createEntityManagerFactory("Umowy");
    }
    
    public static EntityManager createEntitymanager() {
    	if (emf != null)
    		return emf.createEntityManager();
    	else
    		return null;
    }
	
}
