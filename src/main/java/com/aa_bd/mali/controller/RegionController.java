package com.aa_bd.mali.controller;

import com.aa_bd.mali.modele.Region;
import com.aa_bd.mali.modele.massageError;
import com.aa_bd.mali.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = " Entité Region de API MaliTourist")
@RestController
@RequestMapping("/region")
@AllArgsConstructor
public class RegionController {

    @Autowired
    private final RegionService regionService;

    @ApiOperation(value = "Juste pour ajouter un région l'API MaliTourist")
   @PostMapping("/createregion")
    public Object create(@RequestBody Region region){
        try {
            return regionService.creer(region);
        }catch (Exception e){
            return massageError.ErreurResponse("la Region "+region.getNom()+" existe déjà", HttpStatus.OK, null);
        }

    }

    @ApiOperation(value = "Juste pour afficher la liste des régions de l'API MaliTourist")
    @GetMapping("/readregion")
    public List<Region> read(){
       return regionService.lire();
    }

    @ApiOperation(value = "Juste pour modifier une region de l'API MaliTourist")
    @PutMapping("/  ")
    public Region update(@PathVariable Long id_region, @RequestBody Region region){
       return regionService.modifier(id_region, region);
    }

    @ApiOperation(value = "Juste pour supprimer une region de  l'API MaliTourist")
    @DeleteMapping("/deleteregion/{id_region}")
    public String delete(@PathVariable Long id_region){

       return regionService.supprimer(id_region);
    }

    @ApiOperation(value = "Juste afficher les regions en précisant le pays de  l'API MaliTourist")
    @GetMapping("/listeRegionAvecPays")
    public Iterable<Object[]> lireFIND_REGION_AVEC_PAYS(){

        return regionService.lireFIND_REGION_AVEC_PAYS();
    }

    @ApiOperation(value = "Juste afficher les regions sans précisant le pays de  l'API MaliTourist")
    @GetMapping("/listeRegionSansPays")
    public Iterable<Object[]> lireFIND_REGION_SANS_PAYS(){

        return regionService.lireFIND_REGION_SANS_PAYS();
    }


}
