import commons.FlywayInit;
import guice.GuiceListener;
import handlers.SecurityHandlerBuilder;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import server.DefaultServer;


public class Main {
    public static void main(String[] args) throws Exception {
        final Server server = new DefaultServer().build();

        FlywayInit.initDb();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.addServlet(HttpServletDispatcher.class, "/");
        context.addEventListener(new GuiceListener());

        final String hashConfig = Main.class.getResource("/hash_config").toExternalForm();
        final HashLoginService hashLoginService = new HashLoginService("login", hashConfig);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(hashLoginService);

        server.addBean(hashLoginService);
        context.setHandler(securityHandler);

        server.setHandler(context);
        server.start();
    }
}
