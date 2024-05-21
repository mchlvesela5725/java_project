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
public class Users extends PanacheEntity {

    @Column(name = "user_name", length = 30, nullable = false)
    private String user_name;

    @Column(name = "first_name", length = 20, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 20, nullable = false)
    private String last_name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "address", length = 50, nullable = true)
    private String address;

    @Column(name = "date_of_registration",nullable = true)
    private Date date_of_registration;

    @Column(name = "phone", length = 12, nullable = true)
    private String phone;

    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<Project> projects;

}
