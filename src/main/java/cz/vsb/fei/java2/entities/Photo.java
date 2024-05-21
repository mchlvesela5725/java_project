
package cz.vsb.fei.java2.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = { "id" }, callSuper = false, doNotUseGetters = true)
@Entity
public class Photo extends PanacheEntity {

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description", length = 5000, nullable = false)
    private String description;

    @Column(name = "path", length = 20, nullable = false)
    private String path;

    @Column(name = "date_of_upload",nullable = false)
    private LocalDate date_of_upload;

    @OneToMany(mappedBy = "photo")
    @JsonbTransient
    private List<Filter> filters;

    @OneToMany(mappedBy = "photo")
    @JsonbTransient
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

}
