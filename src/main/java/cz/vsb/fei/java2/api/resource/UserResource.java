package cz.vsb.fei.java2.api.resource;

import cz.vsb.fei.java2.entities.Project;
import cz.vsb.fei.java2.entities.Users;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Operation(operationId = "getAllUsers", description = "Read all users from database.")
    @GET
    public List<Users> getAllUsers() {
        return Users.listAll();
    }

    @GET
    @Path("/{id}")
    public Users getUser(@PathParam("id") Long id) {
        return Users.findById(id);
    }

    @POST
    public Response createUser(Users user) {
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, Users user) {
        Users entity = Users.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setUser_name(user.getUser_name());
        entity.setFirst_name(user.getFirst_name());
        entity.setLast_name(user.getLast_name());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setDate_of_registration(user.getDate_of_registration());
        entity.setAddress(user.getAddress());
        entity.setPhone(user.getPhone());

        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        boolean deleted = Users.deleteById(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    /*
    @Operation(operationId = "getUsersProject", description = "Read project of user (ID) from database.")
    @GET()
    @Path("/{id}/projects")
    public List<Project> getUsersProject(@PathParam("id") Long id) {
        Users user = Users.findById(id);
        return user.getProject_list();
    }

    @Operation(operationId = "createUser", description = "Store new user into database.")
    @Transactional
    @POST
    public Users createUser(Users user) {
        user.id = null;
        user.persist();
        return user;
    }

    @Operation(operationId = "updateUser", description = "Store changes in existing user into database.")
    @Transactional
    @Path("/{id}")
    @PUT
    public Response updateUser(@PathParam("id") Long id, Users user) {
        Users userDb = Users.findById(id);
        if (userDb == null) {
            return Response.status(400).type(MediaType.TEXT_PLAIN).entity(String.format("User with ID %s not found.", id)).build();
        }
        userDb.updateFromRestApi(user);
        return Response.ok(String.format("User with ID %s successfuly deleted.", id)).build();
    }

    @Operation(operationId = "deleteUser", description = "Delete existing user from database.")
    @Transactional
    @Path("/{id}")
    @DELETE
    public Response deleteUser(@PathParam("id") Long id) {
        Users user = Users.findById(id);
        if(user == null) {
            return Response.status(400).type(MediaType.TEXT_PLAIN).entity(String.format("User with ID %s not found.", id)).build();
        }
        user.getProject_list().forEach(Project::delete);
        user.delete();
        return Response.ok(String.format("User with ID %s successfuly deleted.", id)).build();
    }
    */
}