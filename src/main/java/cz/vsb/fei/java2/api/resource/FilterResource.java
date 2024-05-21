package cz.vsb.fei.java2.api.resource;

import cz.vsb.fei.java2.api.resource.creations.FilterCreation;
import cz.vsb.fei.java2.api.resource.creations.ProjectCreation;
import cz.vsb.fei.java2.entities.Filter;
import cz.vsb.fei.java2.entities.Photo;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/filters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilterResource {

    @Operation(operationId = "getAllFilters", description = "Read all filters from database.")
    @GET
    public List<Filter> getAllFilters() {
        return Filter.listAll();
    }

    @GET
    @Path("/{id}")
    public Filter getFilter(@PathParam("id") Long id) {
        return Filter.findById(id);
    }

    @POST
    @Transactional
    public Response createFilter(FilterCreation newFilter) {
        Filter filter = new Filter();
        filter.setName(newFilter.getName());
        filter.setType(newFilter.getType());
        filter.setPrice(newFilter.getPrice());
        if (newFilter.getId_photo() != null) {
            Photo photo = Photo.findById(newFilter.getId_photo());
            if (photo == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Photo not found").build();
            }
            filter.setPhoto(photo);
        }
        filter.persist();
        return Response.status(Response.Status.CREATED).entity(filter).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateFilter(@PathParam("id") Long id, FilterCreation updatedFilter) {
        Filter entity = Filter.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setName(updatedFilter.getName());
        entity.setType(updatedFilter.getType());
        entity.setPrice(updatedFilter.getPrice());
        if (updatedFilter.getId_photo() != null) {
            Photo photo = Photo.findById(updatedFilter.getId_photo());
            if (photo == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Photo not found").build();
            }
            entity.setPhoto(photo);
        }
        return Response.ok(entity).build();
    }
}