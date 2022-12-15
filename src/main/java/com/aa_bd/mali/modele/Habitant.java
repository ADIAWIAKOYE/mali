package com.aa_bd.mali.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.security.PrivilegedGetTccl;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Habitant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habitant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_habitant;
    private Date date;
    private String nb_habitant;


    @ManyToOne
    private Region region;

}
