package com.aa_bd.mali.service;

import com.aa_bd.mali.modele.Habitant;
import com.aa_bd.mali.modele.Pays;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HabitantService {

    Habitant creer(Habitant habitant);

    List<Habitant> lire();

    Habitant modifier(Long id_habitant, Habitant habitant);

    String supprimer(long id_habitant);
}
