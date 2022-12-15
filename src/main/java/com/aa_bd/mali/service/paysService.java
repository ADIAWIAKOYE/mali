package com.aa_bd.mali.service;

import com.aa_bd.mali.modele.Pays;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface paysService {

    Pays creer(Pays pays);

    List<Pays> lire();

    Pays modifier(Long id_pays, Pays pays);

    String supprimer(Long id_pays);
}
