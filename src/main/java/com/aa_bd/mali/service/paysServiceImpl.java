package com.aa_bd.mali.service;

import com.aa_bd.mali.modele.Pays;
import com.aa_bd.mali.repository.paysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class paysServiceImpl implements paysService{

    private final paysRepository paysRepository;

    @Override
    public Pays creer(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id_pays, Pays pays) {
        return paysRepository.findById(id_pays)
                .map(pays1 -> {
                    pays1.setNom_pays(pays.getNom_pays());
                    return paysRepository.save(pays1);
                }).orElseThrow(() -> new RuntimeException("Pay non trouvé !"));
    }

    @Override
    public String supprimer(Long id_pays) {
        paysRepository.deleteById(id_pays);
        return "Pay Supprimer !";
    }
}
