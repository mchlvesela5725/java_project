package cz.vsb.fei.java2.api.resource.creations;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentCreation {
    private Long id;
    private String text;
    private LocalDate date;
    private Long id_project;
    private Long parent_id_comment;
}