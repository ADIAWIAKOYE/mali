package com.aa_bd.mali.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Region")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_region;

    private String code_region;
    @Column(unique = true)
    private String nom;
    private String doActivite;
    private String lanParle;
    private String superficie;



    @ManyToOne
    private Pays pays;

   /* @JsonIgnore
    @OneToMany(mappedBy ="Region")
    private List<Habitant> habitant;*/
}
