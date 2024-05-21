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
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@Entity
public class Project extends PanacheEntity {

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description", length = 5000, nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "condition", length = 5, nullable = false)
    private String condition;

    @OneToMany(mappedBy = "project")
    @JsonbTransient
    private List<Photo> photos;

    @OneToMany(mappedBy = "project")
    @JsonbTransient
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

}