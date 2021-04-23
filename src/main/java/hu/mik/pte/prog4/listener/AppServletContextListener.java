package hu.mik.pte.prog4.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppServletContextListener implements ServletContextListener {

    private static final String JAVA_SECURITY_PROPERTY = "java.security.auth.login.config";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (System.getProperty(JAVA_SECURITY_PROPERTY) == null) {
            String jaasConfigFile = this.getClass().getClassLoader().getResource("jaas.config").getFile();
            System.setProperty(JAVA_SECURITY_PROPERTY, jaasConfigFile);
        }
    }
}
