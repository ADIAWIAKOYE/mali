package com.aa_bd.mali.controller;

import com.aa_bd.mali.modele.Habitant;
import com.aa_bd.mali.modele.Pays;
import com.aa_bd.mali.service.HabitantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Entité Habitant de API MaliTourist")
@RestController
@RequestMapping("/Habitant")
@AllArgsConstructor
public class HabitantController {


    @Autowired
    private final HabitantService habitantService;

    @ApiOperation(value = "Juste pour ajouter le chiffre de la population pour l'API MaliTourist")
    @PostMapping("/createHabitant")
    public Habitant create(@RequestBody Habitant habitant){
        return habitantService.creer(habitant);
    }

    @ApiOperation(value = "Juste pour avoir la liste de tout les chiffres de population par date de l'API MaliTourist")
    @GetMapping("/readHabitant")
    public List<Habitant> read(){
        return habitantService.lire();
    }

    @ApiOperation(value = "Juste pour modifier un chiffre de population de  l'API MaliTourist")
    @PutMapping("/updateHabitant/{id_habitant}")
    public Habitant update(@PathVariable Long id_habitant, @RequestBody Habitant habitant){
        return habitantService.modifier(id_habitant, habitant);
    }

    @ApiOperation(value = "Juste pour supprimer un chiffre de population de l'API MaliTourist")
    @DeleteMapping("/deleteHabitant/{id_habitant}")
    public String delete(@PathVariable Long id_habitant){
        return habitantService.supprimer(id_habitant);
    }
}
