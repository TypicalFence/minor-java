package moe.zaun.prismriver.minor;

import com.google.common.primitives.Ints;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;


public final class App {
    
    public static int compare(int a, int b) {
        return Ints.compare(a, b);
    }
    

    public static void main(String... args) throws Exception {
        App app = new App();
        System.out.println("Success: " + app.compare(2, 1));
        final Server server = setupServer(8080);
        setupServerContext(server);
        startServer(server);
    }
    
    private static Server setupServer(int port) {
        final Server server = new Server();
        final HttpConfiguration httpConfig = new HttpConfiguration();
        httpConfig.setSendServerVersion(false);
        httpConfig.setSendDateHeader(false);
        final HttpConnectionFactory httpFactory = new HttpConnectionFactory(httpConfig);
        final ServerConnector connector = new ServerConnector(server, httpFactory);
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});
        server.setStopAtShutdown(true);
        return server;
    }

    private static void setupServerContext(Server server) {
        final ServletContextHandler contextHandler = new ServletContextHandler(server, "/");
        contextHandler.addServlet(HttpServlet30Dispatcher.class, "/*");

        contextHandler.addEventListener(new ModuleContextListener());
    }

    private static void startServer(Server server) throws Exception {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            server.stop();
            throw e;
        }
    }

}
