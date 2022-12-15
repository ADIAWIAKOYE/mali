package com.aa_bd.mali.service;

import com.aa_bd.mali.modele.Region;
import com.aa_bd.mali.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    @Override
    public Region creer(Region region) {
        return regionRepository.save(region);
    }



    @Override
    public List<Region> lire() {
        return regionRepository.findAll();
    }

    @Override
    public Iterable<Object[]> lireFIND_REGION_AVEC_PAYS() {
        return  regionRepository.FIND_REGION_AVEC_PAYS();
    }

    @Override
    public Iterable<Object[]> lireFIND_REGION_SANS_PAYS() {
        return  regionRepository.FIND_REGION_SANS_PAYS();
    }


    @Override
    public Region modifier(long id_region, Region region) {
        return regionRepository.findById(id_region)
                .map(region1 -> {
                    region1.setCode_region(region.getCode_region());
                    region1.setDoActivite(region.getDoActivite());
                    region1.setLanParle(region.getLanParle());
                    region1.setNom(region.getNom());
                    region1.setSuperficie(region.getSuperficie());
                    return regionRepository.save(region1);
                }).orElseThrow(() -> new RuntimeException("Region non trouver !"));
    }

    @Override
    public String supprimer(long id_region) {
        regionRepository.deleteById(id_region);
        return "Region "+id_region+" supprimer !";
    }
}
