package cz.vsb.fei.java2.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = { "id" }, callSuper = false, doNotUseGetters = true)
@Entity
public class Filter extends PanacheEntity {

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "type", length = 30, nullable = false)
    private String type;

    @Column(name = "price", nullable = true)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "id_photo")
    private Photo photo;

}