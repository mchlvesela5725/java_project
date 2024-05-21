package cz.vsb.fei.java2.api.resource.creations;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CategoryCreation {

    private Long id;
    private String name;
    private String type;
    private String data;
    private Long id_photo;
}
