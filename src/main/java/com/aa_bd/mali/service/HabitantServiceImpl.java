package com.aa_bd.mali.service;

import com.aa_bd.mali.modele.Habitant;
import com.aa_bd.mali.repository.HabitantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HabitantServiceImpl implements HabitantService{

    private final HabitantRepository habitantRepository;

    @Override
    public Habitant creer(Habitant habitant) {
        return habitantRepository.save(habitant);
    }

    @Override
    public List<Habitant> lire() {
        return habitantRepository.findAll();
    }

    @Override
    public Habitant modifier(Long id_habitant, Habitant habitant) {
        return habitantRepository.findById(id_habitant)
                .map(habitant1 -> {
                    habitant1.setDate(habitant.getDate());
                    habitant1.setNb_habitant(habitant.getNb_habitant());
                    return habitantRepository.save(habitant1);
                }).orElseThrow(() -> new RuntimeException("Habitant non trouve !"));
    }

    @Override
    public String supprimer(long id_habitant) {
        habitantRepository.deleteById(id_habitant);
        return "Habitant "+id_habitant+" Supprimer !";
    }
}
