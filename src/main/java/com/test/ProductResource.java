package com.test;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.test.model.Product;
import com.test.service.ProductService;

@Path("/products")
public class ProductResource {

	private ProductService productService = new ProductService();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> fetchAll() {
        return productService.fetchAll();
    }

    @GET
    @Path("product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.ok().entity(productService.fetchBy(id)).build();
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Product product) {
        // create notification
        productService.create(product);
        return Response.status(Status.CREATED).build();
    }
 
    @PUT
    @Path("/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Product product) {
        productService.update(product);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/product/{id}")
    public Response delete(@PathParam("id") long id) {
        productService.delete(id);
        return Response.status(202).entity("User deleted successfully !!").build();
    }
}
