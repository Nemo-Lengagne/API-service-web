import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerFactory;
import com.sun.net.httpserver.HttpServer;
import java.net.URI;

/**
 * Classe principale pour initialiser et démarrer le serveur API REST
 */
public class Main {
    private static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) {
        try {
            // Créer la configuration des ressources
            ResourceConfig resourceConfig = new ResourceConfig();
            resourceConfig.packages("com.api.resources");
            
            // Créer le serveur HTTP
            HttpServer server = NettyHttpContainerFactory.createHttpServer(
                    URI.create(BASE_URI),
                    resourceConfig,
                    true
            );
            
            // Démarrer le serveur
            server.start();
            System.out.println("✓ Serveur API REST démarré avec succès !");
            System.out.println("✓ URL de base : " + BASE_URI);
            System.out.println("✓ Appuyez sur Ctrl+C pour arrêter le serveur");
            
            // Garder le serveur en exécution
            Thread.currentThread().join();
            
        } catch (Exception e) {
            System.err.println("✗ Erreur lors du démarrage du serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}