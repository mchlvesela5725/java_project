package cz.vsb.fei.java2.api.resource.creations;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PhotoCreation {
    private Long id;
    private String name;
    private String description;
    private LocalDate date_of_upload;
    private String path;
    private Long id_project;
}
