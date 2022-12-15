package com.aa_bd.mali.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pays")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pays;
    @Column(name = "nom_pays", unique = true)
    private String nom_pays;

   /* @JsonIgnore
    @OneToMany(mappedBy = "Pays")
    private List<Region> region;*/
}
