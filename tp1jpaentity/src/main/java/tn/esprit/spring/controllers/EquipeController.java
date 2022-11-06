package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.services.IEquipeService;

import java.util.Optional;


@RestController
@RequestMapping("/EquipeC")
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;

    @GetMapping("/")
    public Iterable<Equipe>  GetAllEquipe(){
        return iEquipeService.retrieveAllEquipe();
    }
    @GetMapping("/EquipeById/{equipe-id}")
    public Optional< Equipe > GetEquipebyId(@PathVariable("equipe-id") Long Id){
        return iEquipeService.findEquipeById(Id);
    }
    @PostMapping("/addEquipe")
    @ResponseBody
    public void addEquipe(@RequestBody Equipe equipe) {
        iEquipeService.ajouterEquipe(equipe);
    }

    @PutMapping("/updateEquipe")
    @ResponseBody
    public void updateEquipe(@RequestBody Equipe equipe) {
        iEquipeService.updateEquipe(equipe);
    }

    @DeleteMapping("/deleteEquipe/{equipe-id}}")
    @ResponseBody
    public void deleteEquipe(@PathVariable("equipe-id}") Integer equipeId ) {
        iEquipeService.deleteEquipe(equipeId);
    }
}
