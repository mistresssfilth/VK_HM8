package api;

import com.google.inject.Inject;
import entity.Product;
import service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public final class ProductREST {
    private final ProductService productService;

    @Inject
    public ProductREST(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Path("/all")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getProducts(){
        return Response.ok(productService.getAllProducts())
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();

    }
    @POST
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Product product){
        productService.save(product);
        return Response.ok()
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();
    }
    @GET
    @Path("/byCompany")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getProductsByCompany(@QueryParam("name") String companyName){
        return Response.ok(productService.getProductsByCompany(companyName))
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();
    }
    @POST
    @Path("/delete")
    public Response deleteByProductName(@QueryParam("name") String productName){
       if (productService.delete(productName))
           return Response.ok().header(HttpHeaders.CACHE_CONTROL, "no-cache").build();
       else
           return Response.status(404).header(HttpHeaders.CACHE_CONTROL, "no-cache").build();
    }
}
