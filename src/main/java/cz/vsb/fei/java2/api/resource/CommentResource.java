package cz.vsb.fei.java2.api.resource;

import cz.vsb.fei.java2.api.resource.creations.CommentCreation;
import cz.vsb.fei.java2.api.resource.creations.FilterCreation;
import cz.vsb.fei.java2.entities.Comment;

import cz.vsb.fei.java2.entities.Photo;
import cz.vsb.fei.java2.entities.Project;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
    @Operation(operationId = "getAllComments", description = "Read all comments from database.")
    @GET
    public List<Comment> getAllComments() {
        return Comment.listAll();
    }

    @GET
    @Path("/{id}")
    public Comment getComment(@PathParam("id") Long id) {
        return Comment.findById(id);
    }

    @POST
    @Transactional
    public Response createComment(CommentCreation newComment) {
        Comment comment = new Comment();
        comment.setText(newComment.getText());
        comment.setDate(newComment.getDate());
        if (newComment.getId_project() != null) {
            Project project = Project.findById(newComment.getId_project());
            if (project == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Project not found").build();
            }
            comment.setProject(project);
        }
        if (newComment.getParent_id_comment() != null) {
            Comment parent_comment = Comment.findById(newComment.getParent_id_comment());
            if (parent_comment == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Parent comment not found").build();
            }
            comment.setParentComment(parent_comment);
        }
        comment.persist();
        return Response.status(Response.Status.CREATED).entity(comment).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateComment(@PathParam("id") Long id, CommentCreation updatedComment) {
        Comment entity = Comment.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setText(updatedComment.getText());
        entity.setDate(updatedComment.getDate());
        if (updatedComment.getId_project() != null) {
            Project project = Project.findById(updatedComment.getId_project());
            if (project == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Project not found").build();
            }
            entity.setProject(project);
        }
        if (updatedComment.getParent_id_comment() != null) {
            Comment parent_comment = Comment.findById(updatedComment.getParent_id_comment());
            if (parent_comment == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Parent comment not found").build();
            }
            entity.setParentComment(parent_comment);
        }
        return Response.ok(entity).build();
    }
}

