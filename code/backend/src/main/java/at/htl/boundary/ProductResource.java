package at.htl.boundary;

import at.htl.control.ProductRepository;
import at.htl.entities.Product;
import org.jboss.logging.Logger;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@Path("/product")
public class ProductResource {

    @Inject
    Logger logger;

    @Inject
    ProductRepository productRepository;

    private List<Product> products = new LinkedList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product findById(
            @PathParam("id") long id
    ) {
        logger.info(id);
        return productRepository.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(
            Product product,
            @Context UriInfo uriInfo
    ) throws Exception {
        Product saved = productRepository.save(product);
        logger.info(product.getTeaType() + " wird gespeichert");
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path(saved.getProductID().toString())
                .build();
        return Response.created(location).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(
            @PathParam("id") long id
    ) {
        //logger.info(id);
        Product product = findById(id);
        if (product != null){
            productRepository.delete(findById(id));
        }
        return Response.noContent().build();
    }

}
