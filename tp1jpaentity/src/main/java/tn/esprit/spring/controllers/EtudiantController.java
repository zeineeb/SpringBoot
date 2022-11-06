package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IEtudiantService;

import java.util.Optional;

@RestController
@RequestMapping("/EtudiantC")
public class EtudiantController {
@Autowired
IEtudiantService etudiantService;

    // http://localhost:8089/Etudiant/add-Etudiant
    //{prenomE:"Ali", nomE:"Ali"}
    @GetMapping("/")
    public Iterable<Etudiant>  GetAllEtudiant(){
        return etudiantService.retrieveAllEtudiant();
    }
    @GetMapping("/EtudiantById/{etudiant-id}")
    public Optional< Etudiant > GetEtudiantbyId(@PathVariable("etudiant-id") Long Id){
        return etudiantService.findEtudiantById(Id);
    }
    @PostMapping("/addEtudiant")
    @ResponseBody
    public void addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.ajouter_etudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    @ResponseBody
    public void updateEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{etudiant-id}")
    @ResponseBody
    public void deleteEtudiant(@PathVariable("etudiant-id") Integer etudiantId ) {
        etudiantService.deleteEtudiant(etudiantId);
    }
}



