package cz.vsb.fei.java2.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = { "id" }, callSuper = false, doNotUseGetters = true)
@Entity
public class Comment extends PanacheEntity {

    @Column(name = "text", length = 5000, nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "parent_id_comment")
    private Comment parentComment;

}