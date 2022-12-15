package com.aa_bd.mali.service;

import com.aa_bd.mali.modele.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {

    Region creer(Region region);


    List<Region> lire();

    Iterable<Object[]>lireFIND_REGION_AVEC_PAYS();

    Iterable<Object[]>lireFIND_REGION_SANS_PAYS();

    Region modifier(long id_region, Region region);

    String supprimer(long id_region);
}
