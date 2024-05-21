package cz.vsb.fei.java2.api.resource;

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
@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {

    @Operation(operationId = "getAllProjects", description = "Read all projects from database.")
    @GET
    public List<Project> getAllProjects() {
        return Project.listAll();
    }

    @GET
    @Path("/{id}")
    public Project getProject(@PathParam("id") Long id) {
        return Project.findById(id);
    }

    @POST
    @Transactional
    public Response createProject(ProjectCreation newProject) {
        Project project = new Project();
        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        project.setDate(newProject.getDate());
        project.setCondition(newProject.getCondition());
        if (newProject.getId_user() != null) {
            Users user = Users.findById(newProject.getId_user());
            if (user == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("User not found").build();
            }
            project.setUser(user);
        }
        project.persist();
        return Response.status(Response.Status.CREATED).entity(project).build();
    }



    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateProject(@PathParam("id") Long id, ProjectCreation updatedProject) {
        Project entity = Project.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setName(updatedProject.getName());
        entity.setDescription(updatedProject.getDescription());
        entity.setDate(updatedProject.getDate());
        entity.setCondition(updatedProject.getCondition());
        if (updatedProject.getId_user() != null) {
            Users user = Users.findById(updatedProject.getId_user());
            if (user == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("User not found").build();
            }
            entity.setUser(user);
        }
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteProject(@PathParam("id") Long id) {
        boolean deleted = Project.deleteById(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
