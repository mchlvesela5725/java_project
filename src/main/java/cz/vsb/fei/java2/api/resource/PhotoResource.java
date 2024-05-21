package cz.vsb.fei.java2.api.resource;

import cz.vsb.fei.java2.api.resource.creations.PhotoCreation;
import cz.vsb.fei.java2.api.resource.creations.ProjectCreation;
import cz.vsb.fei.java2.entities.Photo;
import cz.vsb.fei.java2.entities.Project;
import cz.vsb.fei.java2.entities.Users;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/photos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhotoResource {

    @Operation(operationId = "getAllPhotos", description = "Read all photos from database.")
    @GET
    public List<Photo> getAllPhotos() {
        return Photo.listAll();
    }

    @GET
    @Path("/{id}")
    public Photo getPhoto(@PathParam("id") Long id) {
        return Photo.findById(id);
    }

    @POST
    @Transactional
    public Response createPhoto(PhotoCreation newPhoto) {
        Photo photo = new Photo();
        photo.setName(newPhoto.getName());
        photo.setDescription(newPhoto.getDescription());
        photo.setDate_of_upload(newPhoto.getDate_of_upload());
        photo.setPath(newPhoto.getPath());
        if (newPhoto.getId_project() != null) {
            Project project = Project.findById(newPhoto.getId_project());
            if (project == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Project not found").build();
            }
            photo.setProject(project);
        }
        photo.persist();
        return Response.status(Response.Status.CREATED).entity(photo).build();
    }



    @PUT
    @Path("/{id}")
    @Transactional
    public Response updatePhoto(@PathParam("id") Long id, PhotoCreation updatedPhoto) {
        Photo entity = Photo.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setName(updatedPhoto.getName());
        entity.setDescription(updatedPhoto.getDescription());
        entity.setDate_of_upload(updatedPhoto.getDate_of_upload());
        entity.setPath(updatedPhoto.getPath());
        if (updatedPhoto.getId_project() != null) {
            Project project = Project.findById(updatedPhoto.getId_project());
            if (project == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Project not found").build();
            }
            entity.setProject(project);
        }
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletePhoto(@PathParam("id") Long id) {
        boolean deleted = Photo.deleteById(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
