package filter;

import DAO.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static controller.LoginServlet.USER_SERVICE;

@WebListener
public class InitAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(USER_SERVICE, new UserDAO());
//        servletContext.setAttribute(USER_SERVICE, new UserDAO());
//        servletContext.setAttribute(USER_SERVICE, new UserDAO());
//        servletContext.setAttribute(USER_SERVICE, new UserDAO());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
