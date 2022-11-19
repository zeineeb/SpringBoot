package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;

import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IDepartementService;


import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/DepartementC")
public class DepartementController {

    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/")
    public Iterable<Departement>  GetAllDepartement(){
        return iDepartementService.retrieveAllDepartement();
    }
    @GetMapping("/DepartementById/{departement-id}")
    public Optional< Departement > GetDepartementbyId(@PathVariable("departement-id") Long Id){
        return iDepartementService.findDepartementById(Id);
    }

    @GetMapping("/DepartementByIdEtudaint/{departement-id}")
    public Set<Etudiant> GetDepartementbyIdEtudiant(@PathVariable("departement-id") Long Idd){
        return iDepartementService.getEtudiantsByDepar(Idd);
    }
    @PostMapping("/addDepartement")
    @ResponseBody
    public void addDepartement(@RequestBody Departement departement) {
        iDepartementService.ajouterDepartement(departement);
    }

    @PutMapping("/updateDepartement")
    @ResponseBody
    public void updateDepartement(@RequestBody Departement departement) {
        iDepartementService.updateDepartement(departement);
    }

    @DeleteMapping("/deleteDepartement/{departement-id}")
    @ResponseBody
    public void deleteDepartement(@PathVariable("departement-id") Long departementId ) {
        iDepartementService.deleteDepartement(departementId);
    }
}
