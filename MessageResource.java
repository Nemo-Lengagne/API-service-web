import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Classe Resource pour gérer les messages via une API REST
 * Endpoints disponibles :
 * - GET    /messages         -> Récupérer tous les messages
 * - GET    /messages/{id}    -> Récupérer un message spécifique
 * - POST   /messages         -> Ajouter un nouveau message
 * - PUT    /messages/{id}    -> Mettre à jour un message
 * - DELETE /messages/{id}    -> Supprimer un message
 */
@Path("/messages")
public class MessageResource {
    
    // Storage en mémoire pour les messages (à remplacer par une base de données en production)
    private static final Map<String, String> messages = new HashMap<>();
    
    static {
        // Données de test initiales
        messages.put("1", "Bonjour, bienvenue dans notre API REST !");
        messages.put("2", "Ceci est un second message de test");
    }

    /**
     * GET : Récupérer tous les messages
     * URL : http://localhost:8080/api/messages
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        return Response.ok(messages).build();
    }

    /**
     * GET : Récupérer un message spécifique par ID
     * URL : http://localhost:8080/api/messages/{id}
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMessageById(@PathParam("id") String id) {
        if (messages.containsKey(id)) {
            return Response.ok(messages.get(id)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Message avec l'ID " + id + " non trouvé").build();
        }
    }

    /**
     * POST : Ajouter un nouveau message
     * URL : http://localhost:8080/api/messages
     * Corps de la requête : le texte du message
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Le message ne peut pas être vide\"}").build();
        }
        
        // Générer un ID unique
        String id = UUID.randomUUID().toString();
        messages.put(id, message);
        
        return Response.status(Response.Status.CREATED)
                .entity("{\"id\": \"" + id + "\", \"message\": \"" + message + "\", \"status\": \"créé\"}")
                .build();
    }

    /**
     * PUT : Mettre à jour un message existant
     * URL : http://localhost:8080/api/messages/{id}
     * Corps de la requête : le nouveau texte du message
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMessage(@PathParam("id") String id, String message) {
        if (!messages.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Message avec l'ID " + id + " non trouvé\"}").build();
        }
        
        if (message == null || message.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Le message ne peut pas être vide\"}").build();
        }
        
        messages.put(id, message);
        
        return Response.ok()
                .entity("{\"id\": \"" + id + "\", \"message\": \"" + message + "\", \"status\": \"mis à jour\"}")
                .build();
    }

    /**
     * DELETE : Supprimer un message
     * URL : http://localhost:8080/api/messages/{id}
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMessage(@PathParam("id") String id) {
        if (!messages.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Message avec l'ID " + id + " non trouvé\"}").build();
        }
        
        messages.remove(id);
        
        return Response.noContent().build();
    }

    /**
     * GET : Health check de l'API
     * URL : http://localhost:8080/api/messages/health
     */
    @GET
    @Path("/health")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthCheck() {
        return "API REST fonctionnelle - " + messages.size() + " messages en stock";
    }
}
