package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import context.Singleton;


public class AppListener implements ServletContextListener {

	 public void contextInitialized(ServletContextEvent sce)  { 

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			Singleton.getInstance();
    }
	
	 
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    		Singleton.getInstance().getEmf().close();
    }

   
}
