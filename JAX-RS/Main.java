package api;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class to start the RESTful API server
 */
public class Main {
    // Base URI where the application will run
    public static final String BASE_URI = "http://localhost:8080/api/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources from this application.
     */
    public static HttpServer startServer() {
        // Create a ResourceConfig that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig()
                .packages("api.resource");

        // Create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {
        try {
            System.out.println("Starting RESTful API Server...");
            final HttpServer server = startServer();
            System.out.println(String.format("Jersey app started with WADL available at "
                    + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
            System.out.println("Server running at " + BASE_URI);
            System.in.read();
            server.shutdown();
            System.out.println("Server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
