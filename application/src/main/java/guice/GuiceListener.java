package guice;

import api.HelpREST;
import api.JacksonMessageBodyHandler;
import api.ObjectMapperProvider;
import api.ProductREST;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import dao.ProductDAO;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public class GuiceListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }
    private static final class GuiceModule extends AbstractModule{
        @Override
        protected void configure() {
            bind(ProductDAO.class);
            bind(ProductREST.class);
            bind(HelpREST.class);
            bind(ObjectMapperProvider.class).toInstance(new ObjectMapperProvider());
            bind(JacksonMessageBodyHandler.class).toInstance(new JacksonMessageBodyHandler());

        }
    }
}
