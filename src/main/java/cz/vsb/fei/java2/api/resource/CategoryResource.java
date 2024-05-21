package cz.vsb.fei.java2.api.resource;

import cz.vsb.fei.java2.api.resource.creations.CategoryCreation;
import cz.vsb.fei.java2.api.resource.creations.FilterCreation;
import cz.vsb.fei.java2.entities.Category;
import cz.vsb.fei.java2.entities.Photo;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {
    @Operation(operationId = "getAllCategories", description = "Read all categories from database.")
    @GET
    public List<Category> getAllCategories() {
        return Category.listAll();
    }

    @GET
    @Path("/{id}")
    public Category getCategory(@PathParam("id") Long id) {
        return Category.findById(id);
    }

    @POST
    @Transactional
    public Response createCategory(CategoryCreation newCategory) {
        Category category = new Category();
        category.setName(newCategory.getName());
        category.setType(newCategory.getType());
        category.setData(newCategory.getData());
        if (newCategory.getId_photo() != null) {
            Photo photo = Photo.findById(newCategory.getId_photo());
            if (photo == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Photo not found").build();
            }
            category.setPhoto(photo);
        }
        category.persist();
        return Response.status(Response.Status.CREATED).entity(category).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCategory(@PathParam("id") Long id, CategoryCreation updatedCategory) {
        Category entity = Category.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setName(updatedCategory.getName());
        entity.setType(updatedCategory.getType());
        entity.setData(updatedCategory.getData());
        if (updatedCategory.getId_photo() != null) {
            Photo photo = Photo.findById(updatedCategory.getId_photo());
            if (photo == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Photo not found").build();
            }
            entity.setPhoto(photo);
        }
        return Response.ok(entity).build();
    }
}