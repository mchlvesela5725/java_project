package cz.vsb.fei.java2.api.resource.creations;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectCreation {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String condition;
    private Long id_user;

}
