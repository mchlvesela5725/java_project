package cz.vsb.fei.java2.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = { "id" }, callSuper = false, doNotUseGetters = true)
@Entity
public class Category extends PanacheEntity {

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "type", length = 12, nullable = false)
    private String type;

    @Column(name = "data", length = 100, nullable = false)
    private String data;

    @ManyToOne
    @JoinColumn(name = "id_photo")
    private Photo photo;

}
