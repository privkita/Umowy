package dao;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBInitializer
 *
 */
@WebListener
public class DBInitializer implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	// Tworzy dla żądania managera Encji oraz obiekty dao 
    	EntityManager em = DBConfig.createEntitymanager();
    	ContractDao contractDao = new ContractDao(em);
    	SystemDao systemDao = new SystemDao(em);
    	ServletRequest req = sre.getServletRequest();
    	req.setAttribute("contractDao", contractDao);
    	req.setAttribute("systemDao", systemDao);
    }
	
}
