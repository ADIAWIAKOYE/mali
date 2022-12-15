package com.aa_bd.mali.controller;

import com.aa_bd.mali.modele.Pays;
import com.aa_bd.mali.modele.massageError;
import com.aa_bd.mali.service.paysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Entité Pays de API MaliTourist")
@RestController
@RequestMapping("/Pays")
@AllArgsConstructor
public class paysController {

    @Autowired
    private final paysService paysService;

    @ApiOperation(value = "Juste pour ajouter un pays à l'API MaliTourist")
    @PostMapping("/create")
    public Object create(@RequestBody Pays pays) {
        try {
            return paysService.creer(pays);
        }catch (Exception e){
            return massageError.ErreurResponse("le Pays "+pays.getNom_pays()+" existe déjà", HttpStatus.OK, null);
        }
    }

    @ApiOperation(value = "Juste pour avoir la liste des pays de l'API MaliTourist")
    @GetMapping("/read")
    public List<Pays> read() {
        return paysService.lire();
    }

    @ApiOperation(value = "Juste pour modifier un pays de l'API MaliTourist")
    @PutMapping("/update/{id_pays}")
    public Pays update(@PathVariable Long id_pays, @RequestBody Pays pays){
        return paysService.modifier(id_pays, pays);
    }

    @ApiOperation(value = "Juste pour supprimer un pays de l'API MaliTourist")
    @DeleteMapping("/delete/{id_pays}")
    public String delete(@PathVariable Long id_pays){
        return paysService.supprimer(id_pays);
    }
}
