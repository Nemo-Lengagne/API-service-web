package api.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/products")
@Produces("application/json")
public class Product {

    /**
     * GET operation: Return "GET"
     */
    @GET
    public Response getProduct() {
        return Response.ok("GET").build();
    }

    /**
     * POST operation: Return "POST" if all data is provided (2 elements)
     */
    @POST
    @Consumes("application/json")
    public Response createProduct(ProductData data) {
        // Check if both elements are provided
        if (data != null && data.getName() != null && !data.getName().isEmpty()
                && data.getPrice() != null && data.getPrice() > 0) {
            return Response.status(Response.Status.CREATED).entity("POST").build();
        }
        // Return error if data is incomplete
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error: Product name and price are required").build();
    }

    /**
     * PUT operation: Return "PUT" if at least one data is transmitted
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response updateProduct(@PathParam("id") int id, ProductData data) {
        // Check if at least one data is transmitted
        if (data != null && ((data.getName() != null && !data.getName().isEmpty())
                || (data.getPrice() != null && data.getPrice() > 0))) {
            return Response.ok("PUT").build();
        }
        // Return error if no data is transmitted
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error: At least one field (name or price) must be provided").build();
    }

    /**
     * DELETE operation: Return "DELETE" if data is present for deletion
     */
    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        // Check if the ID is valid (data is present)
        if (id > 0) {
            return Response.ok("DELETE").build();
        }
        // Return error if no valid ID is provided
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Error: Product not found").build();
    }
}
